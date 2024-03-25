package com.base.reldynproject.utills.userinterfaceutills

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.base.reldynproject.ui.theme.BlackColor
import com.base.reldynproject.ui.theme.FontConstants
import com.base.reldynproject.ui.theme.PrimaryTextColor
import com.base.reldynproject.ui.theme.SecondaryTextColor
import com.base.reldynproject.ui.theme.WhiteColor
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent.ReldynHeadlineText

/**
 * Reusable TextStyle Components such as Title Text, Button Text
 * user is currently using in the application.
 *
 * @author Shweta Fulzele
 */
object TextStyleComponent {

    /**
     * Text displayed upon User Input Box
     * Custom Text Style
     *
     * @author Shweta Fulzele
     */
    @Composable
    fun ReldynCustomText(
        modifier: Modifier = Modifier,
        text: Any,
        textColor: Color = BlackColor,
        textAlign: TextAlign = TextAlign.Start,
        textStyle: TextStyle = TextStyle(
            fontFamily = FontConstants.FontSemiBold,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 22.4.sp
        )
    ) {
        Text(
            text = "$text",
            style = textStyle,
            color = textColor,
            modifier = modifier,
            textAlign = textAlign
        )
    }

    /**
     * Title Text displayed as Headline on a screen
     *
     * @author Shweta Fulzele
     */
    @Composable
    fun ReldynHeadlineText(
        modifier: Modifier = Modifier,
        text: String,
        textAlign: TextAlign = TextAlign.Start,
        textColor: Color = PrimaryTextColor
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = FontConstants.FontRegular,
                fontSize = 36.sp,
                letterSpacing = 0.01.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 46.8.sp
            ),
            color = textColor,
            modifier = modifier.wrapContentSize()
        )
    }

    /**
     * Title Text displayed as Headline on a screen
     *
     * @author Shweta Fulzele
     */
    @Composable
    fun ReldynSubHeadlineText(
        modifier: Modifier = Modifier,
        text: String,
        textAlign: TextAlign = TextAlign.Start,
        textColor: Color = SecondaryTextColor
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = FontConstants.FontLight,
                fontSize = 16.sp,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.W300,
                lineHeight = 22.4.sp,
                textAlign = textAlign
            ),
            color = textColor,
            modifier = modifier.wrapContentSize()
        )
    }


    @Composable
    fun AnnotatedText(
        text1: String,
        color1: Color,
        text2: String,
        color2: Color,
        fontWeight: FontWeight,
        fontFamily: FontFamily,
        fontSize: Int,
        textAlign: Arrangement.Horizontal = Arrangement.Start
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = textAlign) {
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = color1,
                        fontSize = fontSize.sp,
                        fontWeight = fontWeight,
                        fontFamily = fontFamily
                    )
                ) {
                    append(text1)
                }
                withStyle(
                    style = SpanStyle(
                        color = color2,
                        fontSize = fontSize.sp,
                        fontWeight = fontWeight,
                        fontFamily = fontFamily
                    )
                ) {
                    append(text2)
                }
            })
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewTextStyleComponent() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ReldynHeadlineText(text = "ReldynHeadlineText")

    }
}