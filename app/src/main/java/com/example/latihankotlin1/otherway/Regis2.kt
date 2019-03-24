package com.example.latihankotlin1.otherway

import android.graphics.Color
import android.graphics.Typeface.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.latihankotlin1.R
import org.jetbrains.anko.*

class Regis2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RegisterView().setContentView(this)
        var btn: Button = findViewById(R.id.btn)
        var fname: EditText = findViewById(R.id.et_fullname)
        var uname: EditText = findViewById(R.id.et_username)
        var passwd: EditText = findViewById(R.id.et_password)
        btn.setOnClickListener {
            val fullname = fname.text.toString().trim()
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            HandleRegister(fullname, username, password)
        }
    }

    private fun HandleRegister(fullname: String, username: String, password: String) {
        info { "fullname: $fullname \nusername: $username \npassword: $password" }
        when {
            fullname.isEmpty() -> toast("Fullname belum disisi")
            username.isEmpty() -> toast("Username belum disisi")
            password.isEmpty() -> toast("Password belum disisi")
            else -> alert(title = "Register", message = "Username : $username berhasil di tambahkan") {
                positiveButton(buttonText = "OK") {
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
        }
    }

    //membuat class yang akan mendesign layout
    class RegisterView : AnkoComponent<Regis2> {
        override fun createView(ui: AnkoContext<Regis2>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                }
                textView {
                    text = "Register"
                    textSize = 30f
                    textColor = Color.BLACK
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    typeface = create(DEFAULT, BOLD_ITALIC)
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = dip(15)
                }
                editText {
                    id = R.id.et_fullname
                    hint = "Fullname"
                    inputType = TYPE_CLASS_TEXT
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = dip(15)
                }
                editText {
                    id = R.id.et_username
                    hint = "Username"
                    inputType = TYPE_CLASS_TEXT
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = dip(15)
                }
                editText {
                    id = R.id.et_password
                    hint = "Password"
                    inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = dip(15)
                }
                button("REGISTER") {
                    id = R.id.btn
                    backgroundColor = Color.rgb(17, 70, 179)
                    textColor = Color.WHITE
                }.lparams(width = wrapContent, height = wrapContent) {
                    margin = 10
                    gravity = Gravity.CENTER
                }
            }
        }
    }
}