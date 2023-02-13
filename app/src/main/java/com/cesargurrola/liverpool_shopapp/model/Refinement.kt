package com.cesargurrola.liverpool_shopapp.model

data class Refinement(
    val count: Int,
    val high: String,
    val label: String,
    val low: String,
    val refinementId: String,
    val searchName: String,
    val selected: Boolean,
    val type: String
)