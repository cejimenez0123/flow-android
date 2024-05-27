package com.plum.flow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plum.flow.presentation.auth.LogInScreen
import com.plum.flow.presentation.tree.TreeScreen
import com.plum.flow.ui.theme.FlowandroidTheme
import com.plum.flow.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            FlowandroidTheme {
                val navController = rememberNavController()


                NavHost(navController = navController, startDestination = Screen.Login.route) {
                    composable(route = Screen.Login.route) {
                        LogInScreen(navigateToTree = {
                            navController.navigate(Screen.Tree.route)
                        })
                    }
                    composable(route=Screen.Tree.route){
                        TreeScreen()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlowandroidTheme {
        Greeting("Android")
    }
}