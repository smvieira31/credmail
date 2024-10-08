package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BotaoIconesNavi(
    color: Color,
    imagemicone: Int,
    descricao: String,


){
    Button(
        onClick = { TODO() },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.size(width = 20.dp, height = 20.dp), contentPadding = PaddingValues(0.dp), shape = RectangleShape
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp)){
            Image(
                painter = painterResource(id = imagemicone),
                contentDescription = descricao,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp)
            )
        }

    }

}