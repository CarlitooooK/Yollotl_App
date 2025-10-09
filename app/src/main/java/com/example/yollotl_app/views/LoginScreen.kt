package com.example.yollotl_app.views

import androidx.compose.foundation.background
import com.example.yollotl_app.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yollotl_app.ui.theme.alegreyaFont
import com.example.yollotl_app.ui.theme.backgroundColor
import com.example.yollotl_app.ui.theme.blackPurple
import com.example.yollotl_app.ui.theme.creamBackground

@Composable
fun LoginScreen() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()
    val gradienColors = listOf(backgroundColor, Color.White)

    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = gradienColors,
                    startY = 0.0f,
                    endY = 500.0f
                )
            )
            .verticalScroll(scrollState)
            .imePadding()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        LogoImage(200.dp)
        TextInstruccions("\"Tu paz es tu superpoder.\nEmpecemos\"", 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        TextInstruccions("Usuario:", 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = user,
            onValueChange = { user = it },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Icon User") },
            keyboardType = KeyboardType.Text,
            fontFamily = alegreyaFont
        )
        Spacer(modifier = Modifier.height(25.dp))
        TextInstruccions("Contraseña:", 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Lock Icon") },
            keyboardType = KeyboardType.Text,
            fontFamily = alegreyaFont,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val iconId = if (passwordVisible) R.drawable.ic_closed_eye else R.drawable.ic_open_eye
                val description =
                    if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = iconId),
                        contentDescription = description,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
        )
        Column(Modifier.align(Alignment.End)) {
            TextInstruccions("Olvide mi contraseña", 18.sp, Modifier.padding(end = 50.dp))
        }
        Spacer(modifier = Modifier.height(60.dp))
        ButtonLog("Entrar")
        TextInstruccions("¿Eres nuevo por aqui? Registrate", 20.sp, Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun TextInstruccions(text: String, size: TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontFamily = alegreyaFont,
        fontSize = size,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun ButtonLog(text: String) {
    Button(
        modifier = Modifier
            .height(62.dp)
            .width(237.dp),
        onClick = {},
        shape = RoundedCornerShape(54.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF371B34),
            contentColor = Color.White,
        ),
    ) {
        Text(text, fontFamily = alegreyaFont, fontSize = 25.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    fontFamily: FontFamily
) {
    val textStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
    )

    val colors = TextFieldDefaults.colors(
        focusedLeadingIconColor = blackPurple,
        focusedTextColor = Color.Black,
        focusedContainerColor = creamBackground,
        focusedIndicatorColor = Color.Black,
        focusedTrailingIconColor = blackPurple,
        unfocusedIndicatorColor = Color.Black,
        unfocusedContainerColor = creamBackground,
        unfocusedLeadingIconColor = blackPurple,
        unfocusedTrailingIconColor = blackPurple
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(20.dp),
        colors = colors,
        modifier = Modifier.width(280.dp)
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginScreenView() {
    LoginScreen()
}