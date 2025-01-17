package com.imashnake.animite.data.sauce.apis.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.imashnake.animite.MediaListQuery
import com.imashnake.animite.data.sauce.apis.MediaListApi
import com.imashnake.animite.type.MediaSeason
import com.imashnake.animite.type.MediaSort
import com.imashnake.animite.type.MediaType
import javax.inject.Inject

class ApolloMediaListApi @Inject constructor(
    private val apolloClient: ApolloClient
) : MediaListApi {
    override suspend fun fetchMediaList(
        type: MediaType,
        page: Int,
        perPage: Int,
        sort: List<MediaSort>,
        season: MediaSeason?,
        seasonYear: Int?
    ): MediaListQuery.Page? {
        return apolloClient
            .query(
                MediaListQuery(
                    type = Optional.presentIfNotNull(type),
                    page = Optional.presentIfNotNull(page),
                    perPage = Optional.presentIfNotNull(perPage),
                    sort = Optional.presentIfNotNull(sort),
                    season = Optional.presentIfNotNull(season),
                    seasonYear = Optional.presentIfNotNull(seasonYear)
                )
            ).execute().data?.page
    }
}
