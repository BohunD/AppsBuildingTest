package com.bohunapps.appsbuildingtest.repository

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.bohunapps.appsbuildingtest.util.Constants

class SharedPrefsRepo(private val context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)


    fun saveName(name: String){
        prefs.edit().putString(Constants.NAME_KEY, name).apply()
        Log.e("SAVE_TO_PREFS", name)
    }

    fun saveAge(age: String){
        prefs.edit().putString(Constants.AGE_KEY, age).apply()
    }

    fun getName(): String? {
        Log.e("FROM_PREFS", prefs.getString("name", null).toString())
        return prefs.getString("name", null)
    }

    fun getAge(): String? {
        return prefs.getString("age", null)
    }
}