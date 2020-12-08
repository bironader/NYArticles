package com.example.nyarticles.business.entites

data class ApiResponseWraper<T>(var result: Result<T>?, var throwable: Throwable?)