package com.example.retrofit_demmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.retrofit_demmo.ui.CoffeeListScreen
import com.example.retrofit_demmo.ui.theme.RetroFit_DemmoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetroFit_DemmoTheme {
                CoffeeListScreen()
            }
        }
    }
}
