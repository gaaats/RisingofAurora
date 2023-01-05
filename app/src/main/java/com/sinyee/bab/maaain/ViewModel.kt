package com.sinyee.bab.maaain

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.sinyee.bab.appppclas.MaiiinCLaaas
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.C1ddd
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.MAIN_IDgtgt
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.deepLggtgt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(
    private val gtgtgtgtgt: CountryRepo,
    private val jukikikii: DevRepo,
    private val hyjujuuj: SharedPreferences,
    private val vfvfvfvfvfvf: Application
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            gtkgtkgtkgt()
        }
    }

    private fun gtkgtkgtkgt() {
        getAdvertisingIdClient()
    }


    private val _countryCodeeeee = MutableLiveData<CountryCodeJS>()
    val countryCode: LiveData<CountryCodeJS>
        get() = _countryCodeeeee

    private val mutableLiveData = MutableLiveData<GeoDev>()
    val geoGode: LiveData<GeoDev>
        get() = mutableLiveData

    suspend fun getData() {
        val counr = gtgtgtgtgt.getDatytttt().body()?.cougtgtgt.toString()
        Log.d("counr", "getData: $counr")
        hyjujuuj.edit().putString(MaiiinCLaaas.codeCodegtgtgt, counr).apply()
        getDevData()
    }

    suspend fun getDevData() {
        val goggtgt = jukikikii.getDataDevgtgtgt().body()?.geogtgttg
        val linkfrfrf = jukikikii.getDataDevgtgtgt().body()?.viewgtgtgt
        val apsCgtgtgt = jukikikii.getDataDevgtgtgt().body()?.appsCheckergtgtgtgt

        hyjujuuj.edit().putString(MaiiinCLaaas.urlMainggtgt, linkfrfrf).apply()
        hyjujuuj.edit().putString(MaiiinCLaaas.appsCheckChefrrf, apsCgtgtgt).apply()
        hyjujuuj.edit().putString(MaiiinCLaaas.geoCogtgtgt, goggtgt).apply()
    }

    fun pedor(sawdefrghj: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            sawdefrghj
        ) { data: AppLinkData? ->
            data?.let {
                val gthyhyhyhyhyhy = data.targetUri.host.toString()
                hyjujuuj.edit().putString(deepLggtgt, gthyhyhyhyhyhy).apply()
            }
        }
    }

    fun initAppsFlyerLib(context: Context) {
        AppsFlyerLib.getInstance()
            .init("KeVrveKfFZcvGoxW9BfNoC", conversionDataListener, vfvfvfvfvfvf)
        AppsFlyerLib.getInstance().start(context)
    }

    val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            hyjujuuj.edit().putString(C1ddd, dataGotten).apply()
        }

        override fun onConversionDataFail(p0: String?) {}
        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
        override fun onAttributionFailure(p0: String?) {}
    }

    fun getAdvertisingIdClient() {
        val gtgtgtgtgtgtgt = AdvertisingIdClient(vfvfvfvfvfvf)
        gtgtgtgtgtgtgt.start()
        val hjuujujuj = gtgtgtgtgtgtgt.info.id
        hyjujuuj.edit().putString(MAIN_IDgtgt, hjuujujuj).apply()
        Log.d("AdvertId", "getAdvertisingIdClient: $hjuujujuj")
    }


}
