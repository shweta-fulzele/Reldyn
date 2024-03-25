package com.base.reldynproject.presentation.screens.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.base.reldynproject.ui.theme.PrimaryTextColor
import com.base.reldynproject.ui.theme.SecondaryTextColor
import com.base.reldynproject.ui.theme.WaitingBgColor
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent.ReldynHeadlineText
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent.ReldynSubHeadlineText
import com.example.reldynproject.R

@Composable
fun WaitingScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WaitingBgColor)
    ) {
        WaitingUIContent(navController)
    }
}

@Composable
fun WaitingUIContent(navController: NavController) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(WaitingBgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.waiting),
                contentDescription = "Waiting Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(228.dp)

            )
            Spacer(modifier = Modifier.height(32.dp))

            ReldynHeadlineText(
                text = stringResource(id = R.string.this_might_take_a_while_why_not_take_a_coffee_break),
                textColor = PrimaryTextColor,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))

            ReldynSubHeadlineText(
                text = stringResource(id = R.string.please_be_patient),
                textColor = SecondaryTextColor,
                textAlign = TextAlign.Center
            )

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWaitingScreen() {
    val navController = rememberNavController()
    WaitingScreen(navController)
}