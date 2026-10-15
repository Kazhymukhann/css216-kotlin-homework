package com.example.businesscard

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) {
            BusinessCardApp(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() { MaterialTheme { BusinessCardApp(Modifier.fillMaxSize()) } }

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Box(modifier.background(Color(0xFFD2E8D4)).padding(24.dp)) {
        Column(Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(R.drawable.android_logo), null, Modifier.size(110.dp).background(Color(0xFF073042)))
            Text(stringResource(R.string.name), fontSize = 36.sp, modifier = Modifier.padding(top = 12.dp))
            Text(stringResource(R.string.title), fontWeight = FontWeight.Bold, color = Color(0xFF006D3B))
        }
        Column(Modifier.align(Alignment.BottomCenter).padding(bottom = 24.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            ContactRow(Icons.Default.Phone, stringResource(R.string.phone))
            ContactRow(Icons.Default.Share, stringResource(R.string.handle))
            ContactRow(Icons.Default.Email, stringResource(R.string.email))
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, tint = Color(0xFF006D3B))
        Spacer(Modifier.width(20.dp))
        Text(text)
    }
}
