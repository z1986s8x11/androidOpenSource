package com.zhusx.opensource.camera

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.king.zxing.CaptureActivity
import com.king.zxing.Intents
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_rolling_textview.*


/**
 * https://github.com/jenly1314/ZXingLite
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/23 1:08
 */
class ZXingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)
        tv_start.setOnClickListener {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            when (requestCode) {
                11 -> {
                    val result = data.getStringExtra(Intents.Scan.RESULT)
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim.fade_in, android.R.anim.fade_out)
        val intent = Intent(this, CaptureActivity::class.java)
        ActivityCompat.startActivityForResult(this, intent, 11, optionsCompat.toBundle())
    }
}
