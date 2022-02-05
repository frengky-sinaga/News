package com.salve.common.core.data.cache.data_source

import androidx.sqlite.db.SimpleSQLiteQuery

object NewsDataSourceUtils {
    fun queryLatest() = SimpleSQLiteQuery(
        StringBuilder().append("SELECT * FROM articles_table ORDER BY publishedAt DESC").toString()
    )
}