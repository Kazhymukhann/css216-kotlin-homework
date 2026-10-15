package com.example.tiptime

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) {
            TipTimeLayout(Modifier.fillMaxSize().safeDrawingPadding())
        } } }
    }
}

@Preview(showBackground = true)
@Composable
fun TipTimePreview() { MaterialTheme { TipTimeLayout() } }

@Composable
fun TipTimeLayout(modifier: Modifier = Modifier) {
    var amountInput by rememberSaveable { mutableStateOf("") }
    var tipInput by rememberSaveable { mutableStateOf("") }
    var roundUp by rememberSaveable { mutableStateOf(false) }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val percent = tipInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, percent, roundUp)
    val focusManager = LocalFocusManager.current
    Column(modifier.verticalScroll(rememberScrollState()).padding(horizontal = 40.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(R.string.calculate_tip), modifier = Modifier.align(Alignment.Start).padding(top = 48.dp))
        EditNumberField(R.string.bill_amount, Icons.Default.Edit, amountInput, { amountInput = it },
            KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
            KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }))
        EditNumberField(R.string.tip_percentage, Icons.Default.Star, tipInput, { tipInput = it },
            KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done),
            KeyboardActions(onDone = { focusManager.clearFocus() }))
        RoundTheTipRow(roundUp, { roundUp = it })
        Text(stringResource(R.string.tip_amount, tip), style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun EditNumberField(@StringRes label: Int, icon: ImageVector, value: String, onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions, keyboardActions: KeyboardActions, modifier: Modifier = Modifier) {
    TextField(value = value, onValueChange = onValueChanged, singleLine = true,
        label = { Text(stringResource(label)) }, leadingIcon = { Icon(icon, null) },
        keyboardOptions = keyboardOptions, keyboardActions = keyboardActions, modifier = modifier.fillMaxWidth())
}

@Composable
fun RoundTheTipRow(roundUp: Boolean, onRoundUpChanged: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(stringResource(R.string.round_up_tip), modifier = Modifier.weight(1f))
        Switch(checked = roundUp, onCheckedChange = onRoundUpChanged)
    }
}

fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean = false): String {
    var tip = amount * tipPercent / 100
    if (roundUp) tip = ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}
