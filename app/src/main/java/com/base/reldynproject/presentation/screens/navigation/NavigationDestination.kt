package com.base.reldynproject.presentation.screens.navigation

/**
 * Interface to describe the navigation destinations for the app
 **/
sealed class NavigationDestination(var route: String, var id: String) {
    object SplashScreen :
        NavigationDestination(NavRoutes.SPLASH_SCREEN.name, id = NavRoutes.SPLASH_SCREEN.name)

    object EasyMoneyScreen :
        NavigationDestination(NavRoutes.EASY_MONEY_SCREEN.name, id = NavRoutes.EASY_MONEY_SCREEN.name)

    object TakeControlScreen :
        NavigationDestination(NavRoutes.TAKE_CONTROL_SCREEN.name, id = NavRoutes.TAKE_CONTROL_SCREEN.name)

    object ContentDetailsScreen :
        NavigationDestination(NavRoutes.CONSENT_DETAILS_SCREEN.name, id = NavRoutes.CONSENT_DETAILS_SCREEN.name)

    object LoginScreen :
        NavigationDestination(NavRoutes.LOGIN_SCREEN.name, id = NavRoutes.LOGIN_SCREEN.name)

    object SignupScreen :
        NavigationDestination(NavRoutes.WAITING_SCREEN.name, id = NavRoutes.WAITING_SCREEN.name)

    object HomeScreen :
        NavigationDestination(NavRoutes.HOME_SCREEN.name, id = NavRoutes.HOME_SCREEN.name)


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}