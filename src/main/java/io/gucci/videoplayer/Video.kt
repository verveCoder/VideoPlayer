package io.gucci.videoplayer

import android.net.Uri

data class Video(
    val title: String,
    val size: String,
    val uri: Uri
)
