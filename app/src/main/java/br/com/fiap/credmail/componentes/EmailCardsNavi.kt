package br.com.fiap.credmail.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.model.Email


@Composable
fun EmailCardsNavi(emails: Email, ){
    Button(onClick = { TODO()},
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp),
        colors =  ButtonDefaults.buttonColors(containerColor = Color.White)

    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Column (
                //modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center){
                if(emails.flagLido){
                    TextoEmail(texto = emails.remetente, color = Color.Gray)
                    TextoEmailipo2(texto = emails.titulo, color = Color.Gray)
                    TextoEmailTipo3(texto = emails.conteudo, color = Color.Gray)
                }
                else{
                    TextoEmail(texto = emails.remetente, color = Color.Black)
                    TextoEmailipo2(texto = emails.titulo, color = Color.Black)
                    TextoEmailTipo3(texto = emails.conteudo, color = Color.Black)
                }
                Card (colors = CardDefaults.cardColors(colorResource(id = emails.corCard))){
                    TextoTipo5Email(texto = emails.categoria, color = emails.corTexto)
                }
            }
        }
    }
}