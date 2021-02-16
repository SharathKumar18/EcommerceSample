package com.target.targetcasestudy.dataparser

import com.target.targetcasestudy.data.dealsdetail.DealDetailResponse
import com.target.targetcasestudy.data.dealslist.DealListResponse
import io.reactivex.Observable

/**
 * Created by  on 12/02/21.
 */
interface DealsDetailInterface {

    fun getDealsDetailFromServer(id:Int): Observable<DealDetailResponse>
}