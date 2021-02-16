package com.target.targetcasestudy.dataparser

import com.target.targetcasestudy.data.repository.DataRepository
import com.target.targetcasestudy.data.dealslist.DealListResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler

/**
 * Created by  on 12/02/21.
 */
class DealsListParser(
    private val repository: DataRepository,
    private val ioScheduler: Scheduler,
    private val mainScheduler: Scheduler
) : DealsListParserInterface {

    override fun getDealsFromServer(): Observable<DealListResponse> {
       return repository.getDealsFromServer()
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
    }
}