package com.target.targetcasestudy.data.dealslist

import com.google.gson.annotations.SerializedName

/**
 * Created by  on 12/02/21.
 */
data class Product(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("aisle")
    var aisle: String? = null,
    @SerializedName("description")
    private var description: String? = null,
    @SerializedName("image_url")
    var imageUrl: String? = null,
    @SerializedName("regular_price")
    var regularPrice: RegularPrice? = null,
    @SerializedName("sale_price")
    var salePrice: SalePrice? = null
)