package com.oleksiikravchuk.taxcalculatorcanada.data

import com.oleksiikravchuk.taxcalculatorcanada.calculators.SalesTax
import com.oleksiikravchuk.taxcalculatorcanada.models.Province

object Rates2024 {


    // Federal Rates and Amounts:
    val federalTaxBrackets2023 = arrayOf(
        Pair(0, 0.15),
        Pair(55867, 0.205),
        Pair(111733, 0.26),
        Pair(173205, 0.29),
        Pair(246752, 0.33)
    )
    const val personaFederalTaxCredit2023: Int = 15705
    const val federalTaxReductionForQuebec = 0.165

    // Provincial Rates and Amounts:
    val provincesAndRates = arrayOf(
        Province(
            "Alberta",
            listOf(
                Pair(0, 0.1),
                Pair(148269, 0.12),
                Pair(177922, 0.13),
                Pair(227230, 0.14),
                Pair(355845, 0.15)
            ),
            21885,
            0.0812,
            0.0218,
            listOf(Pair(SalesTax.SaleTaxesType.GST, 0.05))
        ),
        Province(
            "British Columbia",
            listOf(
                Pair(0, 0.0506),
                Pair(47937, 0.077),
                Pair(95875, 0.105),
                Pair(110076, 0.1229),
                Pair(133664, 0.147),
                Pair(181232, 0.168),
                Pair(252752, 0.205),
            ),
            12580,
            0.12,
            0.0196,
            listOf(
                Pair(SalesTax.SaleTaxesType.GST, 0.05),
                Pair(SalesTax.SaleTaxesType.PST, 0.07)
            )
        ),
        Province(
            "Manitoba",
            listOf(
                Pair(0, 0.108),
                Pair(47000, 0.1275),
                Pair(10000, 0.174),
            ),
            15780,
            0.08,
            0.007837,
            listOf(
                Pair(SalesTax.SaleTaxesType.GST, 0.05),
                Pair(SalesTax.SaleTaxesType.PST, 0.07)
            )
        ),
        Province(
            "New Brunswick",
            listOf(
                Pair(0, 0.094),
                Pair(49958, 0.14),
                Pair(99916, 0.16),
                Pair(185064, 0.195),
            ),
            13044,
            0.14,
            0.0275,
            listOf(Pair(SalesTax.SaleTaxesType.HST, 0.15))
        ),
        Province(
            "Newfoundland and Labrador",
            listOf(
                Pair(0, 0.087),
                Pair(43198, 0.145),
                Pair(86395, 0.158),
                Pair(154244, 0.178),
                Pair(215943, 0.198),
                Pair(275870, 0.208),
                Pair(551739, 0.213),
                Pair(1103478, 0.218),
            ),
            10818,
            0.063,
            0.032,
            listOf(Pair(SalesTax.SaleTaxesType.HST, 0.15))
        ),
        Province(
            "Nova Scotia",
            listOf(
                Pair(0, 0.0879),
                Pair(29590, 0.1495),
                Pair(59180, 0.1667),
                Pair(93000, 0.175),
                Pair(150000, 0.21)
            ),
            8481,
            0.0885,
            0.0299,
            listOf(Pair(SalesTax.SaleTaxesType.HST, 0.15))
        ),
        Province(
            "Northwest Territories",
            listOf(
                Pair(0, 0.059),
                Pair(50597, 0.086),
                Pair(101198, 0.122),
                Pair(164525, 0.1405),
            ),
            17373,
            0.115,
            0.06,
            listOf(Pair(SalesTax.SaleTaxesType.GST, 0.05))
        ),
        Province(
            "Nunavut",
            listOf(
                Pair(0, 0.04),
                Pair(53268, 0.07),
                Pair(106537, 0.09),
                Pair(173205, 0.115)
            ),
            18767,
            0.0551,
            0.0261,
            listOf(Pair(SalesTax.SaleTaxesType.GST, 0.05))
        ),
        Province(
            "Ontario",
            listOf(
                Pair(0, 0.0505),
                Pair(514461, 0.0915),
                Pair(102894, 0.1116),
                Pair(150000, 0.1216),
                Pair(220000, 0.1316)
            ),
            12399,
            0.1,
            0.02863,
            listOf(Pair(SalesTax.SaleTaxesType.HST, 0.13))
        ),
        Province(
            "Prince Edward Island",
            listOf(
                Pair(0, 0.0965),
                Pair(32656, 0.1363),
                Pair(64313, 0.1665),
                Pair(105000, 0.18),
                Pair(140000, 0.1875),
            ),
            13500,
            0.105,
            0.013,
            listOf(Pair(SalesTax.SaleTaxesType.HST, 0.15))
        ),
        Province(
            "Quebec",
            listOf(
                Pair(0, 0.14),
                Pair(51710, 0.19),
                Pair(103545, 0.24),
                Pair(126000, 0.2575),
            ),
            18056,
            0.117,
            0.0342,
            listOf(
                Pair(SalesTax.SaleTaxesType.GST, 0.05),
                Pair(SalesTax.SaleTaxesType.QST, 0.0985)
            )
        ),
        Province(
            "Saskatchewan",
            listOf(
                Pair(0, 0.105),
                Pair(52057, 0.125),
                Pair(1487348, 0.145),
            ),
            18491,
            0.11,
            0.02105,
            listOf(
                Pair(SalesTax.SaleTaxesType.GST, 0.05),
                Pair(SalesTax.SaleTaxesType.PST, 0.06)
            )
        ),
        Province(
            "Yukon",
            listOf(
                Pair(0, 0.064),
                Pair(55867, 0.09),
                Pair(111733, 0.109),
                Pair(173205, 0.1293),
                Pair(246752, 0.128),
                Pair(500000, 0.15)
            ),
            15705,
            0.1202,
            0.0067,
            listOf(Pair(SalesTax.SaleTaxesType.GST, 0.05))
        ),
    )

    val ontarioSurtaxRates2023 = arrayOf(
        Pair(5554, 0.2),
        Pair(7108, 0.36)
    )
    val princeEdwardSurtaxRates2023 = arrayOf(
        Pair(0, 0)
    )


    // Dividends Rates:

    const val eligibleGrossUpRate = 1.38
    const val nonEligibleGrossUpRate = 1.15

    const val federalEligibleTaxCreditRate = 0.150198
    const val federalNonEligibleTaxCreditRate = 0.90301

    // Employments Insurance Rates and Amounts:

    val federalEmploymentInsuranceRates2023 = Pair(61500, 0.0163)
    val quebecEmploymentInsuranceRates2023 = Pair(61500, 0.0127)

    // Pension Plan Rates and Amounts:

    val canadaPensionPlanRates2023 = Pair(63100, 0.0595)
    val quebecPensionPlanRates2023 = Pair(66600, 0.054)
    const val basicExemptionAmountCPP = 3500


}