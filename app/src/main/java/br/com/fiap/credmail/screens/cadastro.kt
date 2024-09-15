package br.com.fiap.credmail.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.CaixadeEntrada
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.database.repository.EmailRepository
import br.com.fiap.credmail.database.repository.UsuarioRepository
import br.com.fiap.credmail.model.CadastroUsuarioReq
import br.com.fiap.credmail.model.CadastroUsuarioRes
import br.com.fiap.credmail.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CadastroScreen(
    cadastroViewModel: CadastroViewModel,
    navController: NavController,
    texto: String?
){

    val nome by cadastroViewModel.nome.observeAsState(initial = "")
    val email by cadastroViewModel.email.observeAsState(initial = "")
    val password by cadastroViewModel.password.observeAsState(initial = "")
    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)
    val emailRepository = EmailRepository(context)
    var confirmaSenha by remember {
        mutableStateOf("")
    }
    var mensagem by remember {
        mutableStateOf(CadastroUsuarioRes())
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Card(
                    modifier = Modifier
                        .width(340.dp)
                        .offset(y = (200).dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Spacer(modifier = Modifier.height(20.dp))
                        TextoPrincipal(texto = "Cadastre sua conta")
                        if(!texto.equals("sem valor")){
                            Spacer(modifier = Modifier.height(20.dp))
                            TextoTipo2(texto = texto.orEmpty())
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        CaixadeEntrada(placeHolder = "Digite um nome de usuário", keyboardType = KeyboardType.Text,value = nome, atualizaValor = {cadastroViewModel.onNomeChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(placeHolder = "Digite um e-mail", keyboardType = KeyboardType.Email,value = email, atualizaValor = {cadastroViewModel.onEmailChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(placeHolder = "Digite sua senha", keyboardType = KeyboardType.Password, value = password, atualizaValor = {cadastroViewModel.onPasswordChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada( placeHolder = "Confirme sua senha", keyboardType = KeyboardType.Password, value = confirmaSenha, atualizaValor = {confirmaSenha = it})
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                if(password.equals(confirmaSenha)) {
                                //    val idUsuario = usuarioRepository.salvar(
                                //        Usuario(
                                //            nome = nome,
                                //            email = email,
                                //            senha = password,
                                //            id = null
                                //        )
                                //    )
                                    //emailRepository.salvarEmail(Email(id= null,remetente = "PicPay",titulo = "Dê mais pique pro seu dinheiro!",categoria = "Financeiro", conteudo = "...", corTexto = R.color.vermelho, corCard = R.color.vermelhinho, idUsuario = idUsuario,flagLido = false))
                                    //emailRepository.salvarEmail(Email(id= null,remetente = "Decolar",titulo = "Eba! Sua viagem está confirmada",categoria = "Mobilidade", conteudo = "...", corTexto = R.color.amarelo, corCard = R.color.amarelinho, idUsuario = idUsuario,flagLido = false))
                                    //emailRepository.salvarEmail(Email(id= null,remetente = "Amil",titulo = "Quer viver a vida ao máximo",categoria = "Bem-estar", conteudo = "...", corTexto = R.color.outroazul, corCard = R.color.outroazulzinho, idUsuario = idUsuario,flagLido = false))*/
                                    val call = RetrofitFactory().postCadastroService().setCadastro(
                                        CadastroUsuarioReq(nome = nome,password = password, confirma= confirmaSenha,email= email)
                                    )
                                    call.enqueue(object : Callback<CadastroUsuarioRes>{
                                        override fun onResponse(
                                            call: Call<CadastroUsuarioRes>,
                                            response: Response<CadastroUsuarioRes>
                                        ) {
                                            Log.i("informação", "onResponse ${response.code()} e o body ${response.body()}")
                                            var mensagem = response.body()!!
                                            if(mensagem.mensagem!=null)
                                                navController.navigate("cadastro?mensagem=${response.body()!!.mensagem}")
                                        }

                                        override fun onFailure(
                                            call: Call<CadastroUsuarioRes>,
                                            t: Throwable
                                        ) {
                                            t.printStackTrace()
                                            TODO("Not yet implemented")
                                        }
                                    })
                                    }

                            },
                            modifier = Modifier
                                .width(120.dp)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amarelinho))
                        ) {
                            Text(
                                text = "Cadastrar",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.azul_700),
                                fontSize = 11.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                navController.navigate("𝗹𝗼𝗴𝗶𝗻")
                            },
                            modifier = Modifier
                                .width(120.dp)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amarelinho))
                        ) {
                            Text(
                                text = "Voltar",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.azul_700),
                                fontSize = 11.sp
                            )
                        }

                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.cadastro),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(340.dp)
                        .offset(y = (-500).dp)
//                        .padding(top = 10.dp)
                )
            }
        }
    }
}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CadastroScreenPreview(navController: NavController) {
//    CadastroScreen(CadastroViewModel(),navController)
//}
