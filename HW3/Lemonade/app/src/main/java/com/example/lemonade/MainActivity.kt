package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            LemonadeApp(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() { MaterialTheme { LemonadeApp(Modifier.fillMaxSize()) } }

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var step by rememberSaveable { mutableIntStateOf(1) }
    var squeezesLeft by rememberSaveable { mutableIntStateOf(0) }
    val image = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val prompt = when (step) {
        1 -> R.string.select
        2 -> R.string.squeeze
        3 -> R.string.drink
        else -> R.string.restart
    }
    val description = when (step) {
        1 -> R.string.tree_description
        2 -> R.string.lemon_description
        3 -> R.string.drink_description
        else -> R.string.empty_description
    }
    Column(modifier) {
        Text(stringResource(R.string.app_name), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().background(Color(0xFFF9E44C)).padding(20.dp))
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Button(onClick = {
                when (step) {
                    1 -> { squeezesLeft = (2..4).random(); step = 2 }
                    2 -> { squeezesLeft--; if (squeezesLeft == 0) step = 3 }
                    3 -> step = 4
                    4 -> step = 1
                }
            }, shape = RoundedCornerShape(32.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2))) {
                Image(painterResource(image), stringResource(description), Modifier.size(200.dp).padding(16.dp))
            }
            Spacer(Modifier.height(16.dp))
            Text(stringResource(prompt), fontSize = 18.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}
