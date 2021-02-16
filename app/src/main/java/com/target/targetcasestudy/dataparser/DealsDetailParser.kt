package com.target.targetcasestudy.dataparser

import com.target.targetcasestudy.data.repository.DataRepository
import com.target.targetcasestudy.data.dealsdetail.DealDetailResponse
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * Created by  on 12/02/21.
 */
class DealsDetailParser(private val repository: DataRepository,
                        private val ioScheduler: Scheduler,
                        private val mainScheduler: Scheduler) : DealsDetailInterface {

    override fun getDealsDetailFromServer(id: Int): Observable<DealDetailResponse> {
        return repository.getDealDetailFromServer(id)
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
    }
}