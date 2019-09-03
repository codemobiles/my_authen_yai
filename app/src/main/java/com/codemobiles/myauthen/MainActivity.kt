package com.codemobiles.myauthen

import android.content.ContextWrapper
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codemobiles.myauthen.util.PREFS_KEY_PASSWORD
import com.codemobiles.myauthen.util.PREFS_KEY_USERNAME
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // tanakorn codemobiles

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            Prefs.putString(PREFS_KEY_USERNAME, username)
            Prefs.putString(PREFS_KEY_PASSWORD, password)

            Toast.makeText(applicationContext, username + password, Toast.LENGTH_LONG).show()
        }

        usernameEditText.setText(Prefs.getString(PREFS_KEY_USERNAME, ""))
        passwordEditText.setText(Prefs.getString(PREFS_KEY_PASSWORD, ""))
    }


}
