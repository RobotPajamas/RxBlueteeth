package com.robotpajamas.android.rxblueteeth.extensions

fun String.prepend(message: String): String {
    return "$message$this"
}