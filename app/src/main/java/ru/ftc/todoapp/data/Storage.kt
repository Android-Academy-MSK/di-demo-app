package ru.ftc.todoapp.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

interface Storage {

    operator fun set(key: String, value: String?)

    operator fun get(key: String): String?
}

class StorageImpl(
    context: Context
) : Storage {

    private companion object {

        const val SP_NAME = "TASKS_SP"
    }

    private val sp = context.getSharedPreferences(SP_NAME, MODE_PRIVATE)

    override fun set(key: String, value: String?) {
        sp.edit().putString(key, value).apply()
    }

    override fun get(key: String): String? =
        sp.getString(key, null)
}