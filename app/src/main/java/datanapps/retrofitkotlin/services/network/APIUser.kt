package datanapps.retrofitkotlin.services.network

import datanapps.retrofitkotlin.services.users.model.BaseUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * API for getting weather from https://darksky.net/
 */
interface APIUser {

    @GET("fortniteusers")
    fun getUserList(@QueryMap options: Map<String, String>): Call<BaseUser>
}
