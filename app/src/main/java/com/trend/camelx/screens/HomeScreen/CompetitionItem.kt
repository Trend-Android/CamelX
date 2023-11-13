package com.trend.camelx.screens.HomeScreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.trend.camelx.R
import com.trend.camelx.ui.theme.CoffeColor
import com.trend.camelx.ui.theme.IbmFont
import com.trend.camelx.ui.theme.borderColor
import com.trend.camelx.ui.theme.borderGreenColor
import com.trend.camelx.ui.theme.cardImageColor
import com.trend.camelx.ui.theme.darkBrown
import com.trend.camelx.ui.theme.darkGreenColor
import com.trend.camelx.ui.theme.extraLarge
import com.trend.camelx.ui.theme.extraSmall
import com.trend.camelx.ui.theme.large
import com.trend.camelx.ui.theme.lightGreenColor
import com.trend.camelx.ui.theme.medium
import com.trend.camelx.ui.theme.small
import com.trend.camelx.ui.theme.textColorDefaultDark
import com.trend.camelx.ui.theme.textSizeDefault
import kotlinx.coroutines.delay

@Composable
fun CompetitionItem(
    modifier: Modifier= Modifier,
    competitionName : String,
    roundCount : Int,
    firstCamelName : String,
    firstOwnerName : String,
    firstCamelImg : String,
    secCamelName : String,
    secOwnerName : String,
    secCamelImg : String,
    percentageFirst : Float,
    percentageSec: Float,
    remainingTime : Long,
    firstState : Boolean = false,
    secState : Boolean = false
){

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Card(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(extraLarge)
                )
                .padding(top = large, bottom = large, start = extraLarge, end = extraLarge),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = competitionName,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF8F5A3B),
                        textAlign = TextAlign.Right,
                    )
                )

                Text(
                    text = "الجولة $roundCount",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF8F5A3B),
                    )
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(modifier = Modifier
                    .height(240.dp)
                    .width(157.dp)
                    .weight(1f)
                ) {

                    Surface(modifier = Modifier
                        .height(240.dp)
                        .width(157.dp)
                        .padding(top = 12.dp, bottom = 15.dp)
                        .align(Alignment.TopCenter),
                        shape = RoundedCornerShape(10.dp),
                        color = cardImageColor,
                        border = BorderStroke(width = 1.dp, color = if (firstState) borderGreenColor else cardImageColor)
                    ) {

                        Column(modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {

                            Spacer(modifier = Modifier.height(12.dp))

                            Image(
                                painter = rememberAsyncImagePainter(model = firstCamelImg),
                                contentDescription = "image description",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(123.dp)
                                    .height(123.dp)
                                    .background(
                                        color = Color(0xFFE6E6E6),
                                        shape = RoundedCornerShape(size = extraLarge)
                                    )
                            )

                            Spacer(modifier = Modifier.height(small))

                            Text(
                                text = firstCamelName,
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = IbmFont,
                                    fontWeight = FontWeight(700),
                                    color = darkBrown,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.height(extraSmall))

                            Text(
                                text = firstOwnerName,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = IbmFont,
                                    fontWeight = FontWeight(400),
                                    color = textColorDefaultDark,
                                    textAlign = TextAlign.Center,
                                )
                            )

                            Spacer(modifier = Modifier.height(large))
                        }

                    }


                    if (firstState){
                        WinnerBanner(modifier = Modifier.align(Alignment.BottomCenter))

                    }
                }

                Spacer(modifier = Modifier.width(small))

                Box(modifier = Modifier
                    .height(240.dp)
                    .width(157.dp)
                    .weight(1f)
                ) {
                    Surface(modifier = Modifier
                        // .weight(1f)
                        .height(240.dp)
                        .width(157.dp)
                        .padding(top = 12.dp, bottom = 15.dp),
                        shape = RoundedCornerShape(10.dp),
                        color = cardImageColor,
                        border = BorderStroke(width = 1.dp, color = if (secState) borderGreenColor else cardImageColor)

                    ) {

                        Column(modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {

                            Spacer(modifier = Modifier.height(12.dp))

                            Image(
                                painter = rememberAsyncImagePainter(model = secCamelImg),
                                contentDescription = "image description",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(123.dp)
                                    .height(123.dp)
                                    .background(
                                        color = Color(0xFFE6E6E6),
                                        shape = RoundedCornerShape(size = extraLarge)
                                    )
                            )

                            Spacer(modifier = Modifier.height(small))

                            Text(
                                text = secCamelName,
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = IbmFont,
                                    fontWeight = FontWeight(700),
                                    color = darkBrown,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.height(extraSmall))

                            Text(
                                text = secOwnerName,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = IbmFont,
                                    fontWeight = FontWeight(400),
                                    color = textColorDefaultDark,
                                    textAlign = TextAlign.Center,
                                )
                            )

                            Spacer(modifier = Modifier.height(large))
                        }

                    }

                    if (secState){
                        WinnerBanner(modifier = Modifier.align(Alignment.BottomCenter))

                    }
                }

            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically)
            {
                Column {

                    Spacer(modifier = Modifier.height(large))

                    CompetitionProgressBar(
                        percentageFirst = percentageFirst,
                        colorFirst = darkBrown,
                        percentageSecond = percentageSec,
                        colorSecond = CoffeColor
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically)
            {
                Text(
                    text = "60%",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = IbmFont),
                        fontWeight = FontWeight(400),
                        color = Color.Gray,
                    )

                Text(
                    text = "40%",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = IbmFont),
                    fontWeight = FontWeight(400),
                    color = Color.Gray,
                )
            }

            Surface(modifier = Modifier
                .fillMaxWidth()
                .height(87.dp),
                color = borderColor) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){

                    Button(
                        modifier = Modifier
                            .width(267.dp)
                            .height(54.dp)
                            .weight(3f),
                        shape = RoundedCornerShape(70.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = darkGreenColor),
                        onClick = { /*TODO*/ }
                    ) {

                        Text(
                            text = "تصويت",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = IbmFont,
                                fontWeight = FontWeight(700),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                            )
                        )
                    }

                    Spacer(modifier = Modifier.width(small))

                    TimerProgress(totalTime = remainingTime, modifier = Modifier.weight(1f))
                }
            }

        }
    }
}

