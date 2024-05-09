package com.plum.flow.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

sealed class Resource<T>(data: T?, message: String? = null) {
    @Parcelize
    data class Initial<T>(val data:@RawValue T?=null, val message: String ="Initial"):Resource<T>(data = null, message = "Initial"),
        Parcelable
    @Parcelize
    data class Success<T>(val data:@RawValue T):Resource<T>(data), Parcelable
    @Parcelize
    data class Loading<T>(val data:@RawValue T?=null, val message: String?="Loading"): Resource<T>(null,"Loading"),
        Parcelable
    @Parcelize
    data class Error<T>(val message: String?) : Resource<T>(data = null,message), Parcelable

}