package com.hexfa.amazingclock.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

class SmallClockViewTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun smallClockView_shouldBeDisplayed() {
        composeRule.setContent {
            SmallClockView(
                hourHand = 3,
                minuteHand = 15,
                modifier = Modifier
                    .size(100.dp)
                    .testTag("SmallClockViewTestTag")
            )
        }

        composeRule.onNodeWithTag("SmallClockViewTestTag")
            .assertIsDisplayed()
    }
}
