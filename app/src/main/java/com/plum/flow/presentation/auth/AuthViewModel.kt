package com.plum.flow.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plum.flow.domain.model.LogInRequest
import com.plum.flow.domain.repository.SharedPreferencesSource
import com.plum.flow.usecase.LoginUseCase
import com.plum.flow.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel  @Inject constructor(private val logInUseCase:LoginUseCase,private val sharedPref: SharedPreferencesSource ):  ViewModel(
) {

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