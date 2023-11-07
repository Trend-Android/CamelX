@file:Suppress("UNUSED_EXPRESSION")

package com.trend.camelx.screens.Components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trend.camelx.ui.theme.IbmFont
import com.trend.camelx.ui.theme.borderColor


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CamelEditText(
    text: String,
    label: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean,
    isPassword: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardOptions = KeyboardOptions.Default,
    textAlign: Boolean = false,
    readOnly: Boolean = false,
    showLabelFocused: Boolean = false // Added parameter to control label visibility
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value
    var passwordVisible by rememberSaveable { mutableStateOf(false) } // State to toggle password visibility

    val visualTransformation =
        if (!passwordVisible && isPassword) PasswordVisualTransformation()
        else
            VisualTransformation.None

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        modifier = modifier.fillMaxWidth(),
        interactionSource = interactionSource,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = borderColor,
            backgroundColor = Color.White
        ),
        trailingIcon = {
            if (isPassword) {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            } else {
                trailingIcon?.invoke()
            }
        },
        isError = isError,
        readOnly = readOnly,
        label = {
            if (isFocused || showLabelFocused) {
                AutoSizeText(
                    text = label,
                    color = Color.Gray,
                    fontFamily = IbmFont,
                    fontSize = 12.sp
                )
            }
        }, // Show the label based on isFocused or showLabelFocused
        keyboardOptions = keyboardType.copy(keyboardType = if (isPassword) KeyboardType.Password
        else keyboardType.keyboardType),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(15.dp),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        textStyle = if (textAlign) LocalTextStyle.current.copy(textAlign = TextAlign.Center) else LocalTextStyle.current,
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewCamelEditText() {
    // Provide the necessary parameters for the CamelEditText composable function.
    CamelEditText(
        text = "Sample",
        label = "Label",
        onTextChange = {},
        modifier = Modifier.padding(16.dp),
        isError = false,
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Visibility,
                contentDescription = "Trailing icon"
            )
        },
        keyboardType = KeyboardOptions.Default
        // Add other parameters if necessary.
    )
}