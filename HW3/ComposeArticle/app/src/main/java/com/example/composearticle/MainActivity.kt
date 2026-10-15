package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) {
            ComposeArticleApp(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() { MaterialTheme { ComposeArticleApp(Modifier.fillMaxSize()) } }

@Composable
fun ComposeArticleApp(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Image(painterResource(R.drawable.compose_background), null, Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Text(stringResource(R.string.title), fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(stringResource(R.string.intro), textAlign = TextAlign.Justify, modifier = Modifier.padding(horizontal = 16.dp))
        Text(stringResource(R.string.body), textAlign = TextAlign.Justify, modifier = Modifier.padding(16.dp))
    }
}
