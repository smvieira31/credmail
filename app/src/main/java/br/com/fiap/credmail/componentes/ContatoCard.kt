package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.model.ContatoAgenda

@Composable
fun ContatoCard(contatoAgenda: ContatoAgenda){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp),
        colors =  ButtonDefaults.buttonColors(containerColor = Color.White)

    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id =contatoAgenda.rosto), contentDescription = "Imagem User", modifier = Modifier.size(100.dp))
            Column (
                //modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center){
                TextoMenu(texto = contatoAgenda.nome)
                TextoContatoTipo2(texto = contatoAgenda.email)
            }
        }
    }
}