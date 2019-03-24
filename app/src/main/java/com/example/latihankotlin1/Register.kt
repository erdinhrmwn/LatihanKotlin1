package com.example.latihankotlin1

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_activity.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        btn_reg.setOnClickListener {
            val fullname = reg_fullname.text.toString().trim()
            val username = reg_username.text.toString().trim()
            val password = reg_password.text.toString().trim()
            HandleRegister(fullname, username, password)
        }
    }

    private fun HandleRegister(fullname: String, username: String, password: String) {
        info { "fullname: $fullname \nusername: $username \npassword: $password" }
        when {
            fullname.isEmpty() -> toast("Fullname belum disisi")
            username.isEmpty() -> toast("Username belum disisi")
            password.isEmpty() -> toast("Password belum disisi")
            else -> alert(title = "Register", message = "$username berhasil di tambahkan") {
                positiveButton(buttonText = "OK") {
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
        }
    }
}