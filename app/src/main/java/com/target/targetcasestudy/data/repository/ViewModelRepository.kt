package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.dataparser.DealsDetailParser
import com.target.targetcasestudy.dataparser.DealsListParser
import com.target.targetcasestudy.viewmodel.DealsDetailViewModel
import com.target.targetcasestudy.viewmodel.DealsListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by  on 12/02/21.
 */
object ViewModelRepository {

    fun provideDealsListViewModel(): DealsListViewModel {

        val repository = RepositoryProvider.provideDataRepository()
        val ioScheduler = Schedulers.io()
        val mainScheduler = AndroidSchedulers.mainThread()
        val dealsListParser = DealsListParser(repository, ioScheduler, mainScheduler)
        return DealsListViewModel(dealsListParser)
    }

    fun provideDealsDetailViewModel(): DealsDetailViewModel {

        val repository = RepositoryProvider.provideDataRepository()
        val ioScheduler = Schedulers.io()
        val mainScheduler = AndroidSchedulers.mainThread()
        val dealsDetailParser = DealsDetailParser(repository, ioScheduler, mainScheduler)
        return DealsDetailViewModel(dealsDetailParser)
    }

}