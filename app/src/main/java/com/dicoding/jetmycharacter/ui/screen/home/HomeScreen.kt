package com.dicoding.jetmycharacter.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.jetmycharacter.di.Injection
import com.dicoding.jetmycharacter.model.OrderCharacter
import com.dicoding.jetmycharacter.ui.ViewModelFactory
import com.dicoding.jetmycharacter.ui.common.UiState
import com.dicoding.jetmycharacter.ui.component.CharacterItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllCharacters()
            }
            is UiState.Success -> {
                HomeContent(
                    orderCharacter = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    orderCharacter: List<OrderCharacter>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(orderCharacter) { data ->
            CharacterItem(
                name = data.character.name,
                photo = data.character.image,
                birth = data.character.birth,
                modifier = Modifier.clickable {
                    navigateToDetail(data.character.id)
                }
            )
        }
    }
}