import java.util.regex.Pattern.compile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    signingConfigs {
        getByName("debug") {

        }
    }

    compileSdkVersion(31)

    defaultConfig {
        applicationId = "com.example.petproject"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0.0"
        signingConfig = signingConfigs.getByName("debug")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }

        buildConfigField("String", "API_KEY_WEATHER", "\"753d69d5f5344fb88d6202251221409\"")

        buildConfigField("String", "ENDPOINT_WEATHER", "\"https://api.weatherapi.com/v1/forecast.json?\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.startup:startup-runtime:1.1.0")
    implementation("androidx.fragment:fragment-ktx:1.3.6")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("com.google.android.material:material:1.4.0")
    testImplementation("junit:junit:4.12")
}