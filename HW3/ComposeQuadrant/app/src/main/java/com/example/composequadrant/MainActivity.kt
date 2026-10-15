package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) {
            ComposeQuadrantApp(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() { MaterialTheme { ComposeQuadrantApp(Modifier.fillMaxSize()) } }

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(Modifier.weight(1f)) {
            Quadrant(R.string.text_title, R.string.text_body, Color(0xFFEADDFF), Modifier.weight(1f))
            Quadrant(R.string.image_title, R.string.image_body, Color(0xFFD0BCFF), Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            Quadrant(R.string.row_title, R.string.row_body, Color(0xFFB69DF8), Modifier.weight(1f))
            Quadrant(R.string.column_title, R.string.column_body, Color(0xFFF6EDFF), Modifier.weight(1f))
        }
    }
}

@Composable
fun Quadrant(title: Int, description: Int, color: Color, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxHeight().background(color).padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(title), fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(stringResource(description), textAlign = TextAlign.Justify)
    }
}
