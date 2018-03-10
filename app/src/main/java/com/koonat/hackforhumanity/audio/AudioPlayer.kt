package com.koonat.hackforhumanity.audio

/**
 * Created by Natig on 3/10/18.
 */

interface AudioPlayer {
    fun startPlaying(fileName: String)

    fun stopPlaying()
}
