package com.zhusx.opensource.camera

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.ImageEngine
import com.zhihu.matisse.internal.entity.CaptureStrategy
import com.zhusx.core.adapter._BaseRecyclerAdapter
import com.zhusx.core.adapter._ViewHolder
import com.zhusx.opensource.BuildConfig
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_matisses.*

/**
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2019/3/4 14:46
 */
class MatisseActivity : AppCompatActivity() {
    private val REQUEST_CODE_CHOOSE = 55
    private var adapter: _BaseRecyclerAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matisses)
        initView()
    }

    private fun initView() {
        tv_selector.setOnClickListener {
            AlertDialog.Builder(it.context).setItems(arrayOf("相册", "拍摄")) { _, which ->
                when (which) {
                    0 -> {
                        Matisse.from(this@MatisseActivity)
                                .choose(MimeType.ofImage())
                                .capture(false)  //是否可以拍照
                                .captureStrategy(CaptureStrategy(true, BuildConfig.APPLICATION_ID + ".libFileProvider"))
                                .countable(false)
                                .maxSelectable(1)
                                .spanCount(3)
                                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                                .thumbnailScale(0.85f)
                                .imageEngine(Glide4Engine())
                                .forResult(REQUEST_CODE_CHOOSE)
                    }
                    1 -> {
                        Matisse.from(this@MatisseActivity)
                                .choose(MimeType.ofImage())
                                .capture(true)  //是否可以拍照
                                .captureStrategy(CaptureStrategy(true, BuildConfig.APPLICATION_ID + ".libFileProvider"))
                                .countable(false)
                                .maxSelectable(1)
                                .spanCount(3)
                                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                                .thumbnailScale(0.85f)
                                .imageEngine(Glide4Engine())
                                .forResult(REQUEST_CODE_CHOOSE)
                    }
                    2 -> {
                    }
                }
            }.create().show()
        }
        adapter = object : _BaseRecyclerAdapter<String>(R.layout.item_image) {
            override fun bindViewHolder(holder: _ViewHolder, position: Int, s: String?) {
                Glide.with(this@MatisseActivity).load(s).into(holder.getView(R.id.iv_image))
            }
        }
        recyclerView.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            val mSelected = Matisse.obtainResult(data)
            adapter!!._setItemToUpdate(mSelected.map { it.toString() })
        }
    }

    class Glide4Engine : ImageEngine {
        override fun loadThumbnail(context: Context, resize: Int, placeholder: Drawable, imageView: ImageView, uri: Uri) {
            Glide.with(context)
                    .asBitmap() // some .jpeg files are actually gif
                    .load(uri)
                    .apply(RequestOptions()
                            .override(resize, resize)
                            .placeholder(placeholder)
                            .centerCrop())
                    .into(imageView)
        }

        override fun loadGifThumbnail(context: Context, resize: Int, placeholder: Drawable, imageView: ImageView, uri: Uri) {
            Glide.with(context)
                    .asBitmap() // some .jpeg files are actually gif
                    .load(uri)
                    .apply(RequestOptions()
                            .override(resize, resize)
                            .placeholder(placeholder)
                            .centerCrop())
                    .into(imageView)
        }

        override fun loadImage(context: Context, resizeX: Int, resizeY: Int, imageView: ImageView, uri: Uri) {
            Glide.with(context)
                    .load(uri)
                    .apply(RequestOptions()
                            .override(resizeX, resizeY)
                            .priority(Priority.HIGH)
                            .fitCenter())
                    .into(imageView)
        }

        override fun loadGifImage(context: Context, resizeX: Int, resizeY: Int, imageView: ImageView, uri: Uri) {
            Glide.with(context)
                    .asGif()
                    .load(uri)
                    .apply(RequestOptions()
                            .override(resizeX, resizeY)
                            .priority(Priority.HIGH)
                            .fitCenter())
                    .into(imageView)
        }

        override fun supportAnimatedGif(): Boolean {
            return true
        }
    }
}