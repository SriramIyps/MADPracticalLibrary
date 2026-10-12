# MAD Practical Library

[![JitPack](https://jitpack.io/v/SriramIyps/MADPracticalLibrary.svg)](https://jitpack.io/#SriramIyps/MADPracticalLibrary)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A comprehensive Android Studio project providing:
1. **Interactive Viewer App (`:app`)**: A clean Material Design Android application to browse, search, and copy source code for 10 Mobile Application Development (MAD) practical programmes.
2. **Reusable Android Library (`:madlibrary`)**: A standalone AAR library with packaged source code assets and an intuitive Java API to retrieve source files and copy code programmatically in any Android app.

---

## 📱 Practicals Included (1–10)

| # | Title | Description | Primary Files |
|---|---|---|---|
| **01** | **Text Color Changer** | Cycles TextView color through Red, Blue, Green, and Magenta on click | `MainActivity.java`, `activity_main.xml` |
| **02** | **Registration Form** | Form with RadioGroup, DatePicker dialog, and Spinner adapter | `MainActivity.java`, `activity_main.xml` |
| **03** | **AlertDialog Demo** | Modal dialog with custom title, message, and dismiss button | `MainActivity.java`, `activity_main.xml` |
| **04** | **ProgressDialog Demo** | ProgressDialog simulation with completion Toast | `MainActivity.java`, `activity_main.xml` |
| **05** | **Start/Stop Toast Demo** | Two action buttons demonstrating interactive Android Toasts | `MainActivity.java`, `activity_main.xml` |
| **06** | **Explicit & Implicit Intent** | Opens second activity (`new6`) and browser web page | `MainActivity.java`, `new6.java`, `activity_main.xml` |
| **07** | **Layout Manager Demo** | LinearLayout hierarchy structuring UI elements and margins | `MainActivity.java`, `activity_main.xml` |
| **08** | **Options Menu Demo** | Options menu with Home, About, and Exit action handlers | `MainActivity.java`, `menu_main.xml`, `activity_main.xml` |
| **09** | **Simple Calculator** | Arithmetic calculator with Add, Sub, Mul, and Div operations | `MainActivity.java`, `activity_main.xml` |
| **10** | **Number Guessing Game** | Random number generation with guess comparison logic | `MainActivity.java`, `activity_main.xml` |

---

## 📦 Using in Another Android Studio Project

### 1. Add JitPack Repository

In your target project's `settings.gradle` (or project root `build.gradle`):

```groovy
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add the Dependency

In your target app's `app/build.gradle`:

```groovy
dependencies {
    implementation 'com.github.SriramIyps:MADPracticalLibrary:1.0.0'
}
```

---

## 💻 Java Usage Example

```java
import com.madlibrary.MADLibrary;
import com.madlibrary.ProgrammeDetails;
import java.util.Map;

// 1. Get metadata for a practical
ProgrammeDetails p1 = MADLibrary.getProgramme(1);
String title = p1.getTitle(); // "Text Color Changer"

// 2. Retrieve a specific source file
String javaCode = MADLibrary.getFileContent(context, 1, "MainActivity.java");

// 3. Retrieve all source files for a practical as a Map
Map<String, String> files = MADLibrary.getProgrammeFiles(context, 1);
String layoutXml = files.get("activity_main.xml");

// 4. Copy all files formatted with headers to Android clipboard
boolean success = MADLibrary.copyProgrammeToClipboard(context, 1);
```

---

## 🛠️ Building Locally

```bash
# Clone the repository
git clone https://github.com/SriramIyps/MADPracticalLibrary.git
cd MADPracticalLibrary

# Build the library AAR
./gradlew :madlibrary:assembleRelease

# Build the viewer app APK
./gradlew :app:assembleDebug

# Run unit tests
./gradlew :madlibrary:testDebugUnitTest
```

---

## 📄 License

Licensed under the [Apache License, Version 2.0](LICENSE).
