package com.codemobiles.myauthen

import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codemobiles.myauthen.models.User
import com.codemobiles.myauthen.util.PREFS_KEY_PASSWORD
import com.codemobiles.myauthen.util.PREFS_KEY_USERNAME
import com.codemobiles.myauthen.util.USER_BEAN
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        setupEventWidget()
    }

    private fun setupEventWidget() {
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            Prefs.putString(PREFS_KEY_USERNAME, username)
            Prefs.putString(PREFS_KEY_PASSWORD, password)

            // Toast.makeText(applicationContext, username + password, Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(applicationContext, SuccessActivity::class.java)
            intent.putExtra(USER_BEAN, User(username, password))

            startActivity(intent)
        }

        usernameEditText.setText(Prefs.getString(PREFS_KEY_USERNAME, ""))
        passwordEditText.setText(Prefs.getString(PREFS_KEY_PASSWORD, ""))
    }


}
