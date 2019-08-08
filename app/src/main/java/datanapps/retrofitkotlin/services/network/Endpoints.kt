package datanapps.retrofitkotlin.services.network

import datanapps.retrofitkotlin.services.users.model.Product
import datanapps.retrofitkotlin.services.users.model.ProductsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface Endpoints {
    @GET("products")
    fun getProductList(): Call<ProductsList>

   // @GET("api/v1/boxes/{boxID}")
    //fun getProductListById(@Path("productId") productId: String): Call<Product>


  //  @GET("api/v1/boxes")
    //fun getProductListRequireToken(@Header("x-api-key") key: String): Call<List<Product>>
}