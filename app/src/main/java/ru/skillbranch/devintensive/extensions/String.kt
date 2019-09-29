package ru.skillbranch.devintensive.extensions

fun String.truncate(limit: Int = 16): String {
    val ending = "..."
    val newString = this.filterIndexed { i, _ -> i < limit }.dropLastWhile { c -> c == ' ' }
    return if(this.length > limit ) newString + ending else newString
}

fun String.stripHtml(): String {
    return this.replace("<[^>]*>".toRegex(), "").replace(" +".toRegex(), " ")
}