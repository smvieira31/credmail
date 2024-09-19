package br.com.fiap.credmail.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.model.EmailSaidaDTORes

@Composable
fun EmailSaidaCard(emails: EmailSaidaDTORes, 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController){
        Row (verticalAlignment = Alignment.CenterVertically){
            Column (
                //modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center){
                TextoEmail(texto = emails.para, color = Color.Black)
                TextoEmailipo2(texto = emails.titulo, color = Color.Black)
                TextoEmailTipo3(texto = emails.conteudo, color = Color.Black)
                Card (colors = CardDefaults.cardColors(colorResource(id = R.color.azul_200))){
                    TextoTipo5Email(texto = "categoria", color = R.color.azul_200)
                }
            }
        }
    }