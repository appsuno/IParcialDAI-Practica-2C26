package com.uade.starwars.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = StarWarsYellow,
    onPrimary = Color.Black,
    secondary = JediBlue,
    onSecondary = Color.White,
    tertiary = SithRed,
    background = EmpireBlack,
    surface = SpaceDark,
    surfaceVariant = SurfaceDark,
    onSurface = Color.White,
    onSurfaceVariant = Color(0xFFCCCCCC)
)

private val LightColorScheme = lightColorScheme(
    primary = StarWarsYellowDark,
    onPrimary = Color.Black,
    secondary = JediBlue,
    onSecondary = Color.White,
    tertiary = SithRed,
    background = StarWarsLight,
    surface = SurfaceLight,
    surfaceVariant = Color(0xFFEEEEEE),
    onSurface = Color.Black,
    onSurfaceVariant = Color(0xFF555555)
)

@Composable
fun StarWarsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
