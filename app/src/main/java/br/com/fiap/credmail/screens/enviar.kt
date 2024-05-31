package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.componentes.TextoTipo2Right

@Composable
fun EnviarScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Header
            Column {
                //Aqui é o cabeçalho
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .height(150.dp),
                    verticalAlignment    = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.voltar),
                        contentDescription = "voltar",
                        modifier = Modifier
                            .size(15.dp)
//                        .padding(top = 10.dp)
                    )
                    TextoTipo2(texto = "Enviar e -mail")
                }

            }
            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                //Aqui é a parte inicial do email
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,

                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_send),
                        contentDescription = "Enviar",
                        modifier = Modifier
                            .size(20.dp)
//                        .padding(top = 10.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.anexo),
                        contentDescription = "Anexar",
                        modifier = Modifier
                            .size(20.dp)
//                        .padding(top = 10.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "De")
                    Text(text = "Eseuemail@emaple.com.be") //Mudar p textField
                }
                Divider(modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth(), color = Color.LightGray)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Para")
                    Text(text = "Outroemail@emaple.com.be")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(Color.LightGray),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(text = "Assunto")
                    Text(text = "Seu Assunto Aqui")
                }
                Text(text = "Caixa para escrever email")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EnviarScreenPreview() {
    EnviarScreen()
}
