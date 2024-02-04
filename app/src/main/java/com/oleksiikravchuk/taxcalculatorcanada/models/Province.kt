package com.oleksiikravchuk.taxcalculatorcanada.models

import com.oleksiikravchuk.taxcalculatorcanada.calculators.SalesTax

class Province(
    val provinceName: String,
    val provinceTaxRates: List<Pair<Int, Double>>,
    val provinceTaxCredit: Int,
    val eligibleTaxCreditRate: Double,
    val nonEligibleTaxCreditRate: Double,
    var salesTaxRates: List<Pair<SalesTax.SaleTaxesType,Double>>
)