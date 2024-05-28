package com.plum.flow.domain.model

import java.util.Date

data class Fork(
    val completed: Boolean,
    val description: String,
    val dueDate: Date,
    val id: String,
    val link: String,
    val name: String,
    val parentId: String,
    val style: Style,
    val userId: String?
)

