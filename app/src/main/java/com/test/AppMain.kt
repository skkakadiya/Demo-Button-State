package com.test

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * Created by Sanjay on 18/6/20.
 */
class AppMain : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@AppMain))
        bind() from provider { MainViewModelFactory() }

    }
}