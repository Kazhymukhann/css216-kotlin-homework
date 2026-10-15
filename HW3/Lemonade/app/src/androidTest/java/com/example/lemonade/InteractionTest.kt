package com.example.lemonade

import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class InteractionTest {
    @get:Rule val rule = createComposeRule()
    @Test fun complete_lemonade_cycle() {
        rule.setContent { MaterialTheme { LemonadeApp(Modifier.fillMaxSize()) } }
        rule.onNodeWithContentDescription("Lemon tree").performClick()
        rule.onNodeWithContentDescription("Lemon").performClick()
        rule.onNodeWithContentDescription("Lemon").assertExists()
        var count = 1
        while (rule.onAllNodesWithContentDescription("Lemon").fetchSemanticsNodes().isNotEmpty() && count < 4) {
            rule.onNodeWithContentDescription("Lemon").performClick()
            count++
        }
        rule.onNodeWithContentDescription("Glass of lemonade").performClick()
        rule.onNodeWithContentDescription("Empty glass").performClick()
        rule.onNodeWithContentDescription("Lemon tree").assertExists()
    }
}
