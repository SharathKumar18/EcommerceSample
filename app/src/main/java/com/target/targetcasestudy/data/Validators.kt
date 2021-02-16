package com.target.targetcasestudy.data

/**
 * For an explanation of how to validate credit card numbers read:
 *
 * https://www.freeformatter.com/credit-card-number-generator-validator.html#fakeNumbers
 *
 * This contains a breakdown of how this algorithm should work as
 * well as a way to generate fake credit card numbers for testing
 *
 * The structure and signature of this is open to modification, however
 * it *must* include a method, field, etc that returns a [Boolean]
 * indicating if the input is valid or not
 *
 * Additional notes:
 *  * This method does not need to validate the credit card issuer
 *  * This method must validate card number length (13 - 19 digits), but does not
 *    need to validate the length based on the issuer.
 *
 * @param creditCardNumber - credit card number of (13, 19) digits
 * @return true if a credit card number is believed to be valid,
 * otherwise false
 */
fun validateCreditCard(creditCardNumber: String): Boolean {
    if(creditCardNumber.isEmpty())return false
    val cardNumberList = ArrayList<Int>()

    try {
        for (i in 0..creditCardNumber.length-2) {
          cardNumberList.add(Integer.parseInt(creditCardNumber.get(i).toString()))
        }
        cardNumberList.reverse()
    } catch (nfe: NumberFormatException) {
        return false
    }
    if(cardNumberList.size==0)return false

    var cardIndex = 0
    while (cardIndex <= cardNumberList.size-1) {
        var cardNumber = cardNumberList[cardIndex]
        cardNumber *= 2
        if (cardNumber > 9) {
            cardNumber -= 9
        }
        cardNumberList[cardIndex] = cardNumber
        cardIndex += 2
    }

    var sum = 0
    for (i in cardNumberList.indices) {
        sum += cardNumberList[i]
    }
    return sum % 10 == Integer.parseInt(creditCardNumber[cardNumberList.size-1].toString())
}