# Toasify – Jetpack Compose Toast Library for Android
Toasify is a lightweight and modern Android toast message library built with Jetpack Compose. It helps developers show clean, animated toast notifications with minimal effort. Toasify offers two smooth slide-in animations (from the top and bottom of the screen), allowing you to enhance user experience with elegant UI feedback.

Designed for Android developers using Jetpack Compose, Toasify removes the hassle of manually building custom toasts. With easy integration, full customization options (colors, icons, duration, shape), and a clean API, Toasify is perfect for apps that prioritize both performance and design consistency. 

## ✨ Features  
- ✅ **Modern Design** – Clean and sleek toast UI  
- 🎨 **Fully Customizable** – Change colors, animations, icons, and duration  
- ⚡ **Easy to Use** – One-line implementation for quick integration  
- 🚀 **Lightweight & Fast** – Optimized for performance  
- 🌙 **Dark Mode Support** – Automatically adapts to theme settings and lets you override the color scheme  
- ❌ **Manual Dismiss** – Close the toast early with the built-in top-right close icon  

## 📸 Preview  

![Screen_recording_20250311_144056](https://github.com/user-attachments/assets/86fc6b48-69cc-49ab-b21d-6262b19efe0e)

  

## 📌 Usage  

### 🏁 Installation
build.gradle.kts (:app)
```
...
	dependencies {
	        implementation("com.github.mohammad-firmansyah:toasify:Tag")
	}
...
```

settings.gradle.kts
```
...
 dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}
...
```

### 🏁 Basic Example  
```kotlin
ToastManager.showInfo(
    message = "Hello, Jetpack Compose! 🚀")

// before using Toastmanager, ensure the ToastContainer is added to the parent component

setContent{
    ....

    // Optionally override duration, theme, or provide a custom color scheme
    ToastContainer(
        autoDismissDuration = 3000L,
        darkTheme = true // or false, or provide a custom Material3 ColorScheme
    )
}
