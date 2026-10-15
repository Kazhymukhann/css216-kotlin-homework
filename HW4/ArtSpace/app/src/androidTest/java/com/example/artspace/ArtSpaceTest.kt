package com.example.artspace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.junit4.StateRestorationTester
import org.junit.Rule
import org.junit.Test

class ArtSpaceTest {
    @get:Rule val rule = createComposeRule()

    @Test fun navigation_wraps_and_restores_state() {
        val restoration = StateRestorationTester(rule)
        restoration.setContent { MaterialTheme { ArtSpaceApp(Modifier.fillMaxSize()) } }
        rule.onNodeWithContentDescription("Wheat Field with Cypresses").assertExists()
        rule.onNodeWithText("Previous").performClick()
        rule.onNodeWithContentDescription("A Woman Seated beside a Vase of Flowers (Madame Paul Valpinçon?)").assertExists()
        rule.onNodeWithText("Next").performClick()
        rule.onNodeWithContentDescription("Wheat Field with Cypresses").assertExists()
        rule.onNodeWithText("Next").performClick()
        restoration.emulateSavedInstanceStateRestore()
        rule.onNodeWithContentDescription("Self-Portrait with a Straw Hat (obverse: The Potato Peeler)").assertExists()
    }
}
