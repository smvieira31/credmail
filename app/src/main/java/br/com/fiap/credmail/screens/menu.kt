package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.Botao
import br.com.fiap.credmail.componentes.ItemsMenus
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo3
import br.com.fiap.credmail.database.repository.UsuarioRepository

@Composable
//fun MenuScreen(navController: NavController) {
fun MenuScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long?) {
    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)
    val usuario = usuarioRepository.buscarPorId(id)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.azul_200))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(45.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Header
            Spacer(modifier = Modifier.height(40.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start){
                IconButton(onClick = { 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("home/${id}")}) {
                    Image(
                        painter = painterResource(id = R.drawable.voltar),
                        contentDescription = "voltar",
                        modifier = Modifier
                        .size(15.dp)
////                        .padding(top = 10.dp)
                )
                }
//                Image(
//                    painter = painterResource(id = R.drawable.voltar),
//                    contentDescription = "voltar",
//                    modifier = Modifier
//                        .size(15.dp)
////                        .padding(top = 10.dp)
//                )
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
                TextoPrincipal(texto = usuario.nome)
            }
            Row {
                TextoTipo3(texto = usuario.email)
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier
                .height(1.dp)
                .width(300.dp), color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))
            ItemsMenus(imagem = R.drawable.icon_email, descricao = "Entrada", textomenu = "Entrada")
            ItemsMenus(imagem = R.drawable.icon_send, descricao = "Enviados", textomenu = "Enviados")
            ItemsMenus(imagem = R.drawable.lixo, descricao = "Excluídos", textomenu = "Excluídos")
            Spacer(modifier = Modifier.height(50.dp))
            Botao(text = "Sair", 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿)

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuScreenPreview() {
    //MenuScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id)
}
