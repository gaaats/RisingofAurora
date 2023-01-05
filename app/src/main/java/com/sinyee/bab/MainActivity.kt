package com.sinyee.bab

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sinyee.bab.accccttiiiv.StartyyyActivity
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.C1ddd
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.appsCheckChefrrf
import com.sinyee.bab.maaain.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gtkogtkgtkgt()
        gttjgtjigtji()

        checkAppps()

        GlobalScope.launch (Dispatchers.IO){
            viewMainModel.getData()
        }

    }

    private fun gttjgtjigtji() {
        viewMainModel.initAppsFlyerLib(this@MainActivity)
    }

    private fun gtkogtkgtkgt() {
        viewMainModel.pedor(this@MainActivity)
    }

    val viewMainModel by viewModel<ViewModel>()
    val shareP: SharedPreferences by inject(named("SharedPreferences"))
    fun checkAppps() {
        val executorService = Executors.newSingleThreadScheduledExecutor()
        val exr = Executors.newSingleThreadScheduledExecutor()
        var appsChe = shareP.getString(appsCheckChefrrf, null)
        var appsCamp = shareP.getString(C1ddd, null)

        exr.scheduleAtFixedRate({
            if (appsChe != null) {
                Log.d("appsChec", "checkAppps:$appsChe ")
                exr.shutdownNow()
                when (appsChe) {
                    "1" ->
                        executorService.scheduleAtFixedRate({
                            if (appsCamp != null) {
                                executorService.shutdownNow()
                                nextAct()
                            } else {
                                appsCamp = shareP.getString(C1ddd, null)
                            }
                        }, 0, 1, TimeUnit.SECONDS)
                    else ->
                        nextAct()
                }
            } else {
                Log.d("appsChec", "checkAppps:$appsChe ")
                appsChe = shareP.getString(appsCheckChefrrf, null)
            }
        }, 0, 1, TimeUnit.SECONDS)
    }

    fun nextAct() {
        val intentNext = Intent(this@MainActivity, StartyyyActivity::class.java)
        startActivity(intentNext)
        finish()
    }



}