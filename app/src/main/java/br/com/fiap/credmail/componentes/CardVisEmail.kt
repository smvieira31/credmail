package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.R

@Composable
fun CardVisuEmail(
    titulo: String,
    remetente: String,
    categoria: String,
    colorcategoria: Int,
    colortextocategoria: Int,
    dataemail: String,
    conteudo: String


){
    Card (
        colors = CardDefaults.cardColors(containerColor = Color.White
        )
    ){

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            TextoEmail(texto = titulo, Color.Black)
            Card(colors = CardDefaults.cardColors(colorResource(id = colorcategoria))) {
                TextoTipo5Email(texto = categoria, color = colortextocategoria)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Imagem User",
                    modifier = Modifier.size(100.dp)
                )
                Column(
                    //modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    TextoMenu(texto = remetente)
                    TextoContatoTipo2(texto = dataemail)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                TextoEmailTipo3(texto = conteudo, color = Color.Gray)
            }
        }
    }
}