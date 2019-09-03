package com.codemobiles.myauthen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codemobiles.myauthen.models.User
import com.codemobiles.myauthen.util.USER_BEAN

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val user = intent.getParcelableExtra<User>(USER_BEAN)
        val username = user.username
        val password = user.password
        Toast.makeText(applicationContext, username + password, Toast.LENGTH_LONG).show()
    }
}
