package com.sinyee.bab.accccttiiiv


import com.sinyee.bab.appppclas.MaiiinCLaaas
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.appsCheckChefrrf
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.codeCodegtgtgt
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.deepLggtgt
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.geoCogtgtgt
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sinyee.bab.R
import com.sinyee.bab.vevvbbb.BrosserActivity
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class StartyyyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startyyy)

        getSharedData()
    }

    lateinit var hyhyhyhy: String
    lateinit var ddfee: String
    lateinit var dep: String
    lateinit var hyjikiol: String
    lateinit var vfbgnhnhn: String

    val sharedPreferences: SharedPreferences by inject(named("SharedPreferences"))

    fun getSharedData() {

        dep = sharedPreferences.getString(deepLggtgt, null).toString()
        hyhyhyhy = sharedPreferences.getString(MaiiinCLaaas.C1ddd, null).toString()
        hyjikiol = sharedPreferences.getString(appsCheckChefrrf, null).toString()
        vfbgnhnhn = sharedPreferences.getString(geoCogtgtgt, null).toString()
        ddfee = sharedPreferences.getString(codeCodegtgtgt, null).toString()

        sorthgtgtgtgtgt()
    }

    private fun gtkgtkgtktgktg(intentNorm: Intent) {
        intentNorm.putExtra("WebInt", "deepLink")
    }


    fun sorthgtgtgtgtgt() {
        val intentNorm = Intent(this@StartyyyActivity, BrosserActivity::class.java)

        if(hyjikiol=="1") {
            if(hyhyhyhy.contains("tdb2")&&dep.contains("tdb2")) {
                gtgtgtgtgttggt(intentNorm)
            } else if (hyhyhyhy.contains("tdb2")|| vfbgnhnhn.contains(ddfee)) {
                intentNorm.putExtra("WebInt", "campaign")
                startActivity(intentNorm)
                finish()
            } else if (dep.contains("tdb2") && !hyhyhyhy.contains("tdb2")) {
                intentNorm.putExtra("WebInt", "deepLink")
                startActivity(intentNorm)
                gtkgtkgtkgtk()
            }
            else {
                gtkgtkgtgtkogtkgt()
            }
        } else {
            if (dep.contains("tdb2")) {
                gtkgtkgtktgktg(intentNorm)
                startActivity(intentNorm)
                finish()
            } else {
                gtkgtkgtgtkogtkgt()
            }
        }
    }


    private fun gtkgtkgtgtkogtkgt() {
        startActivity(Intent(this, SeeecondActivity::class.java))
        finish()
    }

    private fun gtgtgtgtgttggt(intentNorm: Intent) {
        intentNorm.putExtra("WebInt", "campaign")
        startActivity(intentNorm)
        finish()
    }

    private fun gtkgtkgtkgtk() {
        finish()
    }
}
