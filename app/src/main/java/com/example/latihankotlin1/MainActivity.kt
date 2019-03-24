package com.example.latihankotlin1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            HandleLogin(username, password)
        }
        tv_ca.setOnClickListener {
            startActivity(intentFor<Register>())
            toast("Pindah ke Halaman Register")
        }
    }

    //membuat function atau methode untuk HandleLogin
    private fun HandleLogin(username: String, password: String) {
        info { "Data username : $username, Data password : $password" } // Log.i jika ditulis di java
        if (username.equals("admin") && password.equals("erdin")) {
            toast("Welcome Aboard $username")
        } else {
            alert ( title = "Warning", message = "Username atau password salah"){
                positiveButton(buttonText = "Oke"){
                    //
                }
                isCancelable = false
            }.show()
        }
    }
}
