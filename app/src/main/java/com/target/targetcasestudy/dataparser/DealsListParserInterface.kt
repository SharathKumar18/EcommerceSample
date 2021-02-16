package com.target.targetcasestudy.dataparser

import com.target.targetcasestudy.data.dealslist.DealListResponse
import io.reactivex.Observable
import io.reactivex.Observer

/**
 * Created by  on 12/02/21.
 */
interface DealsListParserInterface {

    fun getDealsFromServer(): Observable<DealListResponse>
}