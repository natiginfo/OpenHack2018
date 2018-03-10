package com.koonat.hackforhumanity.audio.internal

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.media.MediaRecorder
import android.util.Log
import com.koonat.hackforhumanity.audio.AudioRecorder
import java.io.IOException
import java.util.*

/**
 * Created by Natig on 3/10/18.
 */
class AudioRecorderImpl public constructor(appContext: Context) : AudioRecorder, LifecycleObserver {

    private var mediaRecorder: MediaRecorder? = MediaRecorder()
    lateinit var fileName: String
    private var cacheDirPath: String = appContext.cacheDir.absolutePath

    override fun startRecording(): String {
        Log.d(TAG, "Start recording")
        mediaRecorder.let {
            fileName = cacheDirPath + "/" + UUID.randomUUID().toString()
            it?.setAudioSource(MediaRecorder.AudioSource.MIC)
            it?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            it?.setOutputFile(fileName)
            it?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                it?.prepare()
            } catch (e: IOException) {
                Log.e(TAG, "prepare() failed")
            }

            it?.start()

        }

        return fileName
    }

    override fun stopRecording() {
        Log.d(TAG, "Stop recording")
        mediaRecorder?.stop()
        mediaRecorder?.release()
        mediaRecorder = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun release() {
        Log.d(TAG, "ON_STOP")
        mediaRecorder?.release()
        mediaRecorder = null
    }

    companion object {
        private val TAG = "AudioRecorderImpl"
    }

}