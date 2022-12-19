package com.example.mod6intentimpl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (!it) {
            return@registerForActivityResult;
        }
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:0682566749"))
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonMap = findViewById<Button>(R.id.buttonMap)
        val buttonCall = findViewById<Button>(R.id.buttonCall)

        buttonCall.setOnClickListener{
            requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
        }

        buttonMap.setOnClickListener{
            Intent(Intent.ACTION_VIEW, Uri.parse("geo:46.1599686 -2.9622542")).also {
                startActivity(it)
            }
        }

    }
}