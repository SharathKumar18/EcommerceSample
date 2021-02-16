package com.target.targetcasestudy.data.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by  on 12/02/21.
 */

object ApiService {

    fun getDealsDataService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.target.com/mobile_case_study_deals/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}