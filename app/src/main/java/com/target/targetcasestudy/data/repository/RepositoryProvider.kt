package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.service.ApiService
import com.target.targetcasestudy.data.service.DealsDataService

/**
 * Created by  on 12/02/21.
 */
object RepositoryProvider {

    fun provideDataRepository(): DataRepository {
        val retrofit = ApiService.getDealsDataService()
        val dataService = retrofit.create(DealsDataService::class.java)
        return DataRepository(dataService)
    }
}