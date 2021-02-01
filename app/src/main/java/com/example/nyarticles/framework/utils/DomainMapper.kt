package com.example.nyarticles.framework.utils

import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.framework.datasource.remote.responses.Article

fun Article.toDomainModel() = ArticleDomainModel(
    title,
    if (media.isNotEmpty()) media[0].mediaMetadata.find { it.format == "mediumThreeByTwo210" }?.url else "",
    byline
)