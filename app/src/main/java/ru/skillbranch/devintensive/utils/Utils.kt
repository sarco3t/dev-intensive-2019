package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val parts = fullName?.split(" ")
        val firstName = parts?.getOrNull(0).orEmpty().trim().ifEmpty { null }
        val lastName = parts?.getOrNull(1).orEmpty().trim().ifEmpty { null }

        return firstName to lastName
    }

    fun transliteration(payload: String, devider: String = " "): String {
        var result = ""
        payload.forEach { c ->
            val tChar = getTransliterationChar(c.toString().toLowerCase())
            if (tChar == null) {
                result += c
                return@forEach
            }
            result += if (c.isUpperCase()) {
                tChar.toUpperCase()
            } else {
                tChar
            }
        }
        return result.replace(" ", devider)
    }

    private fun getTransliterationChar(c:String): String? {
        return when(c) {
            "а" -> "a"
            "б" -> "b"

            "в" -> "v"

            "г" -> "g"

            "д" -> "d"

            "е" -> "e"

            "ё" -> "e"

            "ж" -> "zh"

            "з" -> "z"

            "и" -> "i"

            "й" -> "i"

            "к" -> "k"

            "л" -> "l"

            "м" -> "m"

            "н" -> "n"

            "о" -> "o"

            "п" -> "p"

            "р" -> "r"

            "с" -> "s"

            "т" -> "t"

            "у" -> "u"

            "ф" -> "f"

            "х" -> "h"

            "ц" -> "c"

            "ч" -> "ch"

            "ш" -> "sh"

            "щ" -> "sh'"

            "ъ" -> ""

            "ы" -> "i"

            "ь" -> ""

            "э" -> "e"

            "ю" -> "yu"

            "я" -> "ya"
            else -> null
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstLetter = firstName?.replace(" ", "")?.getOrNull(0)?.toUpperCase()
        val lastLetter = lastName?.replace(" ", "")?.getOrNull(0)?.toUpperCase()
        if (firstLetter == null && lastLetter == null) {
            return null
        }
        return "${firstLetter ?: ""}${lastLetter ?: ""}"
    }
}