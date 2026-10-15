package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) {
            ArtSpaceApp(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var artwork by rememberSaveable { mutableIntStateOf(1) }
    val image = when (artwork) { 1 -> R.drawable.art_1; 2 -> R.drawable.art_2; else -> R.drawable.art_3 }
    val title = when (artwork) { 1 -> R.string.title_1; 2 -> R.string.title_2; else -> R.string.title_3 }
    val artist = when (artwork) { 1 -> R.string.artist_1; 2 -> R.string.artist_2; else -> R.string.artist_3 }
    val year = when (artwork) { 1 -> R.string.year_1; 2 -> R.string.year_2; else -> R.string.year_3 }
    Column(modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        ArtworkWall(image, stringResource(title), Modifier.weight(1f).fillMaxWidth())
        ArtworkDescription(title, artist, year)
        DisplayController(
            onPrevious = { artwork = if (artwork == 1) 3 else artwork - 1 },
            onNext = { artwork = if (artwork == 3) 1 else artwork + 1 })
    }
}

@Composable
fun ArtworkWall(image: Int, title: String, modifier: Modifier = Modifier) {
    Surface(modifier, shadowElevation = 4.dp, color = Color.White) {
        Image(painterResource(image), title, Modifier.padding(24.dp).fillMaxSize(), contentScale = ContentScale.Fit)
    }
}

@Composable
fun ArtworkDescription(title: Int, artist: Int, year: Int, modifier: Modifier = Modifier) {
    Surface(modifier.fillMaxWidth(), color = Color(0xFFECEBF3)) {
        Column(Modifier.padding(16.dp)) {
            Text(stringResource(title), style = MaterialTheme.typography.headlineSmall)
            Text(stringResource(artist), fontWeight = FontWeight.Bold)
            Text(stringResource(year))
        }
    }
}

@Composable
fun DisplayController(onPrevious: () -> Unit, onNext: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Button(onClick = onPrevious, modifier = Modifier.weight(1f)) { Text(stringResource(R.string.previous)) }
        Button(onClick = onNext, modifier = Modifier.weight(1f)) { Text(stringResource(R.string.next)) }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() { MaterialTheme { ArtSpaceApp(Modifier.fillMaxSize()) } }
