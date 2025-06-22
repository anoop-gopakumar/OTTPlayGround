package com.example.myapplication.ui.player

import android.os.Bundle
import android.util.Log
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaItem.DrmConfiguration
import androidx.media3.common.MimeTypes
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityCustomPlayerBinding
import com.example.myapplication.ui.BaseActivity

class MyCustomPlayerActivity : BaseActivity<ActivityCustomPlayerBinding>() {

    var player: Player? = null

    private var playWhenReady = true
    private var mediaItemIndex = 0
    private var playbackPosition = 0L

    private var playerState = ""

    override fun getViewBinding(): ActivityCustomPlayerBinding {
        return ActivityCustomPlayerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player = binding?.videoView?.player
        initPlayer()
    }

    private fun initPlayer() {
        player = ExoPlayer.Builder(this).build().also { exoPlayer ->

            binding?.videoView?.player = exoPlayer
            // Track selection can be used to switch different resolutions.
            exoPlayer.trackSelectionParameters =
                exoPlayer.trackSelectionParameters.buildUpon().setMaxVideoSizeSd().build()


            val mediaItem =
                MediaItem.Builder().setUri(resources.getString(R.string.media_url_dash))
                    .setDrmConfiguration(
                        DrmConfiguration.Builder(C.WIDEVINE_UUID).setLicenseUri("https://your.license.server/license")
                            .setLicenseRequestHeaders(mapOf("Auth" to "xsfdsf")).build()
                    )
                    .setMimeType(MimeTypes.APPLICATION_MPD).build()

            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.playWhenReady = playWhenReady
            exoPlayer.addListener(getPlayerListener())
            exoPlayer.prepare()

        }
    }


    private fun getPlayerListener(): Player.Listener {
        val listener = object : Player.Listener {
            override fun onPlayerError(error: PlaybackException) {


                Log.d(
                    "TAG", "onPlayerError errorCode: ${error.errorCode}" +
                            "Error Code name : ${error.errorCodeName} " +
                            "Error message : ${error.message}"
                )
            }

            override fun onPlaybackStateChanged(playbackState: Int) {
                when (playbackState) {
                    ExoPlayer.STATE_IDLE -> playerState = "Idle"
                    ExoPlayer.STATE_BUFFERING -> playerState = "Buffering"
                    ExoPlayer.STATE_READY -> playerState = "Ready"
                    ExoPlayer.STATE_ENDED -> playerState = "Ended"
                }
            }
        }
        return listener
    }


}