package com.example.mycrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycrud.ui.theme.MycrudTheme

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<PlatillosViewModel>{}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MycrudTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier= Modifier.fillMaxSize()
                    ){
                      viewModel.getPlatillos()
                        ScreenCRUD(viewModel._listaPlatillos, viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenCRUD(listaPlatillos: ArrayList<Platillo>, viewModel: PlatillosViewModel){
    var id by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false)    }
    var textButton by remember { mutableStateOf("Agregar Platillo") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(12.dp)
    ){
        Column( modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){

            Formulario (
                idPlatillo = id,
                nombre = nombre,
                funNombre = {nombre = it},
                isEditando = isEditando,
                funIsEditando = { isEditando = false},
                textButton = textButton,
                funTextButton = { textButton = it },
                funResetCampos = {
                    nombre = ""
                },
                viewModel = viewModel
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                LazyColumn( contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
                    items (listaPlatillos) {platillo ->

                        CardPlatillo (
                            platillo = platillo,
                            funIdPlatillo = { id = it},
                            funNombre = { nombre = it},
                            funTextButton = { textButton = it},
                            funIsEditando = { isEditando = it },
                            funBorrarPlatillo = {
                                viewModel.deletePlatillo(platillo.idPlatillo)
                            }
                        )

                    }
                }
            }


        }
    }

}