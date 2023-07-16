package com.fitra.testsuitmedia.data

import android.content.Context
import android.content.SharedPreferences

class Preference(context: Context) {
    companion object {
        private const val PREFERENCE_NAME = "UserPreference"
        private const val KEY_USERNAME = "username"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    var username: String?
        get() = sharedPreferences.getString(KEY_USERNAME, null)
        set(value) = sharedPreferences.edit().putString(KEY_USERNAME, value).apply()
}