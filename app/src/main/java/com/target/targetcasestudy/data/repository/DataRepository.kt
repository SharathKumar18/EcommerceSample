package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.dealsdetail.DealDetailResponse
import com.target.targetcasestudy.data.dealslist.DealListResponse
import com.target.targetcasestudy.data.service.DealsDataService
import io.reactivex.Observable

/**
 * Created by  on 12/02/21.
 */

class DataRepository(private val dataService: DealsDataService) : DataRepositoryInterface {

    override fun getDealsFromServer(): Observable<DealListResponse> {
        return dataService.getDealsList()
    }

    override fun getDealDetailFromServer(id:Int): Observable<DealDetailResponse> {
        return dataService.getDealsDetail(id.toString())
    }
}