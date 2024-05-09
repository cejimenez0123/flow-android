package com.plum.flow.domain.model

data class Fork (
    val id:String,
    val name:String,
    val dueDate:Boolean?,
    val description:String?,
    val completed:Boolean?,
    val userId:String,
    val parentId:String,
    val style:HashMap<String,String>
)
