package com.godohdev.themoviedb.data.network

import android.accounts.NetworkErrorException
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.godohdev.themoviedb.utils.CoroutineContextProvider
import com.godohdev.themoviedb.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import kotlin.coroutines.coroutineContext

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

abstract class NetworkBoundResource<ResultType, RequestType>(private val coroutineScope: CoroutineContextProvider){
    private val result = MutableLiveData<Resource<ResultType>>()

    suspend fun build() : NetworkBoundResource<ResultType, RequestType> {
        withContext(coroutineScope.uiDispatcher()) { result.value =
            Resource.loading(null)
        }
        CoroutineScope(coroutineContext).launch(coroutineScope.bgDispatcher()){
            val dbResult = null
            if (shouldFetch(dbResult)){
                try {
                    fetchFromNetwork(dbResult)
                } catch (e: Exception){
                    when(e){
                        is NetworkErrorException, is UnknownHostException -> {
                            setValue(Resource.error("Tidak ada koneksi internet", dbResult))
                        }
                        else -> setValue(Resource.error(e.localizedMessage ?: "Maaf, terjadi kesalahan pada server", dbResult))
                    }
                }
            }else{
                setValue(Resource.success(dbResult))
            }
        }

        return this
    }

    private suspend fun fetchFromNetwork(dbResult: ResultType?) {
        setValue(Resource.loading(dbResult)) // Dispatch latest value quickly (UX purpose)
        createCallAsync().apply {
            if (isSuccessful) {
                body()?.let {
                    saveCallResult(processResponse(it))
                }
                setValue(Resource.success(null))
            } else {
                setValue(Resource.error(this.errorBody().toString(), null))
            }
        }
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) result.postValue(newValue)
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    @WorkerThread
    protected open fun processResponse(response: RequestType) = response

    @WorkerThread
    protected abstract suspend fun saveCallResult(item: RequestType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract suspend fun createCallAsync(): retrofit2.Response<RequestType>
}