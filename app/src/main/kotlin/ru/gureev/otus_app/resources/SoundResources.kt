package ru.gureev.otus_app.resources

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import ru.gureev.core.resources.ISoundResources

class SoundResources(private val context: Context) : ISoundResources {

    private val rawsIds = listOf<Int>()

    private var mediaPlayers: MutableMap<Int, MediaPlayer> = mutableMapOf()

    private fun start() {
        for (id in rawsIds) {
            mediaPlayers[id].let {
                if (it == null) {
                    mediaPlayers[id] = MediaPlayer.create(context, id)
                }
            }
        }
    }

    private fun stop() {
        mediaPlayers.forEach {
            it.value.release()
        }
        mediaPlayers.clear()
    }


    private fun play(rawId: Int) {
        var manualInit = false

        if (mediaPlayers.isEmpty()) {
            start()
            manualInit = true
        }

        mediaPlayers[rawId]?.let {
            val am = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

            val userVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC)

            am.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                0
            )

            it.setOnCompletionListener {
                am.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    userVolume,
                    0
                )
                if (manualInit) {
                    stop()
                }
            }

            it.start()
        }
    }

}
