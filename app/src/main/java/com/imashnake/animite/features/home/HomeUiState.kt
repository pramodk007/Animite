package com.imashnake.animite.features.home

import com.imashnake.animite.MediaListQuery
import com.imashnake.animite.MediaQuery

data class HomeUiState(
    val trendingMediaList: MediaListQuery.Page? = null,
    val popularMediaThisSeasonList: MediaListQuery.Page? = null
)
