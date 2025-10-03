package com.example.yollotl_app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.yollotl_app.R

// Set of Material typography styles to start with

val alegreyaFont = FontFamily(
    Font(R.font.alegreya, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.alegreya, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.alegreya, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.alegreya, FontWeight.ExtraBold, FontStyle.Normal),
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = alegreyaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)
