package com.example.yollotl_app.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.yollotl_app.ui.theme.alegreyaFont
import com.example.yollotl_app.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LoginView() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "\"Respira. \nEstás a salvo.\"",
            fontFamily = alegreyaFont,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        LogoImage()
        ButtonLogin()

    }
}

@Composable
fun LogoImage() {
    Image(
        painter = painterResource(R.drawable.logo_yollotl),
        contentDescription = "Logo",
        modifier = Modifier.size(300.dp)
    )

}

@Composable
fun ButtonLogin() {
    Button(
        modifier = Modifier.height(62.dp).width(237.dp),
        onClick = {}, shape = RoundedCornerShape(54.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF371B34), // Color de fondo más suave
            contentColor = Color.White,
        ),


    ) {
        Text("Abrir el corazón", fontFamily = alegreyaFont, fontSize = 25.sp, fontWeight = FontWeight.Medium)
    }

}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    LoginView()
}