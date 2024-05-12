package com.plum.flow.domain.repository

import com.plum.flow.domain.model.Fork

interface ForkRepository {
    suspend fun getFocusFork(): Fork?
    suspend fun getForkChildren(id:String):List<Fork>?
}