package br.com.fiap.credmail.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.credmail.R

@Composable
fun TextoMenu(
    texto: String
){
    Text(text = texto,
        modifier = Modifier.padding(10.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        color = colorResource(id = R.color.azul_700),
        textAlign = TextAlign.Start,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}