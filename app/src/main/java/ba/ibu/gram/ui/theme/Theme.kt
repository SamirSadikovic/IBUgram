package ba.ibu.gram.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
  primary = Blue80,
  onPrimary = Blue20,
  primaryContainer = Blue30,
  onPrimaryContainer = Blue90,
  secondary = Gold80,
  onSecondary = Gold20,
  secondaryContainer = Gold10,
  onSecondaryContainer = Gold90,
  inversePrimary = Blue20,
)

private val LightColorScheme = lightColorScheme(
  primary = Blue20,
  onPrimary = Color.White,
  primaryContainer = Blue90,
  onPrimaryContainer = Blue10,
  secondary = Gold40,
  onSecondary = Color.White,
  secondaryContainer = Gold90,
  onSecondaryContainer = Gold10,
  inversePrimary = Blue80
)

@Composable
fun AppTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme                                                      -> DarkColorScheme
    else                                                           -> LightColorScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
      ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
    }
  }

  val systemUiController = rememberSystemUiController()

  SideEffect {
    systemUiController.setSystemBarsColor(
      color = colorScheme.background
    )
  }

  MaterialTheme(
    colorScheme = colorScheme,
    shapes = Shapes,
    typography = Typography,
    content = content
  )
}