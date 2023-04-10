package com.example.demodelta4.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

data class CustomShapes(
    val roundNone: RoundedCornerShape = RoundedCornerShape(0.dp),
    val round2: RoundedCornerShape = RoundedCornerShape(2.dp),
    val round4: RoundedCornerShape = RoundedCornerShape(4.dp),
    val round8: RoundedCornerShape = RoundedCornerShape(8.dp),
    val round16: RoundedCornerShape = RoundedCornerShape(16.dp),
    val round35: RoundedCornerShape = RoundedCornerShape(35.dp)
)

val LocalCustomShapes = staticCompositionLocalOf { CustomShapes() }

val MaterialTheme.delta4Shapes: CustomShapes
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomShapes.current