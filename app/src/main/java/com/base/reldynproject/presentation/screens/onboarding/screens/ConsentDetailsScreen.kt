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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.base.reldynproject.presentation.screens.navigation.NavigationDestination
import com.base.reldynproject.presentation.screens.onboarding.ui.OBUIComponent.SubtitleAnnotatedText
import com.base.reldynproject.ui.theme.ErrorColor
import com.base.reldynproject.ui.theme.GreyTextColor
import com.base.reldynproject.ui.theme.PrimaryColor
import com.base.reldynproject.ui.theme.PrimaryTextColor
import com.base.reldynproject.ui.theme.SecondaryTextColor
import com.base.reldynproject.ui.theme.WhiteColor
import com.base.reldynproject.utills.userinterfaceutills.ButtonUiUtils.ReldynPrimaryBgButton
import com.base.reldynproject.utills.userinterfaceutills.TextStyleComponent
import com.base.reldynproject.utills.userinterfaceutills.UiUtills.ReldynCheckBox
import com.base.reldynproject.utills.userinterfaceutills.addSpace
import com.example.reldynproject.R

@Composable
fun ConsentDetailsScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteColor)
    ) {
        ConsentDetailsUIContent(navController)
    }
}

@Composable
fun ConsentDetailsUIContent(navController: NavController) {
    var termsAndConditionsChecked by remember {
        mutableStateOf(false)
    }

    var privacyChecked by remember {
        mutableStateOf(false)
    }

    var age18years by remember {
        mutableStateOf(false)
    }

    var showError by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(38.dp))


            TextStyleComponent.ReldynHeadlineText(
                text = stringResource(id = R.string.consent_details),
                textColor = PrimaryTextColor,
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                TextStyleComponent.ReldynSubHeadlineText(
                    text = stringResource(id = R.string.dummy_text),
                    textColor = GreyTextColor,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                        painter = painterResource(id = R.drawable.consent),
                        contentDescription = "Consent Icon",
                        modifier = Modifier
                            .size(220.dp),
                        contentScale = ContentScale.FillBounds
                    )


                Spacer(modifier = Modifier.height(18.dp))

                Column(horizontalAlignment = Alignment.Start) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        ReldynCheckBox(checked = termsAndConditionsChecked) {
                            termsAndConditionsChecked = true
                        }

                        SubtitleAnnotatedText(
                            text1 = stringResource(id = R.string.i_agree_with_reldyns).addSpace(),
                            text2 = stringResource(id = R.string.terms_and_conditions)
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        ReldynCheckBox(checked = privacyChecked) {
                            privacyChecked = true
                        }

                        SubtitleAnnotatedText(
                            text1 = stringResource(id = R.string.i_agree_with_reldyns).addSpace(),
                            text2 = stringResource(id = R.string.privacy_policy_and_privacy_notice)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        ReldynCheckBox(checked = age18years) {
                            age18years = true
                        }

                        TextStyleComponent.ReldynSubHeadlineText(
                            text = stringResource(id = R.string.im_18_years_and_above),
                            textColor = SecondaryTextColor
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            ReldynPrimaryBgButton(
                modifier = Modifier.fillMaxWidth(),
                btnText = stringResource(id = R.string.proceed)
            ) {
                if (termsAndConditionsChecked && privacyChecked && age18years) {
                    showError = false
                    navController.navigate(NavigationDestination.SignupScreen.route)
                } else {
                    showError = true
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (showError) {
                TextStyleComponent.ReldynSubHeadlineText(
                    text = stringResource(id = R.string.please_select_above_options),
                    textColor = ErrorColor,
                    textAlign = TextAlign.Center
                )

            }


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewContentDetailsScreen() {
    val navController = rememberNavController()
    ConsentDetailsScreen(navController)
}