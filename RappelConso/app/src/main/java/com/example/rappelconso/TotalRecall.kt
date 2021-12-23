package com.example.rappelconso

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.java.KoinJavaComponent.getKoin

class TotalRecall: Application() {
    override fun onCreate() {
        super.onCreate()

        //and start koin, the dependency injection framework
        startKoin {
            printLogger(Level.NONE)
            val modules = Module()
            modules(
                modules.applicationModule
            )
        }
    }
}