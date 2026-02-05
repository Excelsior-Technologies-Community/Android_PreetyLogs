package com.ext.android_preetylogs


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ext.android_preety_logs.PrettyLog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PrettyLog.lifecycle("LIFECYCLE", "onCreate")

        // Basic logs
        PrettyLog.d("PRETTY", "This is a Debug log")
        PrettyLog.i("PRETTY", "This is an Info log")
        PrettyLog.w("PRETTY", "This is a Warning log")
        PrettyLog.e("PRETTY", "This is an Error log")
        PrettyLog.s("PRETTY", "Operation completed successfully!")

        // JSON log
        val json = """
            {
              "name": "Android",
              "version": 14,
              "library": "PrettyLogs"
            }
        """.trimIndent()
        PrettyLog.json("PRETTY_JSON", json)

        // Network log
        PrettyLog.network("NETWORK", "https://api.example.com/users", "POST", "Success: 200")

        // Exception log
        try {
            throw Exception("Something went wrong!")
        } catch (e: Exception) {
            PrettyLog.exception("ERROR", e, "Failed to process data")
        }

        // List log
        val fruits = listOf("Apple", "Banana", "Orange", "Mango")
        PrettyLog.list("DATA", fruits, "Fruits")

        // Object log
        data class User(val name: String, val age: Int)
        val user = User("John Doe", 25)
        PrettyLog.obj("USER", user, "User Data")

        // Method tracking
        PrettyLog.enter("METHOD", "fetchUserData()")
        // ... some code ...
        PrettyLog.exit("METHOD", "fetchUserData()")

        // Performance timer
        val startTime = System.currentTimeMillis()
        // ... some operation ...
        Thread.sleep(100)
        val duration = System.currentTimeMillis() - startTime
        PrettyLog.timer("PERF", "Data Processing", duration)

        // Database log
        PrettyLog.database("DB", "SELECT * FROM users WHERE id = 1", "1 row found")

        // Custom log
        PrettyLog.custom("CUSTOM", "🎉", "CELEBRATION", "App launched successfully!", showCaller = true)
    }
}