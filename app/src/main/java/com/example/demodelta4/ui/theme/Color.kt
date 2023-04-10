package com.example.demodelta4.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFF006BCC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

data class CustomColors(
    val primary: Color=Color(0xFF006BCC),
    val secondary: Color=Color(0xFF21486C),
    val heading: Color=Color(0xFF001B33),
    val body: Color=Color(0xFF2E3134),
    val warningY: Color=Color(0xFFFFA215),
    val warningR: Color=Color(0xFFD85D5D),
    val danger: Color=Color(0xFFF5004A),
    val grey: Color = Color(0xFFAAAEB2),
    val lightBg: Color = Color(0xFFF5F5F5),
    val inProgress: Color = Color(0xFFEFF9C8),
    val tryOut: Color = Color(0xFFE6C8F9),
    val iconColor: Color =Color(0xFF5A96CD)
)

val LocalCustomColors = staticCompositionLocalOf { CustomColors() }

val MaterialTheme.delta4Colors: CustomColors
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColors.current