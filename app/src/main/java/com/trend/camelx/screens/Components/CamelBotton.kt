package com.trend.camelx.screens.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.trend.camelx.R
import com.trend.camelx.ui.theme.CoffeColor
import com.trend.camelx.ui.theme.IbmFont
import com.trend.camelx.ui.theme.textSizeDefault

@Composable
fun CamelButton (
    modifier: Modifier = Modifier,
    text : String,
    onClickAction: () -> Unit,
    ){

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Surface(
            modifier = modifier
                .width(125.dp)
                .height(51.dp)
                .clickable {
                    onClickAction()
                },
            shape = RoundedCornerShape(15.dp),
            color = CoffeColor
        ) {

            Row (modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = textSizeDefault,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(700),
                        color = Color.White,

                        textAlign = TextAlign.Right,
                    )
                )

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "image arrow",
                    contentScale = ContentScale.None
                )
            }

        }
    }

}