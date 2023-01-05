package com.sinyee.bab.appppclas

import android.app.Application
import android.content.Context
import com.onesignal.OneSignal
import com.sinyee.bab.maaain.appModulefgtgtgtgt
import com.sinyee.bab.maaain.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import java.util.*

class MaiiinCLaaas:Application() {
    companion object {


        var C1ddd: String? = "c11"
        val codeCodegtgtgt: String = "uff"
        val deepLggtgt: String = "deepL"
        var instIdgttg: String? = "instID"
        const val ONESIGNAL_APP_IDdddd = "f204b6e7-f044-4dfb-a375-cc43527ffe16"
        var urlMainggtgt: String = "link"
        var MAIN_IDgtgt: String? = "main_id"
        val appsCheckChefrrf: String = "appsCheckChe"
        val geoCogtgtgt: String = "geoCo"
        val myIdddd: String = "myID"


    }

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val hhyhyhyhy = getSharedPreferences("PREFS_NAME", 0)
        val hyhjuujuj = UUID.randomUUID().toString()

        if (hhyhyhyhy.getBoolean("my_first_time", true)) {

            sharedPreferences.edit().putString(myIdddd, hyhjuujuj).apply()

            hhyhyhyhy.edit().putBoolean("my_first_time", false).apply()
        }

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MaiiinCLaaas)
            modules(
                listOf(
                    viewModelModule, appModulefgtgtgtgt
                )
            )
        }

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        gktgktkgtgtkgtk()
    }

    private fun gktgktkgtgtkgtk() {
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_IDdddd)
    }
}
