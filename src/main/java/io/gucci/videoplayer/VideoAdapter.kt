package io.gucci.videoplayer

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.RecyclerView

class VideoHolder(v: View) : RecyclerView.ViewHolder(v)

class VideosAdapter(private val context: Context, private var videosList: ArrayList<Video>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.videos_list_template, parent, false)

        return VideoHolder(view)
    }

    override fun getItemCount(): Int {
        return videosList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val lists: Video = videosList[position]
        playerView = holder.itemView.findViewById(R.id.playerView)
        val name = holder.itemView.findViewById<TextView>(R.id.name)
        val size = holder.itemView.findViewById<TextView>(R.id.size)

        name.text = lists.title
        size.text = lists.size

        initializePlayer(lists.uri)

        val download = holder.itemView.findViewById<ImageView>(R.id.downloadBtn)
        download.setOnClickListener {
            MyDownService.dms(context, lists)
        }
    }

    private fun initializePlayer(uri: Uri) {
        player = ExoPlayer.Builder(context).build().also { exoPlayer ->
            playerView.player = exoPlayer

            val mediaItem = MediaItem.fromUri(uri)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.playbackParameters

        }
    }
}