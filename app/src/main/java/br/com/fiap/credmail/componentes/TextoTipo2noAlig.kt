package br.com.fiap.credmail.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.fiap.credmail.R


@Composable
fun TextoTipo2noAlig(
    texto: String
){
    Text(text = texto,
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = colorResource(id = R.color.azul_700),
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}