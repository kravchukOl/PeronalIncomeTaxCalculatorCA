package com.oleksiikravchuk.taxcalculatorcanada.ui.util

import com.oleksiikravchuk.taxcalculatorcanada.R

fun getProvinceFlagDrawableId(provinceName : String) = when (provinceName) {
    "Alberta" -> R.drawable.flag_of_alberta
    "British Columbia" -> R.drawable.flag_of_british_columbia
    "Manitoba" -> R.drawable.flag_of_manitoba
    "New Brunswick" -> R.drawable.flag_of_new_brunswick
    "Newfoundland and Labrador" -> R.drawable.flag_of_newfoundland_and_labrador
    "Nova Scotia" -> R.drawable.flag_of_nova_scotia
    "Northwest Territories" -> R.drawable.flag_of_the_northwest_territories
    "Nunavut" -> R.drawable.flag_of_nunavut
    "Ontario" -> R.drawable.flag_of_ontario
    "Prince Edward Island" -> R.drawable.flag_of_prince_edward_island
    "Quebec" -> R.drawable.flag_of_quebec
    "Saskatchewan" -> R.drawable.flag_of_saskatchewan
    "Yukon" -> R.drawable.flag_of_yukon
    else -> R.drawable.ic_canada_32
}
