package com.example.mycrud

data class PlatillosResponse(
    var codigo: String,
    var mensaje: String,
    var data: ArrayList<Platillo>
)
