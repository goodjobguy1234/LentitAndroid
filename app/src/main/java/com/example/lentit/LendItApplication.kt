package com.example.lentit

import android.app.Application
import com.example.lentit.di.Modules
import org.koin.core.context.startKoin

class LendItApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(modules = Modules)
        }
    }
}