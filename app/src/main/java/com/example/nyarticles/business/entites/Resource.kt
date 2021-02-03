package com.example.nyarticles.business.entites

import com.example.nyarticles.framework.utils.ErrorTypes

/**
 * Represents a network bound resource. Each subclass represents the resource's   state:
 * - [Loading]: the resource is being retrieved from network.
 * - [Success]: the resource has been retrieved (available in [Success.data] field)
 * - [Failure]: the resource retrieving has failed (error available in [Failure.errorTypes]
 * field)
 */
sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure<out T>(val errorTypes: ErrorTypes) : Resource<T>()
}