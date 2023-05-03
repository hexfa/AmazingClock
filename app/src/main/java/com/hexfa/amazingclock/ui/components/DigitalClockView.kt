package com.hexfa.amazingclock.ui.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.min
import com.hexfa.amazingclock.common.Constants.SMALL_CLOCK_COUNT_IN_COLUMN
import com.hexfa.amazingclock.common.Constants.SMALL_CLOCK_COUNT_IN_ROW
import com.hexfa.amazingclock.common.DigitalClockNumbers.Eight
import com.hexfa.amazingclock.common.DigitalClockNumbers.Five
import com.hexfa.amazingclock.common.DigitalClockNumbers.Four
import com.hexfa.amazingclock.common.DigitalClockNumbers.Nine
import com.hexfa.amazingclock.common.DigitalClockNumbers.One
import com.hexfa.amazingclock.common.DigitalClockNumbers.Separator
import com.hexfa.amazingclock.common.DigitalClockNumbers.Seven
import com.hexfa.amazingclock.common.DigitalClockNumbers.Six
import com.hexfa.amazingclock.common.DigitalClockNumbers.Three
import com.hexfa.amazingclock.common.DigitalClockNumbers.Two
import com.hexfa.amazingclock.common.DigitalClockNumbers.Zero
import com.hexfa.amazingclock.model.SmallClock

@Composable
fun DigitalClockView(
    timeArray: Array<SmallClock>,
    smallClocksBackgroundColor: Color,
    smallClocksBorderColor: Color,
    smallClocksBorderWidth: Float,
    smallClocksHourHandColor: Color,
    smallClocksHourHandWidth: Float,
    smallClocksMinuteHandColor: Color,
    smallClocksMinuteHandWidth: Float,
    smallClocksAnimationDurationMillis: Int,
    modifier: Modifier = Modifier,
) {
    val rowCount = SMALL_CLOCK_COUNT_IN_ROW
    val columnCount = SMALL_CLOCK_COUNT_IN_COLUMN
    BoxWithConstraints(modifier = modifier) {
        val smallClockSize = (min(maxWidth, maxHeight) / rowCount)
        Column {
            (0 until columnCount).forEach { row ->
                Row(modifier = modifier) {
                    (0 until rowCount).forEach { column ->
                        val smallClock = timeArray[(row * rowCount) + column]
                        SmallClockView(
                            hourHand = smallClock.hourHand,
                            minuteHand = smallClock.minuteHand,
                            backgroundColor = smallClocksBackgroundColor,
                            borderColor = smallClocksBorderColor,
                            borderWidth = smallClocksBorderWidth,
                            hourHandColor = smallClocksHourHandColor,
                            hourHandWidth = smallClocksHourHandWidth,
                            minuteHandColor = smallClocksMinuteHandColor,
                            minuteHandWidth = smallClocksMinuteHandWidth,
                            animationDurationMillis = smallClocksAnimationDurationMillis,
                            modifier = Modifier.size(smallClockSize),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DigitalClockView(
    number: Int,
    smallClocksBackgroundColor: Color = Color.White,
    smallClocksBorderColor: Color = Color.Black,
    smallClocksBorderWidth: Float = .6f,
    smallClocksHourHandColor: Color = Color.Black,
    smallClocksHourHandWidth: Float = 3f,
    smallClocksMinuteHandColor: Color = Color.Black,
    smallClocksMinuteHandWidth: Float = 3f,
    smallClocksAnimationDurationMillis: Int = 3000,
    modifier: Modifier = Modifier
) {
    val array = when (number) {
        -1 -> Separator
        1 -> One
        2 -> Two
        3 -> Three
        4 -> Four
        5 -> Five
        6 -> Six
        7 -> Seven
        8 -> Eight
        9 -> Nine
        else -> Zero
    }
    DigitalClockView(
        timeArray = array,
        smallClocksBackgroundColor = smallClocksBackgroundColor,
        smallClocksBorderColor = smallClocksBorderColor,
        smallClocksBorderWidth = smallClocksBorderWidth,
        smallClocksHourHandColor = smallClocksHourHandColor,
        smallClocksHourHandWidth = smallClocksHourHandWidth,
        smallClocksMinuteHandColor = smallClocksMinuteHandColor,
        smallClocksMinuteHandWidth = smallClocksMinuteHandWidth,
        smallClocksAnimationDurationMillis = smallClocksAnimationDurationMillis,
        modifier = modifier,
    )
}

@Preview
@Composable
fun DigitalClockViewPreview() {
    Surface {
        DigitalClockView(
            number = 1,
        )
    }
}