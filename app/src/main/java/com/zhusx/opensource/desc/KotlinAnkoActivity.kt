package com.zhusx.opensource.desc

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.zhusx.core.widget.view._TextView
import com.zhusx.opensource.MainActivity
import com.zhusx.opensource.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import java.util.*

class KotlinAnkoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //然后在LayShowActivity调用下面的方法即可实现加载布局
        CustoomActivityLayoutUI().setContentView(this)
    }

    //声明一个类继承AnkoComponent，对应泛型类到一个LayShowActivity，然后布局
    class CustoomActivityLayoutUI : AnkoComponent<KotlinAnkoActivity> {
        override fun createView(ui: AnkoContext<KotlinAnkoActivity>) = with(ui) {
            verticalLayout {
                verticalLayout {
                    padding = dip(10)
                    val name = editText("LayoutActyUI") {
                        id = android.R.id.edit
                        hint = "测试"
                    }
                    button("Say Hello") {
                        setOnClickListener {
                            ctx.toast("Hello, ${name.text}!")
                            name.textColor = 0xffff0000.toInt()
                        }
                    }
                }
                relativeLayout {
                    val tv = textView {
                        id = android.R.id.text1
                    }.lparams {
                        width = ViewGroup.LayoutParams.MATCH_PARENT
                        height = dip(200)
                        centerInParent()
                    }
                    button("change size") {
                        setOnClickListener {
                            tv.text = "${Random().nextInt(200) + 100}"
                            tv.invalidate()
                        }
                    }.lparams {
                        below(tv)
                        centerHorizontally()
                    }
                }
            }
        }
    }

    fun startActivityDemo() {
        //启动
        startActivity<MainActivity>()
        //MainActivity接收参数
        var name = intent.extras.getString("name")
        var age = intent.extras.getInt("age")
        //若有其它设置，则&intentFor方法&构建intent
        startActivity(intentFor<MainActivity>("name" to "小红", "age" to 13).singleTop())
    }

    fun DimensionDemo() {
        dip(100)//dp->px
        px2dip(100)//px->dp
    }

    fun helpDemo() {
        //实用的attempt函数，{}若正常执行，则value返回{}的返回值，
        //若{}执行有异常，并不会闪退，只是会设置个error属性。很好的try..catch替代方案
        attempt { 3 }.value//结果3
        attempt { 1 / 0 }.error
        //还有sdk版本相关的
        doFromSdk(21) {
            Log.e("", "从api 21开始打印")
        }
        doIfSdk(21) {
            //获得版本名也简单的多
            packageManager.getPackageInfo(packageName, 0).versionName
            Log.e("", "只有api 21才打印")
        }
    }

    fun alertDemo() {
        alert("this is the msg") {
            okButton { toast("button-ok") }
            cancelButton { toast("button-cancel") }
        }.show()
    }

    fun selectorDemo() {
        val countries = listOf("Russia", "USA", "England", "Australia")
        selector("Where are you from?", countries) { ds, i ->
            toast("So you're living in ${countries[i]}, right?")
        }
    }

    // 涉及Anko 布局DSL
    fun createView() {
        val BTN_ID = android.R.id.text1
        verticalLayout {
            padding = dip(30)
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                hint = "Password"
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
                id = BTN_ID
            }
        }
        //note
        //id findview
        find<Button>(BTN_ID).setOnClickListener { toast("this is login button") }
    }
}

class AnkoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            verticalLayout {
                editText()
                button("OK")
            }
        }.view
    }

    companion object {
        fun newInstance(): AnkoFragment {
            return AnkoFragment()
        }
    }
}