@Composable
@Preview
fun WinnerBanner (modifier : Modifier = Modifier){

    Surface(
        modifier = modifier
            .width(112.dp)
            .height(28.dp)
            .clickable {
                // onClickAction()
            },
        shape = RoundedCornerShape(7.dp),
        color = borderGreenColor
    ) {

        Row (modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "الفائز بالجولة",
                fontSize = 13.sp,
                style = TextStyle(
                    fontSize = textSizeDefault,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(400),
                    color = Color.White,

                    textAlign = TextAlign.Right,
                )
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.ic_cup),
                contentDescription = "image cup",
                contentScale = ContentScale.None,
            )
        }

    }
}
@Composable
fun AnimatedProgressBar(
    progress: Float,
    color: Color,
    modifier: Modifier = Modifier
) {
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing), label = ""
    )

    Canvas(modifier = modifier) {
        drawRoundRect(
            color = color,
            size = androidx.compose.ui.geometry.Size(width = size.width * animatedProgress.value, height = size.height),
            cornerRadius = CornerRadius(x = 4.dp.toPx(), y = 4.dp.toPx())
        )
    }
}

@Composable
fun CompetitionProgressBar(
    percentageFirst: Float,
    colorFirst: Color,
    percentageSecond: Float,
    colorSecond: Color,
    height: Dp = 14.dp
) {
    Row(
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White) // Background color of the full progress bar
    ) {
        Canvas(
            modifier = Modifier
                .weight(percentageFirst)
                .fillMaxHeight()
        ) {
            drawRoundRect(
                color = colorFirst,
                size = Size(width = size.width, height = size.height),
                cornerRadius = CornerRadius(8.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.width(small))
        Canvas(
            modifier = Modifier
                .weight(percentageSecond)
                .fillMaxHeight()
        ) {
            drawRoundRect(
                color = colorSecond,
                size = Size(width = size.width, height = size.height),
                cornerRadius = CornerRadius(8.dp.toPx())
            )
        }
    }
}



@SuppressLint("UnrememberedMutableState")
@Composable
fun TimerProgress(modifier: Modifier = Modifier, totalTime: Long) {
    // State to represent the remaining time
    var timeLeft by remember { mutableStateOf(totalTime) }
    // State to represent the progress (0f to 1f)
    val progress by derivedStateOf { (timeLeft.toFloat() / totalTime) }

    LaunchedEffect(key1 = totalTime) {
        while (timeLeft > 0) {
            delay(1000) // Update every second
            timeLeft -= 1000 // Decrease remaining time
        }
    }

    // Circular progress indicator with text in the middle
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(54.dp),
            progress = progress,
            strokeWidth = 4.dp,
            color = lightGreenColor,
        )
        Text(text = "${timeLeft / 1000}s", color = lightGreenColor)
    }
}

@Preview
@Composable
fun PreviewTimerProgress() {
    TimerProgress(totalTime = 60000) // 60 seconds for example
}

@Preview
@Composable
fun PreviewCardView() {
    CompetitionItem(
        competitionName = "مسابقة جوهرة الصحراء",
        roundCount = 32,
        firstCamelName = "اللافته",
        firstOwnerName = "ناصر بن مبارك آل بريك",
        firstCamelImg = "https://media.istockphoto.com/id/1300100945/photo/camel-portrait.jpg?s=2048x2048&w=is&k=20&c=ikA9kptMFDRD9LIuF7_vYnHQQclvcNtM7q-KuzhL6RA=",
        secCamelName = "اللافته",
        secOwnerName = "عمر بن عشوان المطيري",
        secCamelImg = "https://media.istockphoto.com/id/967089622/photo/camel-on-the-arabian-peninsula.jpg?s=2048x2048&w=is&k=20&c=TpBjevjN2aHMY18IASQj92hL4c7DnfLXIsGzcPcUTPQ=",
        percentageFirst = 60f,
        percentageSec = 40f,
        remainingTime = 65484,
        firstState = true,
        secState = false

    )
}