package com.trend.camelx.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trend.camelx.R
import com.trend.camelx.screens.destinations.Destination
import com.trend.camelx.ui.theme.CoffeColor
import com.trend.camelx.ui.theme.IbmFont
import com.trend.camelx.ui.theme.backGroundColor
import com.trend.camelx.ui.theme.darkBrown
import com.trend.camelx.ui.theme.extraMedium
import com.trend.camelx.ui.theme.spacing
import com.trend.camelx.ui.theme.spacingLarge
import com.trend.camelx.ui.theme.textColorDefaultDark
import com.trend.camelx.ui.theme.textSizeDefault

@Preview
@Composable
@com.ramcosta.composedestinations.annotation.Destination
fun HomeScreen (){

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = backGroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            TopBarView()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(spacing))

                Text(
                    text = "خطوات المشاركة",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(700),
                        color = darkBrown,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(spacingLarge))

                RegisterExplanationView(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(spacingLarge))

                VideoView()

                Spacer(modifier = Modifier.height(spacingLarge))

                Text(
                    text = "المنافسات المتاحة",
                    modifier = Modifier.align(Alignment.Start),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(700),
                        color = darkBrown,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(spacingLarge))


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
                    remainingTime = 65484
                )

                Spacer(modifier = Modifier.height(extraMedium))

                Surface(
                    modifier = Modifier
                        .width(229.dp)
                        .height(40.dp)
                        .clickable {
                            // onClickAction()
                        },
                    shape = RoundedCornerShape(15.dp),
                    color = CoffeColor
                ) {

                    Row (modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            modifier = Modifier,
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "image arrow",
                            contentScale = ContentScale.None
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "المزيد من المنافسات",
                            style = TextStyle(
                                fontSize = textSizeDefault,
                                fontFamily = IbmFont,
                                fontWeight = FontWeight(500),
                                color = Color.White,

                                textAlign = TextAlign.Right,
                            )
                        )
                    }

                }

                Spacer(modifier = Modifier.height(spacingLarge))

                CompetitionItem(
                    competitionName = "مسابقة جوهرة الصحراء",
                    roundCount = 32,
                    firstCamelName = "اللافته",
                    firstOwnerName = "ناصر بن مبارك آل بريك",
                    firstCamelImg = "https://media.istockphoto.com/id/1300100945/photo/camel-portrait.jpg?s=2048x2048&w=is&k=20&c=ikA9kptMFDRD9LIuF7_vYnHQQclvcNtM7q-KuzhL6RA=",
                    secCamelName = "اللافته",
                    secOwnerName = "عمر بن عشوان المطيري",
                    secCamelImg = "https://media.istockphoto.com/id/967089622/photo/camel-on-the-arabian-peninsula.jpg?s=2048x2048&w=is&k=20&c=TpBjevjN2aHMY18IASQj92hL4c7DnfLXIsGzcPcUTPQ=",
                    percentageFirst = 25f,
                    percentageSec = 75f,
                    remainingTime = 65484,
                    firstState = false,
                    secState = true
                )

                Spacer(modifier = Modifier.height(extraMedium))

                Surface(
                    modifier = Modifier
                        .width(229.dp)
                        .height(40.dp)
                        .clickable {
                            // onClickAction()
                        },
                    shape = RoundedCornerShape(15.dp),
                    color = CoffeColor
                ) {

                    Row (modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            modifier = Modifier,
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "image arrow",
                            contentScale = ContentScale.None
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "المزيد من النتائج",
                            style = TextStyle(
                                fontSize = textSizeDefault,
                                fontFamily = IbmFont,
                                fontWeight = FontWeight(500),
                                color = Color.White,

                                textAlign = TextAlign.Right,
                            )
                        )
                    }

                }
            }
        }

        }
    }

@Preview
@Composable
fun VideoView (modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .width(229.dp)
            .height(40.dp)
            .clickable {
                // onClickAction()
            },
        shape = RoundedCornerShape(15.dp),
        color = Color.White
    ) {

        Row (modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "image arrow",
                contentScale = ContentScale.None
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "لمشاهدة فيديو شرح المسابقة",
                style = TextStyle(
                    fontSize = textSizeDefault,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(500),
                    color = textColorDefaultDark,

                    textAlign = TextAlign.Right,
                )
            )
        }

    }
}

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun SliderView(state: PagerState, viewModel: HomeVIewModelV2) {
//    val cardItem = viewModel.homeBanners
//
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        HorizontalPager(
//            state = state,
//            count = cardItem?.size ?: 0,
//            contentPadding = PaddingValues(horizontal = 32.dp),
//            modifier = Modifier
//                .height(180.dp)
//                .fillMaxWidth()
//                .scrollable( // Enable scrolling in both directions
//                    rememberScrollState(),
//                    Orientation.Horizontal,
//                    enabled = true
//                )
//        ) { page ->
//            if (!cardItem.isNullOrEmpty()) {
//
//                fun lerp(start: Float, stop: Float, fraction: Float): Float {
//                    return (1 - fraction) * start + fraction * stop
//                }
//                Image(
//                    painter = rememberAsyncImagePainter(model = cardItem[page]),
//                    contentDescription = "",
//                    Modifier
//                        .background(
//                            shape = RoundedCornerShape(10.dp),
//                            color = Color.Transparent
//                        )
//                        .fillMaxWidth()
//                        .graphicsLayer {
//                            // Calculate the absolute offset for the current page from the
//                            // scroll position. We use the absolute value which allows us to mirror
//                            // any effects for both directions
//                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//
//                            // We animate the scaleX + scaleY, between 85% and 100%
//                            lerp(
//                                start = 0.85f,
//                                stop = 1f,
//                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                            ).also { scale ->
//                                scaleX = scale
//                                scaleY = scale
//                            }
//
//                            // We animate the alpha, between 50% and 100%
//                            alpha = lerp(
//                                start = 1f,
//                                stop = 1f,
//                                fraction = 1f - pageOffset.coerceIn(1f, 1f)
//                            )
//                        }
//                        .clip(RoundedCornerShape(10.dp))
//                    ,
//                    contentScale = ContentScale.Fit
//                )
//            }
//        }
//    }
//}
