package com.base.reldynproject.presentation.screens.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.base.reldynproject.presentation.screens.onboarding.screens.ConsentDetailsScreen
import com.base.reldynproject.presentation.screens.onboarding.screens.EasyMoneyScreen
import com.base.reldynproject.presentation.screens.onboarding.screens.TakeControlScreen
import com.base.reldynproject.presentation.screens.onboarding.screens.WaitingScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun ReldynNavGraph(
    context: Context,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.EASY_MONEY_SCREEN.name,
        modifier = modifier,

        ) {
        composable(route = NavRoutes.EASY_MONEY_SCREEN.name) {
            EasyMoneyScreen(
                navController
            )
        }

        composable(route = NavRoutes.TAKE_CONTROL_SCREEN.name) {
            TakeControlScreen(
                navController
            )
        }
        composable(route = NavRoutes.CONSENT_DETAILS_SCREEN.name) {
            ConsentDetailsScreen(
                navController
            )
        }

        composable(route = NavRoutes.WAITING_SCREEN.name) {
            WaitingScreen(
                navController
            )
        }

    }
}
