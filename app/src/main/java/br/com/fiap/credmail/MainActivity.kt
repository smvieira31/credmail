package br.com.fiap.credmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.credmail.screens.CadastroScreen
import br.com.fiap.credmail.screens.CadastroViewModel
import br.com.fiap.credmail.screens.LoginScreen
import br.com.fiap.credmail.screens.MainScreen
import br.com.fiap.credmail.screens.MenuScreen
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
                        composable(route = "𝗹𝗼𝗴𝗶𝗻"){ LoginScreen(navController = 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿) }
                        composable(route = "home") { MainScreen() }
                        composable(route = "menu"){ MenuScreen() }
                        composable(route = "cadastro"){ CadastroScreen(CadastroViewModel()) }
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
