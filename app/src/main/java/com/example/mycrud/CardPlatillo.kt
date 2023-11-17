package com.example.mycrud

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CardPlatillo(
    funIdPlatillo: (String) -> Unit,
    funNombre: (String) -> Unit,
    funTextButton: (String) -> Unit,
    funIsEditando: (Boolean) -> Unit,
    platillo: Platillo,
    funBorrarPlatillo: (Int) -> Unit
) {

    Text(text = "aqui voy")
//    Card(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(20.dp),
//        elevation = CardDefaults.cardElevation(8.dp)
//    ){
//        Column(
//
//
//        )
//
//    }
}