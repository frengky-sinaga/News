package com.salve.common.utility

import java.text.SimpleDateFormat
import java.util.*

object DateFormatUtils {
    fun returnDateText(dateString: String): String {
        val locale = Locale.getDefault()
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", locale)
        return format.parse(dateString)?.toString() ?: dateString
    }
}