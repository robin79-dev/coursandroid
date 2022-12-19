package com.example.mod6intentexpl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class TargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        Snackbar.make(
            findViewById<ConstraintLayout>(R.id.constraintTarget),
            intent.getStringExtra("nom").toString(),
            Snackbar.LENGTH_LONG
        ).show()
    }
}