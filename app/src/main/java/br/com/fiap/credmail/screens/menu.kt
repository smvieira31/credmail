package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.ItemsMenus
import br.com.fiap.credmail.componentes.TextoMenu
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo3

@Composable
fun MenuScreen() {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.azul_200))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(45.dp)
                .border(1.dp, Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Header
            Spacer(modifier = Modifier.height(40.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start){
                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = "voltar",
                    modifier = Modifier
                        .size(15.dp)
//                        .padding(top = 10.dp)
                )
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "voltar",
                    modifier = Modifier
                        .size(100.dp)
                )
            }
            Row {
                TextoPrincipal(texto = "Sua Conta")
            }
            Row {
                TextoTipo3(texto = "seuemail@example.com")
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier
                .height(1.dp)
                .width(300.dp), color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))
            ItemsMenus(imagem = R.drawable.icon_email, descricao = "Enviados", textomenu = "Enviados")
            ItemsMenus(imagem = R.drawable.icon_send, descricao = "Enviados", textomenu = "Enviados")
            ItemsMenus(imagem = R.drawable.icon_send, descricao = "Enviados", textomenu = "Enviados")
            ItemsMenus(imagem = R.drawable.icon_send, descricao = "Enviados", textomenu = "Enviados")
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(),
                    //.height(100.dp),
                shape = RectangleShape,
                contentPadding = PaddingValues(0.dp),
                colors =  ButtonDefaults.buttonColors(colorResource(id = R.color.azul_200))

            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_send),
                        contentDescription = "Enviados",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    TextoMenu(texto = "Enviados")
                }
            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen()
}
