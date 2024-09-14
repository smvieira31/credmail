package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R


@Composable
fun BarraInferior(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long, corEscolhida: Long) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(containerColor = Color(corEscolhida)),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = { 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("home/${id}") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(corEscolhida)),
                //modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_email),
                    contentDescription = "Entrada",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(0.dp)
                )

            }
            Button(onClick = { 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("contatos/${id}") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(corEscolhida)),
                //modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_person),
                    contentDescription = "Contatos",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(0.dp)
                )

            }
            Button(onClick = { 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("enviar/${id}") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(corEscolhida)),
                //modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_send),
                    contentDescription = "Enviar",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(0.dp)
                )
            }

        }

    }
}


