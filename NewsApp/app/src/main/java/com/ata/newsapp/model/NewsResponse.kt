package com.ata.newsapp.model

data class NewsResponse(
    val articles: MutableList<Article>,
    val totalResults: Int,
    val status: String,

)