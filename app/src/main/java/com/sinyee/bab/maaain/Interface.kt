package com.sinyee.bab.maaain


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getDatadffff(): Response<CountryCodeJS>
}

interface HostInterface {
    @GET("const.json")
    suspend fun getDataDevggtgtgtgt(): Response<GeoDev>
}

class CountryRepo(private val countryApi: ApiInterface) {
    suspend fun getDatytttt() = countryApi.getDatadffff()
}
class DevRepo(private val devData: HostInterface) {
    suspend fun getDataDevgtgtgt() = devData.getDataDevggtgtgtgt()
}

@Keep
data class CountryCodeJS(
    @SerializedName("countryCode")
    val cougtgtgt: String,
)
@Keep
data class GeoDev(
    @SerializedName("ge")
    val geogtgttg: String,
    @SerializedName("vi")
    val viewgtgtgt: String,
    @SerializedName("aps")
    val appsCheckergtgtgtgt: String,
)