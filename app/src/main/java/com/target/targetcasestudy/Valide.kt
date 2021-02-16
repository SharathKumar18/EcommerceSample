package com.target.targetcasestudy

/**
 * Created by  on 15/02/21.
 */
class Valide {
    fun getItem(str: String): Boolean {
        val cardNumberList = ArrayList<Int>(str.length)
        for (i in str.indices) {
            cardNumberList[i] = str.substring(i, i + 1).toInt()
        }

        var cardIndex = cardNumberList.size - 2
        while (cardIndex >= 0) {
            var cardNumber = cardNumberList[cardIndex]
            cardNumber *= 2
            if (cardNumber > 9) {
                cardNumber -= 9
            }
            cardIndex -= 2
            cardNumberList[cardIndex]=cardNumber
        }

        var sum = 0
        for (i in cardNumberList.indices) {
            sum += cardNumberList[i]
        }
        return sum % 10 == 0
    }
}