package com.example.xcriticalapp

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SharedPreferenceExample @Inject constructor(@ApplicationContext ctx:Context){
    val STORAGE_NAME = "StorageName"

    private var settings: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private var context: Context? = null

    init {
        context = ctx
    }

    private fun init() {
        settings = context?.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        editor = settings!!.edit()
    }

    fun addProperty(key: String?, value: String?) {
        if (settings == null) {
            init()
        }
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun getProperty(key: String?): String? {
        if (settings == null) {
            init()
        }
        return settings!!.getString(key, null)
    }
}