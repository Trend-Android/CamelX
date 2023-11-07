package com.trend.camelx.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.trend.camelx.R
import com.trend.camelx.screens.Components.CamelButton
import com.trend.camelx.screens.Components.CamelEditText
import com.trend.camelx.screens.login.PhoneView
import com.trend.camelx.ui.theme.IbmFont
import com.trend.camelx.ui.theme.backGroundColor
import com.trend.camelx.ui.theme.darkBrown

@Destination
@Composable
fun RegisterScreen(
    navigator: DestinationsNavigator
) {

    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirmed by remember { mutableStateOf("") }

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    var isErrorPhone by remember { mutableStateOf(false) }
    var isErrorPassword by remember { mutableStateOf(false) }
    var isErrorFirstName by remember { mutableStateOf(false) }
    var isErrorLastName by remember { mutableStateOf(false) }

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
                text = "حساب جديد",
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
                painter = painterResource(id = R.drawable.img_register),
                contentDescription = "image login",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(214.dp)
                    .height(255.dp)
            )

            CamelEditText(
                text = firstName ,
                label = "الاسم الأول",
                onTextChange = {firstName = it},
                isError = isErrorFirstName,
                showLabelFocused = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            CamelEditText(
                text = lastName ,
                label = "الاسم الأخير",
                onTextChange = {lastName = it},
                isError = isErrorFirstName,
                showLabelFocused = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {

                val maxChar = 9

                CamelEditText(
                    modifier = Modifier.weight(3f),
                    text = phone ,
                    label = "5xxxxxxxx",
                    onTextChange = {if (it.length <= maxChar) phone = it},
                    showLabelFocused = true,
                    isError = isErrorPhone,
                    keyboardType = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next),
                )

                Spacer(modifier = Modifier.width(15.dp))

                PhoneView(modifier = Modifier
                    .weight(1f)
                    .align(Alignment.Bottom))
            }

            Spacer(modifier = Modifier.height(8.dp))

            CamelEditText(
                modifier = Modifier,
                text = password ,
                label = "كلمة المرور",
                onTextChange = {password = it},
                isError = false,
                isPassword = true,
                showLabelFocused = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            CamelEditText(
                modifier = Modifier,
                text = passwordConfirmed ,
                label = "تأكيد كلمة المرور",
                onTextChange = {passwordConfirmed = it},
                isError = isErrorPhone,
                isPassword = true,
                showLabelFocused = true
            )

            Spacer(modifier = Modifier.height(8.dp))


            var checkedState by rememberSaveable { mutableStateOf(false) }


            TermsAndConditionsField( modifier = Modifier.align(Alignment.Start),
                checkedState = checkedState,
                onCheckedState = { checkedState = it}){

            }

            Spacer(modifier = Modifier.height(48.dp))

            CamelButton(text = "تسجيل", modifier = Modifier.fillMaxWidth()) {
                
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsAndConditionsField( modifier: Modifier = Modifier,
                             checkedState : Boolean,
                             onCheckedState : (Boolean) -> Unit,
                             onClick : () -> Unit){

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = onCheckedState,
                colors = CheckboxDefaults.colors(
                    checkedColor = darkBrown,
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White
                ),
            )

            Text(
                text = "أوافق على",
                fontFamily = IbmFont,
                color = Color.Gray,
            )

            Text(
                text = "سياسة الخصوصية وشروط الاستخدام",
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable { onClick() },
                color = Color.Gray,
                fontFamily = IbmFont,
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )

        }
    }
}