package com.trend.camelx.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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

@Composable
@Preview
fun NewsView(){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(204.dp)) {


        Column(modifier = Modifier
            .fillMaxWidth()
            .height(183.dp)
            .background(color = darkBrown)
            .padding(large)
            .align(Alignment.Center)
        ) {

            Text(
                text = "ولي العهد يشهد الحفل الختامي لمهرجان الإبل ويكرم الفائزين غداً",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    textAlign = TextAlign.Right,
                )
            )

            Text(
                text = "يُشرِّف ولي العهد الأمير محمد بن سلمان، يوم غد (الجمعة)، الحفل الختامي لمهرجان الملك عبدالعزيز للإبل في الصياهد الجنوبية.\nوأوضح رئيس نادي الإبل فهد بن حثلين، أن ولي العهد سيسلم الفائزين جوائزهم نيابة عن خادم الحرمين الشريفين الملك سلمان بن عبدالعزيز.\n",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = IbmFont,
                    fontWeight = FontWeight(400),
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                ),
                maxLines = 2
            )
        }

        Image(
            modifier = Modifier
                .width(133.dp)
                .fillMaxHeight()
                .align(Alignment.CenterStart)
                .padding(start = large)
                .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 16.dp)),
            painter = painterResource(id = R.drawable.rectangle_31),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
    }
}