package io.gucci.videoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.gucci.videoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val list: ArrayList<Video> = arrayListOf(
            Video(
                title = "Android RoadMap",
                size = "139.26 MB",
                uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/videoplayer-a7b95.appspot.com/o/Videos%2FAndroid%20RoadMap.mp4?alt=media&token=533d5e70-6635-40d2-af92-326b418adfda")
            ),
            Video(
                title = "Изучение Kotlin за 30 минут",
                size = "110.42 MB",
                uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/videoplayer-a7b95.appspot.com/o/Videos%2F%D0%98%D0%B7%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5%20Kotlin%20%D0%B7%D0%B0%2030%20%D0%BC%D0%B8%D0%BD%D1%83%D1%82.mp4?alt=media&token=4e424ee6-7745-4d72-abb7-ba3ee587f86d")
            )
        )

        val videosRecycler = binding.videosRecycler
        videosRecycler.layoutManager = LinearLayoutManager(this)
        videosRecycler.adapter = VideosAdapter(this, list)
    }
}