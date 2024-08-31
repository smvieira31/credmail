package br.com.fiap.credmail.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextoEmailTipo3(
    texto: String,
    color: Color,
){
    Text(text = texto,
        //modifier = Modifier.fillMaxWidth(),
        fontSize = 10.sp,
        color = color,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}