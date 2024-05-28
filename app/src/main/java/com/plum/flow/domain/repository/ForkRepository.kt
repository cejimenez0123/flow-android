package com.plum.flow.domain.repository

import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.model.ForkList

interface ForkRepository {
    suspend fun getFocusFork(): Fork?
    suspend fun getForkChildren(id:String):List<Fork>?
    suspend fun getProtectedForks(id:String):ForkList?


}