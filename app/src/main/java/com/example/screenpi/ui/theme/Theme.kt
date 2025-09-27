package com.example.screenpi.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Green80,
    secondary = Green60,
    tertiary = Green40,
    background = Color(0xFF1A1A1A),
    surface = Color(0xFF2D2D2D),
    primaryContainer = Color(0xFF2A5A54),
    surfaceVariant = Color(0xFF404040),
    outline = Green60
)

private val LightColorScheme = lightColorScheme(
    primary = Green40,
    secondary = Green60,
    tertiary = Green80,
    background = White,
    surface = White,
    primaryContainer = Green80,
    surfaceVariant = Gray10,
    outline = Green60,
    onPrimary = White,
    onSecondary = Color(0xFF1A1A1A),
    onTertiary = Color(0xFF1A1A1A),
    onBackground = Color(0xFF1A1A1A),
    onSurface = Color(0xFF1A1A1A),
    onPrimaryContainer = Color(0xFF1A1A1A),
    onSurfaceVariant = Color(0xFF1A1A1A)
)

@Composable
fun CalmwavelandingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Desabilitamos dynamic color para usar nossas cores personalizadas
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}