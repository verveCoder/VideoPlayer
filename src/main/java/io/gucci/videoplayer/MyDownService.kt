package io.gucci.videoplayer

import android.app.DownloadManager
import android.content.Context
import android.os.Environment

object MyDownService {
    fun dms(context: Context, list: Video){
        val req = DownloadManager.Request(list.uri)
        req.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)
            .setTitle(list.title)
            .setDescription("VideoPlayer")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
            .setRequiresCharging(false)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, list.title+".mp4")

        val dm = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(req)
    }
}