package com.example.latihankotlin1.otherway

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.TextView
import com.example.latihankotlin1.R
import org.jetbrains.anko.*

class AfterLogin2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AfterLoginView().setContentView(this)

        var username = intent.getStringExtra("username")
        var uname : TextView = findViewById(R.id.uname)

        uname.text = username

    }

    class AfterLoginView() : AnkoComponent<AfterLogin2> {
        override fun createView(ui: AnkoContext<AfterLogin2>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    verticalGravity = Gravity.CENTER
                }
                textView {
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    textSize = 35f
                    typeface = Typeface.DEFAULT_BOLD
                    text = "Welcome,"
                }
                textView {
                    id = R.id.uname
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    textSize = 30f
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
                    text = "uname"
                }
            }
        }

    }
}