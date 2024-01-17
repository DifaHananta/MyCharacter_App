package com.dicoding.jetmycharacter.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetmycharacter.R
import com.dicoding.jetmycharacter.ui.theme.JetMyCharacterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto_profil),
            contentDescription = "about_page",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .padding(start = 100.dp, end = 100.dp, top = 100.dp)
                .clip(CircleShape)
                .fillMaxWidth()
        )
        Text(
            text = "Difa Hananta Firdaus Am",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(
            text = "difahananta@gmail.com",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    JetMyCharacterTheme {
        AboutScreen()
    }
}
