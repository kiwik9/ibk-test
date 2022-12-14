package io.kiwik.ibkapp.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Any?.isNull() = this == null
fun Any?.isNotNull() = this != null