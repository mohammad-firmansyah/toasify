# 🚀 Toasify – Beautiful & Customizable Toasts for Jetpack Compose  

**Toasify** is a lightweight and elegant **Toast UI library** for Android, built with **Jetpack Compose**. It provides **beautiful, animated, and customizable toast messages** to enhance your app’s user experience.  

## ✨ Features  
- ✅ **Modern Design** – Clean and sleek toast UI  
- 🎨 **Fully Customizable** – Change colors, animations, icons, and duration  
- ⚡ **Easy to Use** – One-line implementation for quick integration  
- 🚀 **Lightweight & Fast** – Optimized for performance  
- 🌙 **Dark Mode Support** – Automatically adapts to theme settings (or let you override the theme)  
- ❌ **Manual Dismiss** – Close a toast any time via the built-in top-right icon  

## 📸 Preview  
![image](https://github.com/user-attachments/assets/a658cea1-3915-4a20-93db-d0bb8c002203)


  

## 📌 Usage  

### 🏁 Basic Example  
```kotlin
Toasify.show(
    message = "Hello, Jetpack Compose! 🚀",
    type = ToastType.Success
)

// Wrap your UI with the toast container (supports theme override & custom duration)
ToastContainer(
    autoDismissDuration = 3000L,
    darkTheme = false // Set to true or supply a custom Material3 ColorScheme
)
