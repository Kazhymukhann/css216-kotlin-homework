package com.example.diceroller

import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class InteractionTest {
    @get:Rule val rule = createComposeRule()
    @Test fun roll_shows_a_valid_face() {
        rule.setContent { MaterialTheme { DiceRollerApp(Modifier.fillMaxSize()) } }
        rule.onNodeWithContentDescription("Dice showing 1").assertExists()
        repeat(12) {
            rule.onNodeWithText("Roll").performClick()
            val count = (1..6).sumOf { value -> rule.onAllNodesWithContentDescription("Dice showing $value").fetchSemanticsNodes().size }
            org.junit.Assert.assertEquals(1, count)
        }
    }
}
