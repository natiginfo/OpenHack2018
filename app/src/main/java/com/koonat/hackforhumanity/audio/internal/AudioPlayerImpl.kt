package com.koonat.hackforhumanity.audio.internal

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.media.MediaPlayer
import android.util.Log
import com.koonat.hackforhumanity.audio.AudioPlayer
import java.io.IOException

/**
 * Created by Natig on 3/10/18.
 */
class AudioPlayerImpl : AudioPlayer, LifecycleObserver {
    private var mediaPlayer: MediaPlayer? = MediaPlayer()


    override fun startPlaying(fileName: String) {
        try {
            mediaPlayer?.setDataSource(fileName)
            mediaPlayer?.prepare()
            mediaPlayer?.start()
        } catch (e: IOException) {
            Log.e(TAG, "prepare() failed")
        }

    }

    override fun stopPlaying() {
        mediaPlayer?.stop()
        mediaPlayer = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun release() {
        Log.d(TAG, "ON_STOP")
        mediaPlayer?.release()
        mediaPlayer = null
    }

    companion object {
        private val TAG = "AudioPlayerImpl"
    }
}