package com.godohdev.themoviedb.data.local

import com.godohdev.themoviedb.data.local.dao.MoviesDao
import javax.inject.Inject

/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

class LocalDataSourceImpl @Inject constructor(
    private  var moviesDao: MoviesDao
) : LocalDataSource {

}