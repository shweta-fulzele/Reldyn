package com.base.reldynproject.presentation.screens.navigation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

/**
 * Top level composable that represents screens for the application.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ReldynNavApp(
    context: Context,
    navController: NavHostController = rememberNavController()) {
    ReldynNavGraph(
        context,
        navController = navController)
}
