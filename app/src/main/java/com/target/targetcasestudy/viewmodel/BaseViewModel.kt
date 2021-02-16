package com.target.targetcasestudy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.data.UIItem
import com.target.targetcasestudy.util.Constants
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by  on 14/02/21.
 */
open class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    private val defaultUiMutableLiveData = MutableLiveData<UIItem>()
    val defaultUiLiveData: LiveData<UIItem> get() = defaultUiMutableLiveData

    protected fun showDefaultProgress() {
        val helper = UIItem(Constants.SHOW_PROGRESS, null)
        defaultUiMutableLiveData.value = helper
    }

    protected fun hideDefaultProgress() {
        val helper = UIItem(Constants.HIDE_PROGRESS, null)
        defaultUiMutableLiveData.value = helper
    }
}