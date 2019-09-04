package com.codemobiles.myauthen.models

data class YoutubeResponse(
    val error: Boolean = false,
    val error_msg: String = "",
    val youtubes: List<Youtube> = listOf()
)

data class Youtube(
    val avatar_image: String = "",
    val id: String = "",
    val subtitle: String = "",
    val title: String = "",
    val youtube_image: String = ""
)
