package com.example.codetal

import android.app.Application
import android.media.MediaPlayer

class MyApplication : Application() {
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.achtbit)
        mediaPlayer.isLooping = true
    }
}
