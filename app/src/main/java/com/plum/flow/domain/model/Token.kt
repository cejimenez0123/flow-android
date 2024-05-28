package com.plum.flow.domain.model

data class Token(
    val token: String
){
    val bearer = "Bearer ${this.token}"
}