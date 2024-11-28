plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.userinterfaceapp"
    compileSdk = 35 // Mise à jour vers API 35

    defaultConfig {
        applicationId = "com.example.userinterfaceapp"
        minSdk = 24
        targetSdk = 35 // Mise à jour vers API 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) // Pointe vers la dernière version d'AndroidX Core KTX
    implementation(libs.androidx.appcompat)
    implementation(libs.material) // Pointe vers la bibliothèque Material définie dans libs.versions.toml
    implementation("com.google.android.material:material:1.9.0") // Utilisation correcte de la dépendance Material Design Components
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
