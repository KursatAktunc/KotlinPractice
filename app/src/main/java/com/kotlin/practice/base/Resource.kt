/*
 * Copyright (C) 2021 Berk Berber
 */
package com.kotlin.practice.base

/**
 * @author Berk Berber
 * @date 2.10.2021
 */
data class Resource<T>(
    var status: ResourceStatus,
    var data: T? = null,
    var error: ResourceError? = null
) {
    companion object {
        fun <T> onSuccess(data: T?): Resource<T> {
            data?.let { response ->
                return Resource(status = ResourceStatus.SUCCESS, data = response)
            } ?: kotlin.run {
                return Resource(
                    status = ResourceStatus.ERROR,
                    error = ResourceError(-1, "There is not any data in response")
                )
            }
        }

        fun <T> onProgress(): Resource<T> {
            return Resource(status = ResourceStatus.PROGRESS)
        }

        fun <T> onError(error: ResourceError): Resource<T> {
            return Resource(status = ResourceStatus.ERROR, error = error)
        }
    }
}

enum class ResourceStatus { SUCCESS, ERROR, PROGRESS }

data class ResourceError(
    val errorCode: Int,
    val errorMessage: String
)