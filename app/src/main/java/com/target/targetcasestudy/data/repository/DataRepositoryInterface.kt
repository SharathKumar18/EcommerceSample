package com.target.targetcasestudy.data.repository

import io.reactivex.Observable
import com.target.targetcasestudy.data.dealsdetail.DealDetailResponse
import com.target.targetcasestudy.data.dealslist.DealListResponse

/**
 * Created by  on 12/02/21.
 */

interface DataRepositoryInterface {

    fun getDealsFromServer(): Observable<DealListResponse>

    fun getDealDetailFromServer(id:Int): Observable<DealDetailResponse>
}