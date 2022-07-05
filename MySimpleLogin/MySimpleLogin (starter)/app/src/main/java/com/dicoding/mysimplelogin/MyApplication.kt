package com.dicoding.mysimplelogin

import android.app.Application
import com.dicoding.mysimplelogin.di.AppComponent
import com.dicoding.mysimplelogin.di.DaggerAppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class MyApplication : Application() {
//    override fun onCreate() {
//        super.onCreate()
//        startKoin {
//            androidContext(this@MyApplication)
//            modules(storageModule)
//        }
//    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }
}