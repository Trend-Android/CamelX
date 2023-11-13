package com.trend.camelx.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
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
import com.trend.camelx.ui.theme.backGroundColorDarker
import com.trend.camelx.ui.theme.darkBrown

@Composable
@Preview
fun TopBarView() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(158.dp)
            .background(color = backGroundColorDarker)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "ارحب يا محمـد",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = IbmFont,
                        fontWeight = FontWeight(700),
                        color = darkBrown,
                        textAlign = TextAlign.Right,
                    )
                )

                Image(
                    painter = painterResource(id = R.drawable.group_6),
                    contentDescription = "image group",
                    contentScale = ContentScale.None,
                    modifier = Modifier.size(41.dp)
                )
            }

            Text(
                text = "يا مرحبا يا ريحة الورد والهيل .. لا هبت النسمة وتطاير عطرها",
                modifier = Modifier.padding(start = 16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(400),
                    color = Color.Gray,
                    textAlign = TextAlign.Right,
                )
            )
        }
    }
}