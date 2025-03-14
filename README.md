# 🚀 Toasify – Beautiful & Customizable Toasts for Jetpack Compose  

**Toasify** is a lightweight and elegant **Toast UI library** for Android, built with **Jetpack Compose**. It provides **beautiful, animated, and customizable toast messages** to enhance your app’s user experience.  

## ✨ Features  
- ✅ **Modern Design** – Clean and sleek toast UI  
- 🎨 **Fully Customizable** – Change colors, animations, icons, and duration  
- ⚡ **Easy to Use** – One-line implementation for quick integration  
- 🚀 **Lightweight & Fast** – Optimized for performance  
- 🌙 **Dark Mode Support** – Automatically adapts to theme settings  

## 📸 Preview  

![Screen_recording_20250311_144056](https://github.com/user-attachments/assets/86fc6b48-69cc-49ab-b21d-6262b19efe0e)

  

## 📌 Usage  

### 🏁 Installation
https://jitpack.io/#mohammad-firmansyah/toasify/1.0.0

### 🏁 Basic Example  
```kotlin
ToastManager.showInfo(
    message = "Hello, Jetpack Compose! 🚀")

// before using Toastmanager you must put toast container at outer of your component layer
setContent{
    ....

    ToastContainer()
}

