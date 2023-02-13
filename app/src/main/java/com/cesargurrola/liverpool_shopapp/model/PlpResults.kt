package com.cesargurrola.liverpool_shopapp.model

data class PlpResults(
    val customUrlParam: CustomUrlParam,
    val label: String,
    val navigation: Navigation,
    val plpState: PlpState,
    val records: MutableList<Record>,
    val refinementGroups: List<RefinementGroup>,
    val sortOptions: List<SortOption>
)