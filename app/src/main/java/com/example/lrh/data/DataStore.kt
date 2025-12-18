package com.example.lrh.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

object DataStoreHelper {

    private val Context.dataStore by preferencesDataStore(name = "app_prefs")

    private val FIRST_LAUNCH_KEY = booleanPreferencesKey("first_launch")

    suspend fun isFirstLaunch(context: Context): Boolean {
        val prefs = context.dataStore.data.first()
        return prefs[FIRST_LAUNCH_KEY] ?: true
    }

    suspend fun setFirstLaunch(context: Context, value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[FIRST_LAUNCH_KEY] = value
        }
    }
}

