package com.dicoding.jetmycharacter.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.jetmycharacter.data.CharacterRepository
import com.dicoding.jetmycharacter.model.OrderCharacter
import com.dicoding.jetmycharacter.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: CharacterRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderCharacter>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderCharacter>>>
        get() = _uiState

    fun getAllCharacters() {
        viewModelScope.launch {
            repository.getAllCharacters()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderCharacters ->
                    _uiState.value = UiState.Success(orderCharacters)
                }
        }
    }
}