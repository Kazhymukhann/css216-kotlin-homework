package com.example.happybirthday

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
            HappyBirthdayApp(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Preview(showBackground = true)
@Composable
fun HappyBirthdayPreview() { MaterialTheme { HappyBirthdayApp(Modifier.fillMaxSize()) } }

@Composable
fun HappyBirthdayApp(modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(painterResource(R.drawable.androidparty), null, Modifier.fillMaxSize(), contentScale = ContentScale.Crop, alpha = 0.5f)
        BirthdayText(Modifier.fillMaxSize().padding(8.dp))
    }
}

@Composable
fun BirthdayText(modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.Center) {
        Text(stringResource(R.string.message), fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(stringResource(R.string.signature), fontSize = 36.sp, modifier = Modifier.padding(16.dp).align(Alignment.End))
    }
}
