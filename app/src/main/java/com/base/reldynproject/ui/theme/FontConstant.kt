package com.base.reldynproject.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.reldynproject.R

object FontConstants {
    private val spacegrotesk_light = Font(R.font.spacegrotesk_light)
    private val spacegrotesk_regular = Font(R.font.spacegrotesk_regular)
    private val spacegrotesk_medium = Font(R.font.spacegrotesk_medium)
    private val spacegrotesk_semibold = Font(R.font.spacegrotesk_semibold)
    private val spacegrotesk_bold = Font(R.font.spacegrotesk_bold)

    val FontLight = FontFamily(spacegrotesk_light)
    val FontRegular = FontFamily(spacegrotesk_regular)
    val FontMedium = FontFamily(spacegrotesk_medium)
    val FontSemiBold = FontFamily(spacegrotesk_semibold)
    val FontBold = FontFamily(spacegrotesk_bold)
}