package com.example.tiptime

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {
    @get:Rule val composeTestRule = createComposeRule()

    @Test fun calculate_20_percent_tip() {
        composeTestRule.setContent { MaterialTheme { TipTimeLayout() } }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists()
    }

    @Test fun round_up_then_clear_bill() {
        composeTestRule.setContent { MaterialTheme { TipTimeLayout() } }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10.25")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        composeTestRule.onNode(isToggleable()).performClick()
        composeTestRule.onNodeWithText("Tip Amount: ${NumberFormat.getCurrencyInstance().format(3)}").assertExists()
        composeTestRule.onNodeWithText("Bill Amount").performTextClearance()
        composeTestRule.onNodeWithText("Tip Amount: ${NumberFormat.getCurrencyInstance().format(0)}").assertExists()
    }
}
