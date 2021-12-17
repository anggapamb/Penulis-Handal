package com.anggapambudi.penulishandal.base.activity

import androidx.databinding.ViewDataBinding
import com.anggapambudi.penulishandal.base.viewmodel.BaseViewModel
import com.crocodic.core.base.activity.CoreActivity
import com.crocodic.core.data.CoreSession
import com.google.gson.Gson
import javax.inject.Inject

open class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : CoreActivity<VB, VM>() {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var session: CoreSession

}