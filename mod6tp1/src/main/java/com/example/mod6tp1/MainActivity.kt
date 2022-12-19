package com.example.mod6tp1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.mod6tp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (!it) {
            return@registerForActivityResult;
        }
        val intent = Intent(Intent.ACTION_SENDTO,).apply {
            data = Uri.parse("sms:"+binding.editTextNumber.text.toString())  // This ensures only SMS apps respond
            putExtra("sms_body", "tamer")
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.buttonCall.setOnClickListener{
            requestPermissionLauncher.launch(android.Manifest.permission.SEND_SMS)
        }
    }
}