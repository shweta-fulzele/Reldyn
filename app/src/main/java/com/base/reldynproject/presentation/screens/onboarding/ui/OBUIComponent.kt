package com.base.reldynproject.presentation.screens.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.base.reldynproject.presentation.screens.onboarding.ui.OBUIComponent.BlackSubtitleAnnotatedText
import com.base.reldynproject.presentation.screens.onboarding.ui.OBUIComponent.HeadlineAnnotatedText
import com.base.reldynproject.presentation.screens.onboarding.ui.OBUIComponent.SwipeButton
import com.base.reldynproject.ui.theme.BlackColor
import com.base.reldynproject.ui.theme.FontConstants.FontLight
import com.base.reldynproject.ui.theme.FontConstants.FontRegular
import com.base.reldynproject.ui.theme.GreyTextColor
import com.base.reldynproject.ui.theme.PrimaryColor
import com.base.reldynproject.ui.theme.PrimaryTextColor
import com.base.reldynproject.ui.theme.SecondaryTextColor
import com.base.reldynproject.ui.theme.WhiteColor
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent
import com.base.reldynproject.utills.userinterfaceutills.addDot
import com.base.reldynproject.utills.userinterfaceutills.addQuestionMark
import com.base.reldynproject.utills.userinterfaceutills.addSpace
import com.example.reldynproject.R


object OBUIComponent {

    @Composable
    fun HeadlineAnnotatedText(){
        TextStyleComponent.AnnotatedText(
            text1 = stringResource(id = R.string.take_control_of_your_finance).addSpace(),
            color1 = PrimaryTextColor,
            text2 = stringResource(id = R.string.anytime_anywhere),
            color2 = PrimaryColor,
            fontWeight = FontWeight.W400,
            fontFamily = FontRegular,
            fontSize = 32
        )
    }

    @Composable
    fun SubtitleAnnotatedText(text1 : String, text2 : String){
        TextStyleComponent.AnnotatedText(
            text1 = text1,
            color1 = PrimaryTextColor,
            text2 = text2,
            color2 = PrimaryColor,
            fontWeight = FontWeight.W300,
            fontFamily = FontLight,
            fontSize = 16
        )
    }

    @Composable
    fun BlackSubtitleAnnotatedText(){
        TextStyleComponent.AnnotatedText(
            text1 = stringResource(id = R.string.already_a_member).addQuestionMark().addSpace(),
            color1 = SecondaryTextColor,
            text2 = stringResource(id = R.string.login_here).addDot(),
            color2 = BlackColor,
            fontWeight = FontWeight.W300,
            fontFamily = FontLight,
            fontSize = 16,
            textAlign = Arrangement.Center

        )
    }


    @Composable
    fun SwipeButton(
        onSwipe: () -> Unit,
        modifier: Modifier = Modifier,
        buttonColor: Color = PrimaryColor
    ) {
        var offsetX by remember { mutableStateOf(0f) }
        var isSwiped by remember { mutableStateOf(false) }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(width = 1.dp, color = GreyTextColor, shape = CircleShape)
                .background(WhiteColor, shape = CircleShape)
                .padding(horizontal = 4.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Swipe to get started",
                color = PrimaryTextColor,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(alignment = Alignment.Center)
                    .align(Alignment.CenterStart)
            )

            Box(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .offset {
                        IntOffset(
                            x = offsetX
                                .toInt()
                                .coerceIn(minimumValue = 0, maximumValue = 120),
                            y = 0
                        )
                    }
                    .graphicsLayer {
                        translationX = offsetX
                    }
                    .background(buttonColor, shape = CircleShape)
                    .size(80.dp)
                    .align(Alignment.CenterStart)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            offsetX += dragAmount.x

                            if (offsetX > size.width - 40) {
                                isSwiped = true
                                onSwipe()
                            }
                        }
                    }
            ){
                IconButton(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Swipe to content details screen",
                        tint = WhiteColor,
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewComponents(){
    Column {
        HeadlineAnnotatedText()
        SwipeButton(onSwipe = {})
        BlackSubtitleAnnotatedText()
    }
}