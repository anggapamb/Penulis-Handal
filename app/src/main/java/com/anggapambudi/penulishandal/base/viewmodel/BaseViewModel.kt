package com.anggapambudi.penulishandal.base.viewmodel

import androidx.lifecycle.viewModelScope
import com.crocodic.core.base.viewmodel.CoreViewModel
import kotlinx.coroutines.launch

open class BaseViewModel() : CoreViewModel() {

    override fun apiLogout() = viewModelScope.launch { }

    override fun apiRenewToken() = viewModelScope.launch { }

}