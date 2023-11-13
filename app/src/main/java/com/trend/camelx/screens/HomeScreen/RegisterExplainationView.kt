package com.trend.camelx.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trend.camelx.R
import com.trend.camelx.ui.theme.IbmFont
import com.trend.camelx.ui.theme.darkBrown
import com.trend.camelx.ui.theme.large
import com.trend.camelx.ui.theme.medium
import com.trend.camelx.ui.theme.registerBoarderColor


@Preview
@Composable
fun RegisterExplanationView(modifier: Modifier = Modifier){

    Row (modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly){

        Box(modifier = Modifier
            .height(200.dp)
            .weight(1f)) {

            Column(modifier = Modifier
                .height(175.dp)
                .width(127.dp)
                .background(
                    color = registerBoarderColor,
                    shape = RoundedCornerShape(large)
                )
                .align(Alignment.BottomCenter)
                .padding(medium),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "سجل",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(700),
                        color = darkBrown,
                        textAlign = TextAlign.Center,
                    )
                )

                Text(
                    text = "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(400),
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                    )
                )
            }

            Image(
                painter = painterResource(id = R.drawable.group_208),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
        Spacer(modifier = Modifier.width(medium))
        Box(modifier = Modifier
            .height(200.dp)
            .weight(1f)) {

            Column(modifier = Modifier
                .height(175.dp)
                .width(127.dp)
                .background(
                    color = registerBoarderColor,
                    shape = RoundedCornerShape(large)
                )
                .align(Alignment.BottomCenter)
                .padding(medium),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "اشحن",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(700),
                        color = darkBrown,
                        textAlign = TextAlign.Center,
                    )
                )

                Text(
                    text = "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(400),
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                    )
                )
            }

            Image(
                painter = painterResource(id = R.drawable.group_210),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
        Spacer(modifier = Modifier.width(medium))
        Box(modifier = Modifier
            .height(200.dp)
            .weight(1f)) {

            Column(modifier = Modifier
                .height(175.dp)
                .width(127.dp)
                .background(
                    color = registerBoarderColor,
                    shape = RoundedCornerShape(large)
                )
                .align(Alignment.BottomCenter)
                .padding(medium),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "صوت",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(700),
                        color = darkBrown,
                        textAlign = TextAlign.Center,
                    )
                )

                Text(
                    text = "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(400),
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                    )
                )
            }

            Image(
                painter = painterResource(id = R.drawable.group_212),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }

}