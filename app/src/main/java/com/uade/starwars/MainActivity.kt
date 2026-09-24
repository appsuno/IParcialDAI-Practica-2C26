package com.uade.starwars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.uade.starwars.ui.StarWarsScreen
import com.uade.starwars.ui.theme.StarWarsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StarWarsTheme {
                StarWarsScreen()
            }
        }
    }
}
