package com.target.targetcasestudy.data.dealsdetail

import com.google.gson.annotations.SerializedName
import com.target.targetcasestudy.data.dealslist.RegularPrice
import com.target.targetcasestudy.data.dealslist.SalePrice

/**
 * Created by  on 12/02/21.
 */

data class DealDetailResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("aisle")
    val aisle: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("regular_price")
    val regularPrice: RegularPrice? = null,
    @SerializedName("sale_price")
    val salePrice: SalePrice? = null
)