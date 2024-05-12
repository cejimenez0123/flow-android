package com.plum.flow.data.repository

import android.content.Context
import com.plum.flow.domain.model.Token
import com.plum.flow.domain.repository.SharedPreferencesSource
import dagger.hilt.android.qualifiers.ApplicationContext

private  object PreferenceKeys{
    val token = "token"}
class SharedPreferencesSourceImpl(@ApplicationContext val context: Context):
    SharedPreferencesSource {

    override fun setToken(token: Token){
        val tokenPref = context.getSharedPreferences(PreferenceKeys.token, Context.MODE_PRIVATE)
        val editor = tokenPref.edit()
        editor.putString(PreferenceKeys.token,token.token)
        editor.apply()
    }
    override fun getToken():Token? {
        val tokenPref = context.getSharedPreferences(PreferenceKeys.token, Context.MODE_PRIVATE)
        val tokenStr= tokenPref.getString(PreferenceKeys.token, "")
        return tokenStr?.run{ Token(token=tokenStr)}
    }

    override fun clearToken() {
        val tokenPref = context.getSharedPreferences(PreferenceKeys.token, Context.MODE_PRIVATE)
        tokenPref.edit().run {
            remove(PreferenceKeys.token)

            apply()
        }
    }
}