package com.hexfa.amazingclock.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class DigitalClockViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun digitalClockView_DisplaysCorrectly() {
        composeTestRule.setContent {
            DigitalClockView(
                number = 1,
            )
        }

        composeTestRule.onNodeWithTag("DigitalClockView").assertIsDisplayed()
    }
}
