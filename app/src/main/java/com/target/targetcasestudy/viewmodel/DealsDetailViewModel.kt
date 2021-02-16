package com.target.targetcasestudy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.data.UIItem
import com.target.targetcasestudy.data.dealsdetail.DealDetailResponse
import com.target.targetcasestudy.data.dealslist.DealListResponse
import com.target.targetcasestudy.dataparser.DealsDetailParser
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by  on 12/02/21.
 */
class DealsDetailViewModel(private val dataParser: DealsDetailParser) : BaseViewModel(){

    private val detailMutableLiveData = MutableLiveData<DealDetailResponse>()
    val detailLiveData: LiveData<DealDetailResponse> get() = detailMutableLiveData

    fun loadDetails(id: Int) {
            dataParser.getDealsDetailFromServer(id).subscribe(object : Observer<DealDetailResponse> {
                override fun onComplete() {
                    hideDefaultProgress()
                }

                override fun onSubscribe(d: Disposable) {
                    showDefaultProgress()
                    compositeDisposable.add(d)
                }

                override fun onNext(data: DealDetailResponse) {
                    detailMutableLiveData.value = data
                }

                override fun onError(e: Throwable) {
                    hideDefaultProgress()
                    detailMutableLiveData.value = DealDetailResponse(null)
                }
            })
    }
}