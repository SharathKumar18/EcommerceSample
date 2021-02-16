package com.target.targetcasestudy.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.data.UIItem
import com.target.targetcasestudy.data.dealslist.DealListResponse
import com.target.targetcasestudy.dataparser.DealsListParser
import com.target.targetcasestudy.util.Constants
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by  on 12/02/21.
 */
class DealsListViewModel(private val dataParser: DealsListParser) : BaseViewModel() {

    private val dealListMutableLiveData = MutableLiveData<DealListResponse>()
    val dealListLiveData: LiveData<DealListResponse> get() = dealListMutableLiveData

    fun loadDeals() {
        dataParser.getDealsFromServer().subscribe(object : Observer<DealListResponse> {
            override fun onComplete() {
                hideDefaultProgress()
            }

            override fun onSubscribe(d: Disposable) {
                showDefaultProgress()
                compositeDisposable.add(d)
            }

            override fun onNext(data: DealListResponse) {
                dealListMutableLiveData.value = data
            }

            override fun onError(e: Throwable) {
                hideDefaultProgress()
                dealListMutableLiveData.value = DealListResponse(null)
            }
        })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}