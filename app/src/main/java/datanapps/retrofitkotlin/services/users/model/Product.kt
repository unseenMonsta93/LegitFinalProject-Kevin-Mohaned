package datanapps.retrofitkotlin.services.users.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(
        @Expose
        var id: String,


    @Expose
    var length: String,

    @Expose
    var width: String,

    @Expose
    var height: String,

    @Expose
    var profileImage: String)
