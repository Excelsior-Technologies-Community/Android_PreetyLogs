# **Android Pretty Logs 📋✨**


---
A lightweight, extensible Kotlin logging utility for Android that makes Logcat output clean, readable, and informative using borders, emojis, timestamps, log types, and structured sections.

---

## ✨ **Features**

- 🧱 Boxed / bordered logs

- ⏰ Timestamp (HH:mm:ss.SSS)

- 🔖 Log type labels (DEBUG, INFO, ERROR, etc.)

- 😄 Emoji-based visual distinction

- 📦 JSON logging

- 🌍 Network request logs

- 🔴 Exception & stack trace logs

- 📜 List & object logging

- ➡️ Method entry / exit tracking

- ♻️ Lifecycle logs

- ⚡ Performance timing logs

- 💾 Database query logs




  ---

# **Preview**
---
<p align="center">
  <img src="https://github.com/S13reya/Android_PreetyLogs/blob/stages/app/src/main/assets/demovideo.png" height="320"/>




</p>


## ⚡ **Installation**

**Step 1:** Add JitPack repository to your root build.gradle:

```gradle
maven { url = uri("https://jitpack.io") }
```

**Step 2:** Add the dependency in your app `build.gradle` (example if hosted on JitPack):  

```gradle
dependencies {
	        implementation 'com.github.Excelsior-Technologies-Community:Android_PreetyLogs:1.0.0'

}
```

## ⚡ **Usage**

**1.🔹 Basic Logs**

```
PrettyLog.d("PRETTY", "This is a Debug log")
PrettyLog.i("PRETTY", "This is an Info log")
PrettyLog.w("PRETTY", "This is a Warning log")
PrettyLog.e("PRETTY", "This is an Error log")
PrettyLog.s("PRETTY", "Operation successful")
```

**2.🔹 🔹 Lifecycle Log**

```
PrettyLog.lifecycle("LIFECYCLE", "onCreate")
```
**3.🔹 Json Logs**

```
PrettyLog.json("PRETTY_JSON", jsonString)
```

**4.🔹 Network Log**

```
PrettyLog.network(
tag = "NETWORK",
url = "https://api.example.com/users",
method = "POST",
response = "Success: 200"
)
```
**5.🔹 Exception Logs**

```
try {
throw Exception("Something went wrong")
} catch (e: Exception) {
PrettyLog.exception("ERROR", e, "Failed to process data")
}
```
**5.🔹 List Log**

```
PrettyLog.list("DATA", listOf("Apple", "Banana"), "Fruits")
```
**6.🔹 Object Logs**

```
data class User(val name: String, val age: Int)
PrettyLog.obj("USER", User("John", 25))
```

**7.🔹 🔹 Database Log**

```
PrettyLog.database("DB", "SELECT * FROM users", "1 row found")
```
**8.🔹Custom Log**

```
PrettyLog.list("DATA", listOf("Apple", "Banana"), "Fruits")
```
**9.🔹 Object Logs**

```
PrettyLog.custom(
tag = "CUSTOM",
emoji = "🎉",
type = "CELEBRATION",
msg = "App launched!",
showCaller = true
)
```






## **📄 License**

**MIT License**  
```
Copyright (c) 2025 Excelsior Technologies

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED **"AS IS"**, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```



  
