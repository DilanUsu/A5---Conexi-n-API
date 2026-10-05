package com.example.retrofit_demmo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_demmo.model.Coffee
import com.example.retrofit_demmo.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Estados posibles de la interfaz de usuario para la carga de cafés.
 */
sealed interface CoffeeUiState {
    object Loading : CoffeeUiState
    data class Success(val coffees: List<Coffee>) : CoffeeUiState
    data class Error(val message: String) : CoffeeUiState
}

/**
 * ViewModel encargado de gestionar el estado de la pantalla de cafés
 * y realizar la petición GET a la API mediante Retrofit.
 */
class CoffeeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<CoffeeUiState>(CoffeeUiState.Loading)
    val uiState: StateFlow<CoffeeUiState> = _uiState.asStateFlow()

    init {
        fetchCoffees()
    }

    /**
     * Realiza la consulta GET a la API en una corrutina y actualiza el estado.
     */
    fun fetchCoffees() {
        viewModelScope.launch {
            _uiState.value = CoffeeUiState.Loading
            try {
                val coffeeList = RetrofitClient.apiService.getCoffees()
                    .filter { !it.title.isNullOrBlank() }
                _uiState.value = CoffeeUiState.Success(coffeeList)
            } catch (e: Exception) {
                _uiState.value = CoffeeUiState.Error(
                    e.localizedMessage ?: "Error de conexión con el servidor"
                )
            }
        }
    }
}
