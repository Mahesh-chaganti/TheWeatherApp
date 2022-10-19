package com.example.septemberproject24.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.septemberproject24.ui.theme.fontFamily


@Composable
fun DrawerButton(text: String, image: ImageVector, onClick: () -> Unit) {

    Button(
        modifier = Modifier
            .padding(5.dp),
        border = BorderStroke(2.dp, Color.White),
        shape = RoundedCornerShape(36.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),

        onClick = onClick
    ) {

        Icon(
            imageVector = image,
            contentDescription = null
        )

        Text(
            textAlign = TextAlign.Center,
            text = text,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(5.dp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

    }


}
