package com.erikriosetiawan.myfirebasecloudmessaging

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.erikriosetiawan.myfirebasecloudmessaging.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubscribe.setOnClickListener {
            FirebaseMessaging.getInstance().subscribeToTopic("news")
            val message = getString(R.string.msg_subscribed)
            Log.d(TAG, message)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        binding.btnToken.setOnClickListener {
            val deviceToken = MyFirebaseMessagingService
            val message = getString(R.string.msg_token_fmt, deviceToken)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Refreshed token: $deviceToken")
            FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
                val msg = getString(R.string.msg_token_fmt, token)
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Refreshed token: $token")
            }
        }
    }
}