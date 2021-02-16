package com.target.targetcasestudy.data.dealslist

import com.google.gson.annotations.SerializedName

/**
 * Created by  on 12/02/21.
 */

data class RegularPrice(
    @SerializedName("amount_in_cents")
    private var amountInCents: Int? = null,
    @SerializedName("currency_symbol")
    private var currencySymbol: String? = null,
    @SerializedName("display_string")
    var displayString: String? = null
)