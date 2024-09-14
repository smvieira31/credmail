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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import br.com.fiap.credmail.componentes.TextoMenu
import br.com.fiap.credmail.componentes.TextoTipo3
import br.com.fiap.credmail.componentes.Voltar
import br.com.fiap.credmail.database.repository.UsuarioRepository

@Composable
//fun MenuScreen(navController: NavController) {
fun MenuScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long?) {
    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)
    val usuario = usuarioRepository.buscarPorId(id)


    /* TODO */
    /*colocar a variavel de cor escolhida p pssa */

    var corEscolhida = 0xFFDAC8CD

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(corEscolhida))) {
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
                Voltar(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿 = 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id = id)
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User",
                    modifier = Modifier
                        .size(100.dp)
                )
            }
            Row {
                TextoMenu(texto = usuario.nome)
                Icon(imageVector = Icons.Default.Edit, contentDescription = "editar", tint = Color.Black)

            }
            Row {
                TextoTipo3(texto = usuario.email)
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier
                .height(1.dp)
                .width(300.dp), color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))
            ItemsMenus(imagem = R.drawable.icon_email, descricao = "Entrada", textomenu = "Entrada", onclick = {𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("home/${id}")}, corEscolhida = corEscolhida)
            ItemsMenus(imagem = R.drawable.icon_send, descricao = "Enviados", textomenu = "Enviados", onclick = {𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("home/${id}")}, corEscolhida = corEscolhida)
            ItemsMenus(imagem = R.drawable.lixo, descricao = "Excluídos", textomenu = "Excluídos", onclick = {𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("home/${id}")}, corEscolhida = corEscolhida)
            ItemsMenus(imagem = R.drawable.spam, descricao = "Spam", textomenu = "Spam", onclick = {𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("spam/${id}")}, corEscolhida= corEscolhida)
            ItemsMenus(imagem = R.drawable.config, descricao = "Configurações", textomenu = "Configurações", onclick = {𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("configuracao/${id}")}, corEscolhida = corEscolhida)
            ItemsMenus(imagem = R.drawable.mais, descricao = "Adicionar Categoria", textomenu = "Adicionar Categoria", onclick = {𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("configuracao/${id}")}, corEscolhida = corEscolhida)
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
