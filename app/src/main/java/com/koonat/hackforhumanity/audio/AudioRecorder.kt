package com.koonat.hackforhumanity.audio

/**
 * Created by Natig on 3/10/18.
 */
interface AudioRecorder {
    fun startRecording(): String

    fun stopRecording()
}