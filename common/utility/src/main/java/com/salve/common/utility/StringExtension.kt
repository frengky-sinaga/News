package com.salve.common.utility

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat

@Suppress("DEPRECATION")
fun String.byUsingHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Html.fromHtml(
        this,
        HtmlCompat.FROM_HTML_MODE_LEGACY
    )
    else Html.fromHtml(this)
}