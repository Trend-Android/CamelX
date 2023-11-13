package com.trend.camelx.screens.login

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.trend.camelx.R
import com.trend.camelx.screens.Components.CamelButton
import com.trend.camelx.screens.Components.CamelEditText
import com.trend.camelx.screens.destinations.HomeScreenDestination
import com.trend.camelx.screens.destinations.RegisterScreenDestination
import com.trend.camelx.ui.theme.CoffeColor
import com.trend.camelx.ui.theme.IbmFont
import com.trend.camelx.ui.theme.backGroundColor
import com.trend.camelx.ui.theme.darkBrown
import com.trend.camelx.ui.theme.textSizeDefault

@RootNavGraph(start = true) // sets this as the start destination of the default nav graph
@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
){

    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isErrorPhone by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = backGroundColor)
                .padding(21.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(61.dp))

            Text(
                text = "اقلط",
                style = TextStyle(
                    fontSize = 29.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(700),
                    color = darkBrown,
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(21.dp))

            Image(
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = "image login",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(193.dp)
                    .height(303.dp)
            )

            Spacer(modifier = Modifier.height(21.dp))

            Text(
                text = "رقم الجوال",
                modifier = Modifier.align(Alignment.Start),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(700),
                    color = darkBrown,
                    textAlign = TextAlign.Right,
                )
            )

            Spacer(modifier = Modifier.height(9.dp))


            Row(modifier = Modifier.fillMaxWidth()) {

                val maxChar = 9

                CamelEditText(
                    modifier = Modifier.weight(3f),
                    text = phone ,
                    label = "5xxxxxxxx",
                    onTextChange = { if (it.length <= maxChar) phone = it},
                    isError = isErrorPhone,
                    keyboardType = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next)
                )

                Spacer(modifier = Modifier.width(15.dp))

                PhoneView(modifier = Modifier.weight(1f).align(Alignment.Bottom))
            }

            Spacer(modifier = Modifier.height(21.dp))

            Text(
                text = "كلمة المرور",
                modifier = Modifier.align(Alignment.Start),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(700),
                    color = darkBrown,
                    textAlign = TextAlign.Right,
                )
            )

            Spacer(modifier = Modifier.height(9.dp))

            CamelEditText(
                modifier = Modifier,
                text = password ,
                label = "كلمة المرور",
                onTextChange = {password = it},
                isError = isErrorPhone,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(21.dp))


            Text(
                text = "هل نسيت كلمة المرور؟",
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {

                    },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6F6F6F),)
            )

            Spacer(modifier = Modifier.height(32.dp))

            CamelButton(text = "دخول"){
                navigator.navigate(HomeScreenDestination())
            }

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "تسجيل الآن",
                modifier = Modifier.clickable {
                   navigator.navigate(RegisterScreenDestination())

                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(700),
                    color = darkBrown,
                    textAlign = TextAlign.Right,
                )
            )
        }
    }
}

@Preview
@Composable
fun PhoneView(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .width(125.dp)
            .height(55.dp),
        shape = RoundedCornerShape(15.dp),
        color = Color.White
    ) {

        Row (modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "966",
                style = TextStyle(
                    fontSize = textSizeDefault,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(700),
                    color = Color.Gray,

                    textAlign = TextAlign.Right,
                )
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.img_saudia),
                contentDescription = "image arrow",
                contentScale = ContentScale.None
            )
        }

    }
}