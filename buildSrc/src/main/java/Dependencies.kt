/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

object ApplicationId {
    const val id = "com.godohdev.themoviedb"
}

object Versions {
    const val kotlinVersion = "1.3.61"
    const val gradleVersion = "3.5.0"
    const val minSdk = 21
    const val compiledSdk = 29
    const val targetSdk = 29
    const val versionCode = 1
    const val coreKtx = "1.2.0"
    const val constraintLayout = "1.1.3"
    const val jUnitTest = "4.12"
    const val daggerVersion = "2.24"
    const val appCompact = "1.1.0"

    const val gson = "2.8.5"
    const val okHttp = "3.12.1"
    const val retrofit = "2.7.1"
    const val rxKotlin = "2.4.0"
    const val anko = "0.10.8"
    const val material = "1.0.0"
    const val coroutine="1.3.2"
    const val coroutineAndroid = "1.3.2"
    const val lifecycle = "2.1.0-alpha04"
    const val roomVersion = "2.2.3"
    const val glide = "4.10.0"
}

object Release {
    const val versionName = "1.0"
}

object AndroidLibraries {
    const val anko = "org.jetbrains.anko:anko:${Versions.anko}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val daggerAnnotation = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val appCompact = "androidx.appcompat:appcompat:${Versions.appCompact}"

    // RETROFIT
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"

    const val roomRuntime = "android.arch.persistence.room:runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomtest = "androidx.room:room-testing:${Versions.roomVersion}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroid}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
}