package com.salve.common.core.domain.utils

/***
 * Possible options of categories:
 * @Link https://newsapi.org/docs/endpoints/top-headlines
 */
enum class NewsCategory(val categoryName: String, val translatedToIndonesia: String) {
    GENERAL("general", "umum"),
    BUSINESS("business", "bisnis"),
    ENTERTAINMENT("entertainment", "hiburan"),
    HEALTH("health", "kesehatan"),
    SCIENCE("science", "sains"),
    SPORTS("sports", "olahraga"),
    TECHNOLOGY("technology", "teknologi")
}