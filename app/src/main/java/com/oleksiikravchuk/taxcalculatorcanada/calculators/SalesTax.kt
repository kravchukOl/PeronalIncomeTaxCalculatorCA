package com.oleksiikravchuk.taxcalculatorcanada.calculators

import com.oleksiikravchuk.taxcalculatorcanada.models.Province
import kotlin.math.floor

class SalesTax ( private val province: Province) {
    fun getSalesTaxList(
        baseAmount: Double,
        province: Province
    ): List<Pair<SaleTaxesType, Double>> {
        val taxesList = mutableListOf<Pair<SaleTaxesType, Double>>()
        for (item in province.salesTaxRates) {
            taxesList.add(Pair(item.first, roundToCents( baseAmount * item.second )))
        }
        return taxesList.toList()

    }

    fun getTotalAmount(baseAmount: Double, province: Province) : Double {
        var totalAmount = baseAmount
        for( item in this.getSalesTaxList(baseAmount, province)) {
            totalAmount += item.second
        }
        return totalAmount
    }

    private fun roundToCents( amount : Double ) = floor(amount * 100 + 0.5) / 100

    enum class SaleTaxesType {
        HST,
        GST,
        PST,
        QST
    }
}