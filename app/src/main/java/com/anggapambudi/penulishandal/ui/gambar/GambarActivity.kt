package com.anggapambudi.penulishandal.ui.gambar

import android.app.DownloadManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.RequiresApi
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.anggapambudi.penulishandal.Constans.Const
import com.anggapambudi.penulishandal.R
import com.anggapambudi.penulishandal.base.activity.BaseActivity
import com.anggapambudi.penulishandal.databinding.ActivityGambarBinding
import com.bumptech.glide.Glide
import com.crocodic.core.extension.tos
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GambarActivity : BaseActivity<ActivityGambarBinding, GambarViewModel>() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_gambar)

        setImage()

    }

    private fun setImage() {

        val getText = intent.getStringExtra(Const.SEND.TULIS)
        val url = "https://hadi-api.herokuapp.com/api/canvas/nulis?text=$getText"

        tos("Sabar ya bang !!")

        Handler(Looper.getMainLooper()).postDelayed({

            //add loading
            val circularProgressDrawable = CircularProgressDrawable(this)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            //set image
            Glide.with(this).load(url).placeholder(circularProgressDrawable).into(binding.imgNulis)

        }, 1000)

    }

    private fun downloadImage() {

        val getText = intent.getStringExtra(Const.SEND.TULIS)
        val url = "https://hadi-api.herokuapp.com/api/canvas/nulis?text=$getText"

        val request = DownloadManager.Request(Uri.parse(url))
            .setTitle("penulis_handal.jpg")
            .setDescription("Donwloading...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setAllowedOverMetered(true)

        tos("Downloading..")
        val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(request)
    }

    override fun onClick(v: View?) {
        super.onClick(v)

        when (v) {
            binding.btnDownload -> {
                downloadImage()
            }
        }

    }

}