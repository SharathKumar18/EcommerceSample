package com.target.targetcasestudy

import android.app.Application

/**
 * Created by  on 13/02/21.
 */
class CaseStudyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        singleton = this
    }

    companion object{
        private var singleton: CaseStudyApp? = null
        fun getInstance(): CaseStudyApp? {
            return singleton
        }
    }
}