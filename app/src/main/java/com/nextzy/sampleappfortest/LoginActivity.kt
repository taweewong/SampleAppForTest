package com.nextzy.sampleappfortest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    companion object {
        private const val USERNAME = "admin"
        private const val PASSWORD = "123456"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        buttonLogin.setOnClickListener {
            login(
                editTextUsername.text.toString(),
                editTextPassword.text.toString()
            )
        }
    }

    private fun login(username: String, password: String) {
        when (validateLoginData(username, password)) {
            true -> verifyLoginData(username, password)
        }
    }

    private fun verifyLoginData(username: String, password: String) {
        when (!username.equals(USERNAME, ignoreCase = true) or !password.equals(PASSWORD, ignoreCase = true)) {
            true -> showAlertDialog()
            false -> goToMainScreen()
        }
    }

    private fun validateLoginData(username: String, password: String): Boolean {
        when (username.isEmpty()) {
            true -> showUsernameRequire()
            false -> hideUsernameRequire()
        }
        when (password.isEmpty()) {
            true -> showPasswordRequire()
            false -> hidePasswordRequire()
        }
        return username.isNotEmpty() and password.isNotEmpty()
    }

    private fun showUsernameRequire() {
        textViewAlertUsername.visibility = View.VISIBLE
    }

    private fun hideUsernameRequire() {
        textViewAlertUsername.visibility = View.GONE
    }

    private fun showPasswordRequire() {
        textViewAlertPassword.visibility = View.VISIBLE
    }

    private fun hidePasswordRequire() {
        textViewAlertPassword.visibility = View.GONE
    }

    private fun showAlertDialog() {
        LoginAlertDialog.newInstance(getString(R.string.wrong_username_password)).show(supportFragmentManager, null)
    }

    private fun goToMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
