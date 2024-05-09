package com.plum.flow.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun LogInScreen( viewModel: AuthViewModel = hiltViewModel()) {
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var cor = rememberCoroutineScope()
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.weight(1F))
        TextField(value = email, onValueChange ={text->
            email = text
        } )
        TextField(value = password, onValueChange ={
            text->
            password=text
        } )
        Button(onClick = {
            cor.launch {
                viewModel.login(email, password)
            }
        }) {
            Text("Log In")
        }
        Spacer(modifier = Modifier.weight(1F))

    }
}