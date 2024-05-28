package com.plum.flow.domain.model

data class TokenResponse(val name:String,val message:String){
    val isActive = this.name=="TokenSuccess"

}
