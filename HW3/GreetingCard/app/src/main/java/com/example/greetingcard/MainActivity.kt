package com.example.greetingcard

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
            GreetingCardApp(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingCardPreview() { MaterialTheme { GreetingCardApp(Modifier.fillMaxSize()) } }

@Composable
fun GreetingCardApp(modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan, modifier = modifier.wrapContentSize(Alignment.TopStart)) {
        Text(stringResource(R.string.greeting), modifier = Modifier.padding(24.dp))
    }
}
