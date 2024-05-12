package com.plum.flow.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LogInScreen( viewModel: AuthViewModel = hiltViewModel(),navigateToTree:()->Unit) {
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        var email by rememberSaveable {
            mutableStateOf("")
        }
        var hasError by remember {
            mutableStateOf(false)
        }
        var password by rememberSaveable {
            mutableStateOf("")
        }
        var cor = rememberCoroutineScope()
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.weight(1F))
        TextField(value = email, onValueChange ={text->
            email = text
        }, modifier = Modifier.fillMaxWidth() )
        TextField(value = password, onValueChange ={
            text->
            password=text
        },modifier = Modifier.fillMaxWidth(), visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility  else Icons.Filled.VisibilityOff
                val contentDescription = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = contentDescription)
                }
            } )
        if(hasError){
            Text("Wrong password or e-mail")
        }
        Button(onClick = {

            viewModel.login(email, password, onComplete = {
                if (it) {
                    cor.launch(Dispatchers.Main) {
                        hasError = false
                        navigateToTree()
                    }

                } else {
                    hasError = true
                }
            })

        }) {
            Text("Log In")
        }
        Spacer(modifier = Modifier.weight(1F))

    }
}