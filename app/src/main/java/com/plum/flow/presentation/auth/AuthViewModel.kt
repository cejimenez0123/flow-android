package com.plum.flow.presentation.auth

import androidx.lifecycle.ViewModel
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.usecase.LoginUseCase
import com.plum.flow.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class AuthViewModel  @Inject constructor(private val logInUseCase:LoginUseCase ):  ViewModel(
) {

    suspend fun login(email:String,password:String){
        val params =LogInRequest(email,password)
        val res= logInUseCase.invoke(params,Dispatchers.IO)
        when(res){
            is Resource.Error -> {
                println(res.message)
            }
            is Resource.Initial -> {

            }
            is Resource.Loading -> {

            }
            is Resource.Success -> {
                println("TOKEN"+res.data)
            }
        }

    }
}