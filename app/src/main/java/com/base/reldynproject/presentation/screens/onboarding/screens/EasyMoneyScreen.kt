package com.base.reldynproject.presentation.screens.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.base.reldynproject.presentation.screens.navigation.NavigationDestination
import com.base.reldynproject.ui.theme.PrimaryTextColor
import com.base.reldynproject.ui.theme.WhiteColor
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent.ReldynHeadlineText
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent.ReldynSubHeadlineText
import com.example.reldynproject.R

@Composable
fun EasyMoneyScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor)
    ) {
        EasyMoneyUIContent(navController)
    }
}

@Composable
fun EasyMoneyUIContent(navController: NavController) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {

            Image(
                painter = painterResource(id = R.drawable.splash_placeholder2),
                contentDescription = "Splash Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(540.dp)

            )

            Spacer(modifier = Modifier.height(32.dp))

            Column {
                ReldynHeadlineText(
                    text = stringResource(id = R.string.easy_money_transfer_worldwide),
                    textColor = PrimaryTextColor,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
                ) {
                    ReldynSubHeadlineText(
                        text = stringResource(id = R.string.send_money_to_love_ones_around_the_world_with_ease),
                        modifier = Modifier.fillMaxWidth(0.75f),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Image(painter = painterResource(id = R.drawable.fab_btn),
                        contentDescription = "Forward Button on Easy Money Screen",
                        modifier = Modifier.clickable(interactionSource = remember {
                            MutableInteractionSource()
                        }, indication = null) {
                            navController.navigate(NavigationDestination.TakeControlScreen.route)
                        })
                }

            }


        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEasyMoneyScreen() {
    val navController = rememberNavController()
    EasyMoneyScreen(navController)
}