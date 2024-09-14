package br.com.fiap.credmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.credmail.screens.CadastroScreen
import br.com.fiap.credmail.screens.CadastroViewModel
import br.com.fiap.credmail.screens.CategoriasScreen
import br.com.fiap.credmail.screens.ConfiguracoesScreen
import br.com.fiap.credmail.screens.ContatosScreen
import br.com.fiap.credmail.screens.EmailsScreen
import br.com.fiap.credmail.screens.EnviarScreen
import br.com.fiap.credmail.screens.ErroScreen
import br.com.fiap.credmail.screens.LoginScreen
import br.com.fiap.credmail.screens.LoginViewModel
import br.com.fiap.credmail.screens.MenuScreen
import br.com.fiap.credmail.screens.SpamsScreen
import br.com.fiap.credmail.screens.VisualizarScreen
import br.com.fiap.credmail.ui.theme.CredmailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CredmailTheme {
                //FOntes cores e tamanhos
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿 = rememberNavController()
                    NavHost(navController = 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,
                        startDestination = "𝗹𝗼𝗴𝗶𝗻"){
                        composable(route = "𝗹𝗼𝗴𝗶𝗻"){ LoginScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, LoginViewModel()) }
                        composable(route = "home/{id}",
                            arguments = listOf(
                                navArgument(name = "id"){
                                    type = NavType.LongType
                                }
                            )
                        ) {
                            val id = it.arguments?.getLong("id")
                            if (id != null) {
                                EmailsScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)
                            }
                        }
                        composable(route = "menu/{id}",arguments = listOf(
                            navArgument(name = "id"){
                                type = NavType.LongType
                            })){
                            val id = it.arguments?.getLong("id")
                            MenuScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)}
                        composable(route = "cadastro"){ CadastroScreen(CadastroViewModel(),𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿) }
                        composable(route = "contatos/{id}",
                            arguments = listOf(
                                navArgument(name = "id"){
                                    type = NavType.LongType
                                })){
                            val id = it.arguments?.getLong("id")
                            ContatosScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)}
                        composable(route = "enviar/{id}",
                            arguments = listOf(
                                navArgument(name = "id"){
                                    type = NavType.LongType
                                })){
                            val id = it.arguments?.getLong("id")
                            EnviarScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)}
                        composable(route = "ler/{idUsuario}/{idEmail}",
                            arguments = listOf(
                                navArgument(name = "idUsuario"){
                                    type = NavType.LongType
                                },navArgument(name = "idEmail"){
                                    type = NavType.LongType
                                })) {
                            val idUsuario = it.arguments?.getLong("idUsuario")
                            val idEmail = it.arguments?.getLong("idEmail")
                            VisualizarScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, idUsuario, idEmail)
                        }
                        composable(route = "configuracao/{id}",
                            arguments = listOf(
                                navArgument(name = "id"){
                                    type = NavType.LongType
                                })){
                            val id = it.arguments?.getLong("id")
                            ConfiguracoesScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)
                        }
                        composable(route = "spam/{id}",
                            arguments = listOf(
                                navArgument(name = "id"){
                                    type = NavType.LongType
                                })){
                            val id = it.arguments?.getLong("id")
                            SpamsScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)
                        }
                        composable(route = "categoria/{id}",
                            arguments = listOf(
                                navArgument(name = "id"){
                                    type = NavType.LongType
                                })){
                            val id = it.arguments?.getLong("id")
                            CategoriasScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)
                        }
                        composable(route = "erro"){ ErroScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿) }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginScreenPreview() {
//    //LoginScreen()
//    MainScreen()
//}
