package br.com.fiap.credmail.componentes

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.credmail.R

@Composable
fun BotaoSalvar(
){
    Button(
        onClick = {/* TODO */},
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amarelinho))
    ) {
        Text(
            text = "Salvar",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.azul_700),
            fontSize = 11.sp
        )
    }
}