package br.com.fiap.credmail.componentes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.credmail.screens.ContatosScreen
import br.com.fiap.credmail.screens.EmailsScreen
import br.com.fiap.credmail.screens.EnviarScreen


@Composable
fun BottomNavGraph(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long?){
    NavHost(navController = 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿 as NavHostController, startDestination = BottomBarScreen.Emails.route){
        composable(route = BottomBarScreen.Emails.route){
            if (id != null) {
                EmailsScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id)
            }
        }
        composable(route = BottomBarScreen.Contatos.route){
            ContatosScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id)
        }
        composable(route = BottomBarScreen.Enviar.route){
            EnviarScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id)
        }
    }
}

