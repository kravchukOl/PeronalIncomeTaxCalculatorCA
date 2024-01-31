package com.oleksiikravchuk.taxcalculatorcanada.calculators

import com.oleksiikravchuk.taxcalculatorcanada.models.Province

class FederalTax(
    private val personaFederalTaxCredit: Int,
    private val federalTaxBrackets: List<Pair<Int, Double>>,
    private val federalTaxReductionForQuebec: Double = 0.165
) : BaseIncomeTax() {

    fun getFederalTax(annualIncome: Double, province: Province): Double {
        return if (province.provinceName == "Quebec") {
            val commonFederalTax = calculateTaxCommonRates(
                annualIncome,
                federalTaxBrackets,
                personaFederalTaxCredit
            )
            commonFederalTax - commonFederalTax * federalTaxReductionForQuebec
        } else {
            calculateTaxCommonRates(
                annualIncome,
                federalTaxBrackets,
                personaFederalTaxCredit
            )
        }
    }

    fun getMarginalTaxRate(annualIncome: Double, province: Province): Double {
        if (annualIncome <= 0)
            return 0.0

        var marginalRate = 0.0
        for (i in 1 until federalTaxBrackets.size) {
            marginalRate = federalTaxBrackets[i - 1].second
            if (annualIncome <= federalTaxBrackets[i].first) {
                break
            }
        }
        if (annualIncome > federalTaxBrackets[federalTaxBrackets.size - 1].first) {
            marginalRate = federalTaxBrackets[federalTaxBrackets.size - 1].second
        }

        return if (province.provinceName == "Quebec")
            marginalRate - marginalRate * federalTaxReductionForQuebec
        else
            marginalRate
    }
}