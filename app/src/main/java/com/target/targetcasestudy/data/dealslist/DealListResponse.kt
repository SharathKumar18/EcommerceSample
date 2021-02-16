package com.target.targetcasestudy.data.dealslist

import com.google.gson.annotations.SerializedName

/**
 * Created by  on 12/02/21.
 */

data class DealListResponse(
    @SerializedName("products")
    var products: List<Product?>? = null
)