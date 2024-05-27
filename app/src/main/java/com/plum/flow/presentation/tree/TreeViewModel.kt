package com.plum.flow.presentation.tree

import androidx.lifecycle.ViewModel
import com.plum.flow.domain.model.Fork
import com.plum.flow.usecase.ChildrenForkUseCase
import com.plum.flow.usecase.ChildrenForkUseCase_Factory
import com.plum.flow.usecase.FocusForkUseCase
import com.plum.flow.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
@HiltViewModel
class TreeViewModel @Inject constructor(private val focusForkUseCase:FocusForkUseCase,private val childrenForkUseCase: ChildrenForkUseCase):ViewModel(){
    suspend fun getFocusFork(complete:(Resource<Fork?>)->Unit){
       val response = focusForkUseCase(null)
        println(response)
        complete(response)

    }
    suspend fun getForkChildren(id:String,complete:(Resource<List<Fork>?>)->Unit){
        val response = childrenForkUseCase(id)
        complete(response)
    }
    suspend fun getProtectForkChildren(){

    }

}