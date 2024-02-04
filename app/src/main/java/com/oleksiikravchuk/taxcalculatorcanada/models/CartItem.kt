package com.oleksiikravchuk.taxcalculatorcanada.models

data class CartItem(
    val subTotal: Double,
    val taxes: Double,
    val total: Double,
    var tag: String = ""
)