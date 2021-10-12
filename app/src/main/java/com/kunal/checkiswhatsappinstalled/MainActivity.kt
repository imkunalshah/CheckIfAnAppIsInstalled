package com.kunal.checkiswhatsappinstalled

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //com.whatsapp
        btn = findViewById(R.id.btn)
        val pm: PackageManager = this.packageManager
        btn.setOnClickListener {
            if (isPackageInstalled("com.whatsapp",pm)){
                Toast.makeText(this, "What's App is installed", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "What's App is not installed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPackageInstalled(packageName: String, packageManager: PackageManager): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}