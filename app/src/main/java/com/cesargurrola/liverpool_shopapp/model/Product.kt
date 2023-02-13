package com.cesargurrola.liverpool_shopapp.model

data class Product(
    var image : Int,
    var nombre : String ?= null,
    var precio_sin_dcto : String ?= null,
    var precio_con_dcto : String ?= null,
    var colores : String ?= null
)
