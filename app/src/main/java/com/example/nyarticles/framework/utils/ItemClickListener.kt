package com.example.nyarticles.framework.utils

import android.view.View
import com.bumptech.glide.request.transition.ViewTransition

interface ItemClickListener<T> {

    fun itemClick(item: T)
}