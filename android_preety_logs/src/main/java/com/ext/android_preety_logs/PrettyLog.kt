package com.ext.android_preety_logs

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object PrettyLog {
    private const val TOP = "╔══════════════════════════════════════════════════════════════"
    private const val MIDDLE = "╟──────────────────────────────────────────────────────────────"
    private const val BOTTOM = "╚══════════════════════════════════════════════════════════════"

    private fun time(): String {
        val sdf = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
        return sdf.format(Date())
    }

    // Get calling class and method name
    private fun getCallerInfo(): String {
        val stackTrace = Thread.currentThread().stackTrace
        // Index 5 is usually the actual caller (adjust if needed)
        return if (stackTrace.size > 5) {
            val element = stackTrace[5]
            "${element.className.substringAfterLast('.')}.${element.methodName}(${element.lineNumber})"
        } else {
            "Unknown"
        }
    }

    fun d(tag: String, msg: String) {
        Log.d(tag, build("🐛 DEBUG", msg))
    }

    fun i(tag: String, msg: String) {
        Log.i(tag, build("ℹ️ INFO", msg))
    }

    fun w(tag: String, msg: String) {
        Log.w(tag, build("⚠️ WARNING", msg))
    }

    fun e(tag: String, msg: String) {
        Log.e(tag, build("❌ ERROR", msg))
    }

    // Success log
    fun s(tag: String, msg: String) {
        Log.i(tag, build("✅ SUCCESS", msg))
    }

    // Verbose log
    fun v(tag: String, msg: String) {
        Log.v(tag, build("📝 VERBOSE", msg))
    }

    // WTF log (What a Terrible Failure)
    fun wtf(tag: String, msg: String) {
        Log.wtf(tag, build("💥 WTF", msg))
    }

    // JSON formatting
    fun json(tag: String, json: String) {
        val formatted = try {
            // Basic JSON formatting
            json.trim()
        } catch (e: Exception) {
            json
        }
        Log.d(tag, build("📦 JSON", formatted))
    }

    // Network request log
    fun network(tag: String, url: String, method: String = "GET", response: String = "") {
        val msg = """
            🌐 URL     : $url
            📡 Method  : $method
            ${if (response.isNotEmpty()) "📥 Response: $response" else ""}
        """.trimIndent()
        Log.d(tag, build("🌍 NETWORK", msg))
    }

    // Exception/Throwable log
    fun exception(tag: String, throwable: Throwable, msg: String = "") {
        val exMsg = """
            ${if (msg.isNotEmpty()) "💬 Message: $msg\n" else ""}🔥 Exception: ${throwable.javaClass.simpleName}
            📍 Cause   : ${throwable.message ?: "Unknown"}
            📚 Stack   : ${throwable.stackTraceToString().take(200)}...
        """.trimIndent()
        Log.e(tag, build("🔴 EXCEPTION", exMsg))
    }

    // Object/Data class log
    fun obj(tag: String, obj: Any, label: String = "Object") {
        Log.d(tag, build("🎯 $label", obj.toString()))
    }

    // List/Array log
    fun list(tag: String, list: List<*>, label: String = "List") {
        val items = list.joinToString("\n            ") { "• $it" }
        val msg = """
            📊 Size: ${list.size}
            📋 Items:
            $items
        """.trimIndent()
        Log.d(tag, build("📜 $label", msg))
    }

    // Method entry/exit tracking
    fun enter(tag: String, methodName: String = getCallerInfo()) {
        Log.d(tag, build("➡️ ENTER", methodName))
    }

    fun exit(tag: String, methodName: String = getCallerInfo()) {
        Log.d(tag, build("⬅️ EXIT", methodName))
    }

    // Lifecycle log
    fun lifecycle(tag: String, event: String) {
        Log.d(tag, build("♻️ LIFECYCLE", event))
    }

    // Performance/Timer log
    fun timer(tag: String, label: String, durationMs: Long) {
        val msg = """
            ⏱️ Label   : $label
            ⏳ Duration: ${durationMs}ms
        """.trimIndent()
        Log.d(tag, build("⚡ PERFORMANCE", msg))
    }

    // Database operations
    fun database(tag: String, query: String, result: String = "") {
        val msg = """
            🗄️ Query  : $query
            ${if (result.isNotEmpty()) "📊 Result : $result" else ""}
        """.trimIndent()
        Log.d(tag, build("💾 DATABASE", msg))
    }

    // Custom log with caller info
    fun custom(tag: String, emoji: String, type: String, msg: String, showCaller: Boolean = false) {
        val finalMsg = if (showCaller) {
            """
                $msg
                📍 Caller: ${getCallerInfo()}
            """.trimIndent()
        } else {
            msg
        }
        Log.d(tag, build("$emoji $type", finalMsg))
    }

    private fun build(type: String, msg: String): String {
        return """
$TOP
⏰ Time   : ${time()}
🔖 Type   : $type
$MIDDLE
💬 Message:
$msg
$BOTTOM
        """.trimIndent()
    }
}