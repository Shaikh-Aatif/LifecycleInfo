package com.systems.lifecyclechecker

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.webkit.PermissionRequest
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    // Permission request code
    
    private val PERMISSION_REQUEST_CODE = 1001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("onCreate", "onCreate")
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("onCreate")
        val text = findViewById<TextView>(R.id.textViews)
        text.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                checkAndRequestPermission()
            } else {
                // Permissions are granted at install time on lower versions
                // Handle your logic here for lower versions
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart")


    }
    override fun onResume() {
        super.onResume()
        Log.e("Onresume", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.e("onPause", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.e("onStop", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "onDestroy")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart", "onRestart")
    }
    private fun checkAndRequestPermission() {
        // Check if the permission is already granted
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.CAMERA),
                PERMISSION_REQUEST_CODE
            )
        } else {
            // Permission is already granted, proceed with your logic
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Check if the permission is granted
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with your logic
            } else {
//              checkAndRequestPermission()
            }
        }
    }
}
