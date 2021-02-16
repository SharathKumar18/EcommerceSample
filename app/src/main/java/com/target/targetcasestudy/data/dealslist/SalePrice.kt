package com.target.targetcasestudy.data.dealslist

import com.google.gson.annotations.SerializedName

/**
 * Created by  on 12/02/21.
 */

data class SalePrice(
    @SerializedName("amount_in_cents")
    val amountInCents: Int? = null,
    @SerializedName("currency_symbol")
    val currencySymbol: String? = null,
    @SerializedName("display_string")
    val displayString: String? = null
)