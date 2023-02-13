package com.cesargurrola.liverpool_shopapp.utils

import java.text.DecimalFormat


fun Double.formatCurrency(): String {
    val format = DecimalFormat("$ #,###.00")
    format.isDecimalSeparatorAlwaysShown = false
    return format.format(this).toString()
}