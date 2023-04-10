package com.example.demodelta4.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.demodelta4.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight(400)),
    Font(R.font.roboto_italic,FontWeight(400), style = FontStyle.Italic),
    Font(R.font.roboto_medium,FontWeight(500)),
    Font(R.font.roboto_bold,FontWeight(700)),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color(0xFF2E3134)
    ),
    h1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W700,
        fontSize = 32.sp,
        color = Color(0xFF001B33)
    ),
    h3 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        color = Color(0xFF001B33)
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        color = Color(0xFFAAAEB2)
    )
    /* Other default text styles to override
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)