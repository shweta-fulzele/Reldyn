package com.base.reldynproject.presentation.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.base.reldynproject.presentation.screens.navigation.ReldynNavApp
import com.base.reldynproject.ui.theme.PrimaryColor
import com.base.reldynproject.ui.theme.ReldynProjectTheme
import com.base.reldynproject.utills.userinterfaceutills.UiUtills.SetStatusBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReldynProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { it ->
                    val systemUiController = rememberSystemUiController()
                    systemUiController.isStatusBarVisible = false
                    SetStatusBarColor(PrimaryColor)
                    ReldynNavApp(context = this@MainActivity)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReldynProjectTheme {

    }
}