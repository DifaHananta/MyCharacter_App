package com.dicoding.jetmycharacter.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.jetmycharacter.data.CharacterRepository
import com.dicoding.jetmycharacter.model.OrderCharacter
import com.dicoding.jetmycharacter.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: CharacterRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderCharacter>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderCharacter>>
        get() = _uiState

    fun getCharacterById(characterId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderCharacterById(characterId))
        }
    }

}