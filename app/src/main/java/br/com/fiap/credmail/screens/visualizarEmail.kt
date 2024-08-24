package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.BotaoIcone
import br.com.fiap.credmail.componentes.BotaoIconeVec
import br.com.fiap.credmail.componentes.CardVisuEmail
import br.com.fiap.credmail.componentes.TextoTipo5
import br.com.fiap.credmail.database.repository.EmailRepository
import br.com.fiap.credmail.model.Email

@Composable
fun VisualizarScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long?, idEmail: Long?){
    val context = LocalContext.current
    val emailRepository = EmailRepository(context)
    val email: Email = emailRepository.buscaEmail(idEmail)
    emailRepository.emailLido(true,idEmail)
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            //.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Aqui é o cabeçalho
                Row(
//                    modifier = Modifier
//                        .height(150.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    if (id != null) {
                        BotaoIcone(
                            color = Color.White,
                            imagemicone = R.drawable.voltar,
                            descricao = "Voltar",
                            𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,
                            id,
                            "home"
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {

                    Spacer(modifier = Modifier.width(10.dp))
//                    BotaoIconeVec(
//                        color = Color.White,
//                        imagemicone = R.drawable.anexo,
//                        descricao = "Anexar"
//                    )
//                    Spacer(modifier = Modifier.width(10.dp))
                    if (id != null) {
                        BotaoIcone(
                            color = Color.White,
                            imagemicone = R.drawable.lixo,
                            descricao = "Anexar",
                            𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,
                            id,
                            ""
                        )
                    }

                }


            }
            Column(
                modifier = Modifier
                    .height(500.dp)
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                CardVisuEmail(
                    titulo = email.titulo,
                    remetente = email.remetente,
                    categoria = email.categoria,
                    colorcategoria = email.corCard,
                    colortextocategoria = email.corTexto,
                    dataemail = "31/10/2023",
                    conteudo = email.conteudo
                )

            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_200)),
                modifier = Modifier.size(width = 105.dp, height = 80.dp), contentPadding = PaddingValues(15.dp, 5.dp), shape = RoundedCornerShape(16.dp)
            ) {
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(id = R.drawable.responder),
                        contentDescription = "categoriasCards.categoria",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(0.dp)
                    )
                    TextoTipo5(texto = "Responder", color = colorResource(id =  R.color.azul_700))
                }

            }
        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun VisualizarScreenPreview() {
//    VisualizarScreen()
//}