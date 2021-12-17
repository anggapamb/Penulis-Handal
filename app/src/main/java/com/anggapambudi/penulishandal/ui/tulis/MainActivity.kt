package com.anggapambudi.penulishandal.ui.tulis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anggapambudi.penulishandal.Constans.Const
import com.anggapambudi.penulishandal.R
import com.anggapambudi.penulishandal.base.activity.BaseActivity
import com.anggapambudi.penulishandal.databinding.ActivityMainBinding
import com.anggapambudi.penulishandal.ui.gambar.GambarActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_main)

        //code

    }

    private fun sendData() {

        if (binding.edtNulis.text.toString().trim().isEmpty()) {
            binding.edtNulis.error = "Field ini tidak boleh kosong"
        } else {
            val teks = binding.edtNulis.text.toString().trim()
            val move = Intent(this, GambarActivity::class.java)
                .putExtra(Const.SEND.TULIS, teks)
            startActivity(move)
        }

    }

    override fun onClick(v: View?) {
        super.onClick(v)

        when (v) {
            binding.btnConvert -> {
                sendData()
            }
        }

    }
}