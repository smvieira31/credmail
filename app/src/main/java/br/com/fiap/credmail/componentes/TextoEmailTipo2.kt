package br.com.fiap.credmail.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextoEmailipo2(
    texto: String,
    color: Color
){
    Text(text = texto,
        modifier = Modifier.padding(10.dp),
        fontSize = 12.sp,
        fontWeight = FontWeight.ExtraBold,
        color = color,
        textAlign = TextAlign.Start,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}