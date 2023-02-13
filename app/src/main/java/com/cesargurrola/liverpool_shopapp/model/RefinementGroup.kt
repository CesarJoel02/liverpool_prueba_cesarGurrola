package com.cesargurrola.liverpool_shopapp.model

data class RefinementGroup(
    val dimensionName: String,
    val multiSelect: Boolean,
    val name: String,
    val refinement: List<Refinement>
)