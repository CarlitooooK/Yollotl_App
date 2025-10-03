package com.example.yollotl_app.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yollotl_app.ui.theme.alegreyaFont
import kotlin.math.sinh

@Composable
fun LoginScreen() {
    var user by remember { mutableStateOf(" ") }
    var password by remember { mutableStateOf(" ") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LogoImage(200.dp)
        TextInstruccions("Usuario:")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = user,
            onValueChange = { user },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Icon User") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        TextInstruccions("Contraseña:")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Icon User") },
            singleLine = true,
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Lock
                else Icons.Filled.Done
                val description = if(passwordVisible) "Ocultar Contraseña" else "Mostar Contraseña"

                IconButton(onClick = {passwordVisible = !passwordVisible}) {
                    Icon(imageVector = image, contentDescription = description)
                }
            },
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        ButtonLogin()

    }
}

@Composable
fun TextInstruccions(text: String) {
    Text(text = text, fontFamily = alegreyaFont, fontSize = 30.sp, fontWeight = FontWeight.Medium)
}

fun Bot() {

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginScreenView() {
    LoginScreen()
}

