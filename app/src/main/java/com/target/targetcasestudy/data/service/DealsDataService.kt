package com.target.targetcasestudy.data.service

import com.target.targetcasestudy.data.dealsdetail.DealDetailResponse
import com.target.targetcasestudy.data.dealslist.DealListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by  on 12/02/21.
 */
interface DealsDataService {

    @GET("deals")
    fun getDealsList(): Observable<DealListResponse>

    @GET("deals/{id}")
    fun getDealsDetail(@Path("id") itemId: String): Observable<DealDetailResponse>

}