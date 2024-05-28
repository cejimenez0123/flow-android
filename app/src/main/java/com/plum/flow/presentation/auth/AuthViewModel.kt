package com.plum.flow.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.model.TokenResponse
import com.plum.flow.domain.repository.SharedPreferencesSource
import com.plum.flow.usecase.CheckTokenUseCase
import com.plum.flow.usecase.LoginUseCase
import com.plum.flow.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel  @Inject constructor(
    private val logInUseCase:LoginUseCase,
    private val checkTokenUseCase: CheckTokenUseCase,
    private val sharedPref: SharedPreferencesSource ):  ViewModel(
) {
    val token = MutableStateFlow<Token?>(null)
    init {
        checkToken()
    }
    fun checkToken(){
        token.value = sharedPref.getToken()
        viewModelScope.launch(Dispatchers.IO) {
            val res = checkTokenUseCase.invoke(null)
            when(res) {
                is Resource.Error -> {

                    sharedPref.clearToken()
                }
                is Resource.Initial -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    res.data?.let{
                        println(it)
                        if(!it.isActive){
                            sharedPref.clearToken()
                        }else{
                            token.value = sharedPref.getToken()
                        }
                    }
                }
            }
        }
    }

    fun login(email:String,password:String,onComplete:(bool:Boolean)->Unit){
       viewModelScope.launch(Dispatchers.IO) {
           val params = LogInRequest(email, password)
           val res = logInUseCase.invoke(params)
           when (res) {
               is Resource.Error -> {

                   onComplete(false)
               }

               is Resource.Initial -> {

               }

               is Resource.Loading -> {

               }

               is Resource.Success -> {

                   res.data?.let { sharedPref.setToken(it) }
                   onComplete(true)
               }
           }
       }
    }
}