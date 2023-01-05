package com.sinyee.bab.vevvbbb

import android.app.Activity
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.C1ddd
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.MAIN_IDgtgt
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.deepLggtgt
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.myIdddd
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.urlMainggtgt
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import com.sinyee.bab.appppclas.MaiiinCLaaas.Companion.instIdgttg
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.sinyee.bab.databinding.ActivityBrosserBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class BrosserActivity : AppCompatActivity() {

    var hfgjrtgjhkh: ValueCallback<Array<Uri>>? = null
    var kgjfhdkxf: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hrfghrdssxc = ActivityBrosserBinding.inflate(layoutInflater)
        setContentView(hrfghrdssxc.root)

        jgidhgjdk = hrfghrdssxc.veeeeeeb
        gtkktkgtk()

        val cmngcmng = CookieManager.getInstance()
        cmngcmng.setAcceptCookie(true)
        cmngcmng.setAcceptThirdPartyCookies(jgidhgjdk, true)
        kiiokiikiik()
        val jikkiikik: Activity = this
        jgidhgjdk.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (hykhyohykohykhyk(url)) {

                        val hyhyhyhyhy = Intent(Intent.ACTION_VIEW)
                        hyhyhyhyhy.data = Uri.parse(url)
                        startActivity(hyhyhyhyhy)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
//                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                //Save the last visited URL
                hyhyhyhyhy(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(jikkiikik, description, Toast.LENGTH_SHORT).show()
            }


        }
        jgidhgjdk.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                hfgjrtgjhkh?.onReceiveValue(null)
                hfgjrtgjhkh = filePathCallback
                var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (takePictureIntent!!.resolveActivity(packageManager) != null) {

                    // create the file where the photo should go
                    var photoFile: File? = null
                    try {
                        photoFile = createImageFile()
                        takePictureIntent.putExtra("PhotoPath", kgjfhdkxf)
                    } catch (ex: IOException) {
                    }

                    if (photoFile != null) {
                        kgjfhdkxf = "file:" + photoFile.absolutePath
                        takePictureIntent.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile)
                        )
                    } else {
                        takePictureIntent = null
                    }
                }
                val selectionIntent = Intent(Intent.ACTION_GET_CONTENT)
                selectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
                selectionIntent.type = "image/*"
                val intents: Array<Intent?> =
                    takePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val gtgtgtgtgt = Intent(Intent.ACTION_CHOOSER)
                gtgtgtgtgt.putExtra(Intent.EXTRA_INTENT, selectionIntent)
                gtgtgtgtgt.putExtra(Intent.EXTRA_TITLE, "Pick your image")
                gtgtgtgtgt.putExtra(Intent.EXTRA_INITIAL_INTENTS, intents)
                startActivityForResult(
                    gtgtgtgtgt, ofjpeorjfperjg
                )
                return true
            }

            @Throws(IOException::class)
            private fun createImageFile(): File {
                var hyhhyhyhyhy = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!hyhhyhyhyhy.exists()) {
                    hyhhyhyhyhy.mkdirs()
                }

                hyhhyhyhyhy =
                    File(hyhhyhyhyhy.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return hyhhyhyhyhy
            }

        }

        jgidhgjdk.loadUrl(urururururururur())
    }

    private val ofjpeorjfperjg = 1

    private fun gtkktkgtk() {
        gtktkgtk()
    }

    private fun gtktkgtk() {
        Snackbar.make(
            hrfghrdssxc.root, "Loading...",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    lateinit var jgidhgjdk: WebView
    lateinit var hrfghrdssxc: ActivityBrosserBinding


    private fun pushToOneSignal(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val hyhyhyhyhy = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $hyhyhyhyhy"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val rrrrrrrrrrr =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $rrrrrrrrrrr"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val kikiikoooooooo = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $kikiikoooooooo"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    private fun kiiokiikiik() {
        val wstwstwstwst = jgidhgjdk.settings
        wstwstwstwst.javaScriptEnabled = true
        wstwstwstwst.useWideViewPort = true
        wstwstwstwst.loadWithOverviewMode = true
        wstwstwstwst.allowFileAccess = true
        wstwstwstwst.domStorageEnabled = true
        wstwstwstwst.userAgentString = wstwstwstwst.userAgentString.replace("; wv", "")
        wstwstwstwst.javaScriptCanOpenWindowsAutomatically = true
        wstwstwstwst.setSupportMultipleWindows(false)
        wstwstwstwst.displayZoomControls = false
        wstwstwstwst.builtInZoomControls = true
        wstwstwstwst.setSupportZoom(true)
        wstwstwstwst.pluginState = WebSettings.PluginState.ON
        wstwstwstwst.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        wstwstwstwst.setAppCacheEnabled(true)
        wstwstwstwst.allowContentAccess = true
    }

    private fun urururururururur(): String {

        val gtktgkgtkgt = "sub_id_1="
        val thrhtrhtrhtrht = "ad_id="

        val sharPre = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)



        val hyhyhyhyhy = intent
        val jjjujgtgihy = hyhyhyhyhy.getStringExtra("WebInt")



        val hijyijhyjiyhjhjy = sharPre.getString(myIdddd, null)
        val myInstId: String? = sharPre.getString(instIdgttg, null)

        val hyhujuujjuki = "com.sinyee.bab"

        val gbhnjj: String? = sharPre.getString(C1ddd, null)
        val hjujiki: String? = sharPre.getString(deepLggtgt, null)

        val fofofofofofofofofo = "sub_id_4="
        val fififififififififif = "sub_id_5="
        val sisisisifsisis = "sub_id_6="
        val mainIddddd: String? = sharPre.getString(MAIN_IDgtgt, "null")
        val afIdgtgtgtgt = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        val one = "deviceID="




        val lololololololo = "naming"
        val trololo = "deeporg"


        val kiokjjlikjhmkij = Build.VERSION.RELEASE

        val linkAB: String? = sharPre.getString(urlMainggtgt, null)

        var aft = ""

        when (jjjujgtgihy) {
            "deepLink" -> {
                aft ="$linkAB$gtktgkgtkgt$hjujiki&$one$afIdgtgtgtgt&$thrhtrhtrhtrht$mainIddddd&$fofofofofofofofofo$hyhujuujjuki&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$trololo"
                pushToOneSignal(hijyijhyjiyhjhjy.toString())
            }
            "campaign" -> {
                aft =
                    "$linkAB$gtktgkgtkgt$gbhnjj&$one$afIdgtgtgtgt&$thrhtrhtrhtrht$mainIddddd&$fofofofofofofofofo$hyhujuujjuki&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                pushToOneSignal(afIdgtgtgtgt.toString())
            }

        }

        return sharPre.getString("SAVED_URL", aft).toString()
    }

    fun hyhyhyhyhy(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (jujuuujju == "") {
                jujuuujju = getSharedPreferences(
                    "SHARED_PREF",
                    MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }


    private fun hykhyohykohykhyk(uri: String): Boolean {

        val gtuhghgugt = packageManager
        try {
            gtuhghgugt.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != ofjpeorjfperjg || hfgjrtgjhkh == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                // if there is not data, then we may have taken a photo
                results = arrayOf(Uri.parse(kgjfhdkxf))
            } else {
                val gtjjggtjgtj = data.dataString
                if (gtjjggtjgtj != null) {
                    results = arrayOf(Uri.parse(gtjjggtjgtj))
                }
            }
        }
        hfgjrtgjhkh?.onReceiveValue(results)
        hfgjrtgjhkh = null
    }


    private var exitexitexitexit = false
    override fun onBackPressed() {
        if (jgidhgjdk.canGoBack()) {
            if (exitexitexitexit) {
                jgidhgjdk.stopLoading()
                jgidhgjdk.loadUrl(jujuuujju)
            }
            this.exitexitexitexit = true
            jgidhgjdk.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                exitexitexitexit = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    var jujuuujju = ""


}
