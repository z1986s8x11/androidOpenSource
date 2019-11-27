package com.zhusx.opensource.video

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import org.jetbrains.anko.UI
import org.jetbrains.anko.button
import tcking.github.com.giraffeplayer2.GiraffePlayer
import tcking.github.com.giraffeplayer2.PlayerActivity
import tcking.github.com.giraffeplayer2.VideoInfo

class GiraffePlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(UI {
            button {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                text = "播放视频"
                setOnClickListener {
                    GiraffePlayer.play(this@GiraffePlayerActivity, VideoInfo("http://qfs-api.dddua.com/mv/QZ2850.mp4")
                            .setShowTopBar(false)
                            .setTitle("播放视频")
//                            .setAspectRatio(aspectRatio) //aspectRatio
                            .setFullScreenOnly(true)
                            .setPortraitWhenFullScreen(true)
                    )
                }
            }
        }.view)
    }
}