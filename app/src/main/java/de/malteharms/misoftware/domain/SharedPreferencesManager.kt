package de.malteharms.misoftware.domain

import android.content.SharedPreferences

class SharedPreferencesManager private constructor(sharedPreferences: SharedPreferences) {

    private var sp: SharedPreferences = sharedPreferences

    companion object {
        private var instance: SharedPreferencesManager? = null

        fun getInstance(sharedPreferences: SharedPreferences): SharedPreferencesManager {
            if (instance == null) {
                instance = SharedPreferencesManager(sharedPreferences)
            }
            return instance!!
        }
    }

    fun write(key: String, value: String) {
        val editor: SharedPreferences.Editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun read(key: String): String? {
        val value: String? = sp.getString(key, "")

        if (value == "" || value == null) {
            return null
        }

        return value
    }

    fun contains(key: String): Boolean {
        return sp.contains(key)
    }

    fun delete(key: String): Boolean {
        val editor: SharedPreferences.Editor = sp.edit()
        editor.remove(key)
        editor.apply()

        if (sp.contains(key)) {
            return false
        }
        return true
    }

    fun getAll(): Map<String, *> {
        return sp.all
    }

}