package com.hexfa.amazingclock.ui.screen

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import org.junit.Rule
import org.junit.Test

class NewtonClockScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun newtonClockScreen_displaysClockComponentsCorrectly() {
        composeTestRule.setContent {
            NewtonClockScreen()
        }

        composeTestRule.onAllNodesWithContentDescription("DigitalClockView")
            .assertCountEquals(8)

        composeTestRule.onAllNodesWithContentDescription("DigitalClockView")[0]
            .assertIsDisplayed()
    }
}