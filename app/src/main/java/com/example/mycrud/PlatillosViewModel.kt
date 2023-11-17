package com.example.mycrud

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlatillosViewModel: ViewModel() {

    var _listaPlatillos: ArrayList<Platillo> by mutableStateOf(arrayListOf())

    fun getPlatillos(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.getPlatillos()
                withContext(Dispatchers.Main){
                    if(response.body()!!.codigo == "200"){
                        _listaPlatillos = response.body()!!.data
                    }
                }
        }
    }

    fun addPlatillo(platillo: Platillo){
        viewModelScope.launch(Dispatchers.IO){
            val response  = RetrofitClient.webService.addPlatillo(platillo)
            withContext(Dispatchers.Main){
                if(response.body()!!.codigo == "200"){
                    getPlatillos()
                }
            }
        }
    }

    fun updatePlatillo(idPlatillo: Int, platillo:Platillo){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.updatePlatillo(idPlatillo, platillo)
            withContext(Dispatchers.Main){
                if(response.body()!!.codigo == "200"){
                    getPlatillos()
                }
            }
        }
    }


    fun deletePlatillo(idPlatillo: Int) {
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.deletePlatillo(idPlatillo)
            withContext(Dispatchers.Main){
                if(response.body()!!.codigo == "200"){
                    getPlatillos()
                }
            }
        }
    }



}