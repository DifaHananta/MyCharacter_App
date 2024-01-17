package com.dicoding.jetmycharacter.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.jetmycharacter.di.Injection
import com.dicoding.jetmycharacter.ui.ViewModelFactory
import com.dicoding.jetmycharacter.ui.common.UiState

@Composable
fun DetailScreen(
    characterId: Long,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getCharacterById(characterId)
            }
            is  UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    name = data.character.name,
                    image = data.character.image,
                    description = data.character.description,
                    birth = data.character.birth,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    name: String,
    image: Int,
    description: String,
    birth: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(
            text = birth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(
            text = description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

