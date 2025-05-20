package com.example.myapplication.ui.player

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.analytics.AnalyticsListener
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPlayerBinding
import com.example.myapplication.ui.BaseActivity

class PlayerActivity : BaseActivity<ActivityPlayerBinding>() {

    private var player: Player? = null

    private var playWhenReady = true
    private var mediaItemIndex = 0
    private var playbackPosition = 0L

    private var playbackStateLister: Player.Listener = playbackStateListener()

    override fun getViewBinding(): ActivityPlayerBinding {
        return ActivityPlayerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(binding?.root)
        player = binding?.videoView?.player
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build().also { exoPlayer ->
            binding?.videoView?.player = exoPlayer
            exoPlayer.trackSelectionParameters =
                exoPlayer.trackSelectionParameters.buildUpon().setMaxVideoSizeSd().build()

            val mediaItem = MediaItem.Builder().setUri(resources.getString(R.string.media_url_dash))
                .setMimeType(MimeTypes.APPLICATION_MPD).build()

            exoPlayer.setMediaItems(listOf(mediaItem), mediaItemIndex, playbackPosition)
            exoPlayer.playWhenReady = playWhenReady
            exoPlayer.addListener(playbackStateLister)
            exoPlayer.prepare()
        }
    }

    private fun playbackStateListener(): Player.Listener {
        val listener = object : Player.Listener {

            override fun onPlayerError(error: PlaybackException) {
                Log.d("TAG", "onPlayerError ${error}")
                Toast.makeText(this@PlayerActivity,"${error}",Toast.LENGTH_LONG).show()
            }

            override fun onEvents(player: Player, events: Player.Events) {
                Log.d("TAG", "onPlayerError $events")
            }

            override fun onPlaybackStateChanged(playbackState: Int) {
                val stateString: String = when (playbackState) {
                    ExoPlayer.STATE_IDLE -> "IDLEe"
                    ExoPlayer.STATE_BUFFERING -> "Buffering"
                    ExoPlayer.STATE_READY -> "Ready"
                    ExoPlayer.STATE_ENDED -> "Ended"
                    else -> "Unknown"
                }
                Log.d("TAG", "changed state to $stateString")
            }
        }
        return listener
    }

    @OptIn(UnstableApi::class) private fun analyticsListener(){

        val listener = object :  AnalyticsListener {
            override fun onIsPlayingChanged(
                eventTime: AnalyticsListener.EventTime,
                isPlaying: Boolean
            ) {
                super.onIsPlayingChanged(eventTime, isPlaying)
            }
        }

    }

    private fun releasePlayer(){
        player?.let { player->
            playbackPosition = player.currentPosition
            mediaItemIndex = player.currentMediaItemIndex
            playWhenReady = player.playWhenReady
            player.removeListener(playbackStateLister)
            player.release()

        }
        player = null
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

}