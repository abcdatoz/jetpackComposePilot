package com.example.mycrud

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulario (
    idPlatillo: Int,
    nombre:  String,
    funNombre: (String) -> Unit,
    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    funResetCampos: () -> Unit,
    viewModel: PlatillosViewModel
){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label =  { Text (text = "Nombre") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (isEditando){
                    viewModel.updatePlatillo(
                        idPlatillo = idPlatillo,
                        Platillo(
                            id = idPlatillo,
                            nombre = nombre,
                            clave = "001",
                            descripcion = "...",
                            calorias = "58 cal",
                            minutospreparacion = "10 min",
                            imagen = ""
                        )
                    )

                    funTextButton("Agregar Platillo")
                    funIsEditando()
                }else{
                    viewModel.addPlatillo(Platillo(
                        id = 0,
                        nombre = nombre,
                        clave = "001",
                        descripcion = "...",
                        calorias = "58 cal",
                        minutospreparacion = "10 min",
                        imagen = ""
                    ))
                }
                funResetCampos()

            }) {

                Text(text =  textButton)

    }

}