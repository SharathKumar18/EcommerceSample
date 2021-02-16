package com.target.targetcasestudy.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by  on 12/02/21.
 */
class ViewModelFactory<T>(private val param: T) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return param as T
    }
}