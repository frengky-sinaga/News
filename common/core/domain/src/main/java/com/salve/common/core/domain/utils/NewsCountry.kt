package com.salve.common.core.domain.utils

/***
 * Possible options of countries:
 * @Link https://newsapi.org/docs/endpoints/top-headlines
 * @CompareTo https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes
 */
enum class NewsCountry(val countryName: String, val countryCode: String) {
    GLOBAL("Global", ""),
    UNITED_ARAB_EMIRATES("United Arab Emirates", "ae"),
    ARGENTINA("Argentina", "ar"),
    AUSTRIA("Austria", "at"),
    AUSTRALIA("Australia", "au"),
    BELGIUM("Belgium", "be"),
    BULGARIA("Bulgaria", "bg"),
    BRAZIL("Brazil", "br"),
    CANADA("Canada", "ca"),
    SWITZERLAND("Switzerland", "ch"),
    CHINA("China", "cn"),
    COLOMBIA("Colombia", "co"),
    CUBA("Cuba", "cu"),
    CZECH_REPUBLIC("Czech Republic", "cz"),
    GERMANY("Germany", "de"),
    EGYPT("Egypt", "eg"),
    FRANCE("France", "fr"),
    UNITED_KINGDOM("United Kingdom", "gb"),
    GREECE("Greece", "gr"),
    HONG_KONG("Hong Kong", "hk"),
    HUNGARY("Hungary", "hu"),
    INDONESIA("Indonesia", "id"),
    IRELAND("Ireland", "ie"),
    ISRAEL("Israel", "il"),
    INDIA("India", "in"),
    ITALY("Italy", "it"),
    JAPAN("Japan", "jp"),
    SOUTH_KOREA("South Korea", "kr"),
    LITHUANIA("Lithuania", "lt"),
    LATVIA("Latvia", "lv"),
    MOROCCO("Morocco", "ma"),
    MEXICO("Mexico", "mx"),
    MALAYSIA("Malaysia", "my"),
    NIGERIA("Nigeria", "ng"),
    NETHERLANDS("Netherlands", "nl"),
    NORWAY("Norway", "no"),
    NEW_ZEALAND("New Zealand", "nz"),
    PHILIPPINES("Philippines", "ph"),
    POLAND("Poland", "pl"),
    PORTUGAL("Portugal", "pt"),
    ROMANIA("Romania", "ro"),
    SERBIA("Serbia", "rs"),
    RUSSIA("Russia", "ru"),
    SAUDI_ARABIA("Saudi Arabia", "sa"),
    SWEDEN("Sweden", "se"),
    SINGAPORE("Singapore", "sg"),
    SLOVENIA("Slovenia", "si"),
    SLOVAKIA("Slovakia", "sk"),
    THAILAND("Thailand", "th"),
    TURKEY("Turkey", "tr"),
    TAIWAN("Taiwan", "tw"),
    UKRAINE("Ukraine", "ua"),
    UNITED_STATES("United States of America", "us"),
    VENEZUELA("Venezuela", "ve"),
    SOUTH_AFRICA("South Africa", "za"),
}