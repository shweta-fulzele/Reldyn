package com.base.reldynproject.utills.userinterfaceutills

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.base.reldynproject.ui.theme.FontConstants.FontSemiBold
import com.base.reldynproject.ui.theme.PrimaryColor
import com.base.reldynproject.ui.theme.WhiteColor
import com.base.reldynproject.utills.userinterfaceutills.ButtonUiUtils.ReldynPrimaryBgButton

object ButtonUiUtils {

    /**
     * Primary Button which can be modified as per background
     * text color
     * Primary BG Button
     * Secondary BG Button
     * White BG Button
     *
     * @author Shweta Fulzele
     */
    @Composable
    private fun ReldynPrimaryButton(
        modifier: Modifier = Modifier,
        textModifier: Modifier = Modifier.padding(vertical = 16.dp, horizontal = 31.dp),
        backgroundColor: Color,
        textColor: Color,
        shape: Shape,
        btnText: String,
        btnStyle: TextStyle,
        loadingValue: Boolean,
        loaderColor: Color,
        onClick: () -> Unit
    ) {
        Surface(
            color = backgroundColor,
            shape = shape,
            modifier = modifier.clickable(onClick = onClick)
        ) {
            if (loadingValue) {
                Box(
                    modifier = textModifier,
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = loaderColor,
                        strokeWidth = 2.dp
                    )
                }
            } else {
                Text(
                    text = btnText,
                    style = btnStyle,
                    modifier = textModifier,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            }

        }
    }

    /**
     * Primary Button with Dark Background and Light text color
     *
     * @author Shweta Fulzele
     */
    @Composable
    fun ReldynPrimaryBgButton(
        modifier: Modifier = Modifier, loadingValue: Boolean = false,
        loaderColor: Color = PrimaryColor,
        shape: Shape = RoundedCornerShape(8.dp),
        btnText: String, onClick: () -> Unit
    ) {
        ReldynPrimaryButton(
            backgroundColor = PrimaryColor,
            textColor = WhiteColor,
            btnText = btnText,
            btnStyle = TextStyle(
                fontFamily = FontSemiBold,
                fontSize = 16.sp,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.W600,
                lineHeight = 22.4.sp
            ), onClick = onClick,
            modifier = modifier,
            loadingValue = loadingValue,
            loaderColor = loaderColor,
            shape = shape,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewButtonComponent() {
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {

        ReldynPrimaryBgButton(
            btnText = "Hello",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

        }
    }
}