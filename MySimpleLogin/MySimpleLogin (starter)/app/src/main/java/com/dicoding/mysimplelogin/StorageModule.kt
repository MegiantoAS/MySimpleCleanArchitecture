package com.dicoding.mysimplelogin

import android.content.Context
import com.capstone.core.SessionManager
import dagger.Module
import dagger.Provides

//    val storageModule = module {
//        factory {
//            SessionManager(get())
//        }
//
//        single {
//            UserRepository(get())
//        }
//    }

@Module
class StorageModule {
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}