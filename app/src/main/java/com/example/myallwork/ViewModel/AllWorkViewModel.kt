package com.example.myallwork.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myallwork.ApiService.ApiServise
import com.example.myallwork.Model.Items
import kotlinx.coroutines.launch

class AllWorkViewModel : ViewModel() {

    var listAllWorkLiveData: List<Items> by mutableStateOf(listOf())

    fun getAllWork() {
        viewModelScope.launch {
            val apiService = ApiServise.geInstance()
            val getAllWorkList = apiService.getAllServices()
            listAllWorkLiveData = getAllWorkList.items
        }
    }
}
