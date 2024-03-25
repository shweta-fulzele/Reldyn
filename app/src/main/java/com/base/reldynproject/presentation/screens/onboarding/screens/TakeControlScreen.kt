package com.base.reldynproject.presentation.screens.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.base.reldynproject.presentation.screens.navigation.NavigationDestination
import com.base.reldynproject.presentation.screens.onboarding.ui.OBUIComponent.BlackSubtitleAnnotatedText
import com.base.reldynproject.presentation.screens.onboarding.ui.OBUIComponent.HeadlineAnnotatedText
import com.base.reldynproject.presentation.screens.onboarding.ui.OBUIComponent.SwipeButton
import com.base.reldynproject.ui.theme.SecondaryTextColor
import com.base.reldynproject.ui.theme.WhiteColor
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent.ReldynSubHeadlineText
import com.example.reldynproject.R

@Composable
fun TakeControlScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor)
    ) {
        TakeControlUIContent(navController)
    }
}

@Composable
fun TakeControlUIContent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {

            Image(
                painter = painterResource(id = R.drawable.alpha_text_bg),
                contentDescription = "Splash Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(343.dp)
            )

            Spacer(modifier = Modifier.height(42.dp))

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HeadlineAnnotatedText()

                Spacer(modifier = Modifier.height(42.dp))

                ReldynSubHeadlineText(
                    text = stringResource(id = R.string.secure_your_financial_future_with_our_trusted_banking_services),
                    textColor = SecondaryTextColor
                )
                Spacer(modifier = Modifier.height(42.dp))

                SwipeButton(onSwipe = {
                    navController.navigate(NavigationDestination.ContentDetailsScreen.route)
                })

                Spacer(modifier = Modifier.height(16.dp))

                BlackSubtitleAnnotatedText()

                Spacer(modifier = Modifier.height(32.dp))

            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTakeControlScreen() {
    val navController = rememberNavController()
    TakeControlScreen(navController)
}