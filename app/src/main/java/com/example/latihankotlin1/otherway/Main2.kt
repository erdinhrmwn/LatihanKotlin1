package com.example.latihankotlin1.otherway

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.latihankotlin1.R
import org.jetbrains.anko.*

class Main2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)

        var btn: Button = findViewById(R.id.btn)
        var uname: EditText = findViewById(R.id.et_username)
        var passwd: EditText = findViewById(R.id.et_password)
        var regis: TextView = findViewById(R.id.tv_reg)
        btn.setOnClickListener {
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            HandleLogin(username, password)
        }
        regis.setOnClickListener {
            startActivity(intentFor<Regis2>())
        }

        uname.setOnFocusChangeListener { view, b -> Focus(b) }
    }

    private fun Focus(b: Boolean) {
        var uname: EditText = findViewById(R.id.et_username)
        var tv_uname: TextView = findViewById(R.id.tv_username)
        var passwd: EditText = findViewById(R.id.et_password)
        var tv_passwd: TextView = findViewById(R.id.tv_password)
        if (b) {
            passwd.hint = "Password"
            uname.hint = ""
            tv_uname.visibility = View.VISIBLE
            tv_passwd.visibility = View.INVISIBLE
        } else {
            uname.hint = "Username"
            passwd.hint = ""
            tv_passwd.visibility = View.VISIBLE
            tv_uname.visibility = View.INVISIBLE
        }
    }

    //membuat function atau methode untuk HandleLogin
    private fun HandleLogin(username: String, password: String) {
        info { "Data username : $username, Data password : $password" } // Log.i jika ditulis di java
        if (username.equals("admin") && password.equals("erdin")) {
            startActivity(intentFor<AfterLogin2>("username" to username))
            finish()
        } else {
            alert(title = "Warning", message = "Username atau password salah") {
                positiveButton(buttonText = "Oke") {
                    //
                }
                isCancelable = false
            }.show()
        }
    }

    //membuat class yang akan mendesign layout
    class LoginView : AnkoComponent<Main2> {
        override fun createView(ui: AnkoContext<Main2>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    backgroundColor = Color.rgb(11, 120, 155)
                    margin = 15
                }
                imageView {
                    setImageResource(R.mipmap.firebase)
                }.lparams(width = matchParent, height = dip(250)) {
                    margin = 15
                }
                textView {
                    id = R.id.tv_username
                    text = "Email"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_username
                    hint = "Username"
                    inputType = TYPE_CLASS_TEXT
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                textView {
                    id = R.id.tv_password
                    text = "Password"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_password
                    hint = "Password"
                    inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                button("LOGIN") {
                    id = R.id.btn
                    backgroundColor = Color.rgb(216, 176, 40)
                    textColor = Color.BLACK
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    gravity = Gravity.CENTER
                }
                textView {
                    id = R.id.tv_ca
                    text = "Forgot your password?"
                    textSize = 18f
                    textColor = Color.rgb(216, 176, 40)
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 150
                }
                textView {
                    id = R.id.tv_reg
                    text = "Not a member? Get registered in Firebase now"
                    textSize = 18f
                    textColor = Color.WHITE
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 150
                }
            }
        }
    }
}
