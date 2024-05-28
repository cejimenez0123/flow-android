package com.plum.flow.data.repository

import com.plum.flow.data.api.ForkApiService
import com.plum.flow.domain.model.Fork
import com.plum.flow.domain.model.ForkList
import com.plum.flow.domain.model.Style
import com.plum.flow.domain.repository.ForkRepository
import com.plum.flow.domain.repository.SharedPreferencesSource
import java.util.Date
import javax.inject.Inject

class ForkRepositoryImpl @Inject constructor(private val forkApi:ForkApiService,
    private val sharedPref: SharedPreferencesSource
):ForkRepository {
    override suspend fun getFocusFork(): Fork? {
       return forkApi.getFocusFork().body()


    }

    override suspend fun getForkChildren(id: String): ForkList? {
        var body = forkApi.getForkChildren(id).body()
        return body
    }

    override suspend fun getProtectedForks(id: String): ForkList? {
        val token = sharedPref.getToken()
        val res = token?.run {
            println(this)
            forkApi.getProtectedForks(id = id, token =this.bearer ) }
             if(res!=null && res.isSuccessful){
               return res.body()
            }else{
                println("protected"+res?.errorBody().toString())
                 println("protected"+res?.message())
              return  null
            }

    }


}