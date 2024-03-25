package com.base.reldynproject.utills.userinterfaceutills

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.base.reldynproject.ui.theme.BorderColor
import com.base.reldynproject.ui.theme.PrimaryColor
import com.base.reldynproject.ui.theme.WhiteColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors

/**
 * Reusable UI Components such as TextBox, UI advancements
 * user is currently using in the application.
 *
 * @author Shweta Fulzele
 */
object UiUtills {

    /**
     * Set status bar color as per requirement
     * provide required color as parameter
     *
     * @author Shweta Fulzele
     */
    @Composable
    fun SetStatusBarColor(color: Color) {
        val systemUIController = rememberSystemUiController()
        val darkTheme = !isSystemInDarkTheme()
        DisposableEffect(systemUIController, darkTheme) {
            systemUIController.setStatusBarColor(
                color = color
            )
            onDispose { }
        }
    }

    /**
     * CheckBox to select and unselect
     * Checkbox UI as per Urgent Care
     *
     *
     * @author Shweta Fulzele
     */
    @Composable
    fun ReldynCheckBox(
        modifier: Modifier = Modifier,
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit
    ) {
        androidx.compose.material.Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange(checked) },
            colors = CheckboxDefaults.colors(
                checkedColor = PrimaryColor,
                uncheckedColor = BorderColor,
                checkmarkColor = WhiteColor,
            ),
            modifier = modifier
        )
    }

}