package com.oleksiikravchuk.taxcalculatorcanada.calculators

import com.oleksiikravchuk.taxcalculatorcanada.models.Province

class ProvincialTax(
    private val provincialTaxBrackets : List<Province>,
    private val ontarioSurtaxRates : List<Pair<Int,Double>>,
    private val princeEdwardSurtaxRates : List<Pair<Int, Double>>
) : BaseIncomeTax() {

    fun getProvinceTax(annualIncome: Double, province: Province): Double {
        return when (province.provinceName) {
            "Ontario" -> {
                val provinceTax = calculateTaxCommonRates(
                    annualIncome,
                    province.provinceTaxRates,
                    province.provinceTaxCredit
                )
                provinceTax + getSurtax(provinceTax, ontarioSurtaxRates)
            }
            "Prince Edward Island" -> {
                val provinceTax = calculateTaxCommonRates(
                    annualIncome,
                    province.provinceTaxRates,
                    province.provinceTaxCredit
                )
                provinceTax + getSurtax(provinceTax, princeEdwardSurtaxRates)
            }
            else ->
                calculateTaxCommonRates(
                    annualIncome,
                    province.provinceTaxRates,
                    province.provinceTaxCredit
                )
        }
    }

    fun getSurtaxForOntario(baseOntarioProvinceTax: Double): Double {
        if (baseOntarioProvinceTax <= ontarioSurtaxRates[0].first) {
            return 0.0
        }
        return if (baseOntarioProvinceTax <= ontarioSurtaxRates[1].first) {
            (baseOntarioProvinceTax - ontarioSurtaxRates[0].first) * ontarioSurtaxRates[0].second
        } else {
            val firstTier =
                (ontarioSurtaxRates[1].first - ontarioSurtaxRates[0].first) * ontarioSurtaxRates[0].second
            val secondTier =
                (baseOntarioProvinceTax - ontarioSurtaxRates[1].first) * ontarioSurtaxRates[1].second
            firstTier + secondTier
        }
    }

    private fun getSurtax(provinceTax: Double, surtaxRates: List<Pair<Int, Double>>): Double {
        if (provinceTax <= surtaxRates[0].first)
            return 0.0

        var surTax = 0.0

        for (i in surtaxRates.indices) {
            if (i == surtaxRates.size - 1) {
                surTax += (provinceTax - surtaxRates[i].first) * surtaxRates[i].second
                break
            }
            if (provinceTax <= surtaxRates[i + 1].first) {
                surTax += (provinceTax - surtaxRates[i].first) * surtaxRates[i].second
                break
            } else {
                surTax += (surtaxRates[i + 1].first - surtaxRates[i].first) * surtaxRates[i].second
            }
        }
        return surTax
    }


    fun getMarginalTaxRate(annualIncome: Double, province: Province): Double {
        if (annualIncome <= 0)
            return 0.0

        if (annualIncome > province.provinceTaxRates[province.provinceTaxRates.size - 1].first) {
            return province.provinceTaxRates[province.provinceTaxRates.size - 1].second
        }

        var marginalRate = 0.0
        for (i in 1 until province.provinceTaxRates.size) {
            marginalRate = province.provinceTaxRates[i - 1].second
            if (annualIncome <= province.provinceTaxRates[i].first) {
                break
            }
        }
        return marginalRate
    }
}