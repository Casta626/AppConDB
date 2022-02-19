package com.example.entregable2fragmentos

data class Propiedades(
    val id: String,
    val title: String
) {
    override fun toString(): String {
        return title
    }
}