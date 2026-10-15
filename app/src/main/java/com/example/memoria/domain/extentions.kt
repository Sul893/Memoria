package com.example.memoria.domain

import android.content.res.Resources

fun Int.dp(): Int = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
