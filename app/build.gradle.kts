plugins {
    id ("com.android.application")
    id ("kotlin-android")
}

android {
    compileSdkVersion(Versions.compileSDK)
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        applicationId =  Application.id
        minSdkVersion(Versions.minSDK)
        targetSdkVersion(Versions.targetSDK)
        versionCode = Application.version_code
        versionName = Application.version_name
        testInstrumentationRunner = dependenies.AndroidTestDependencies.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            applicationIdSuffix = ".development"
            versionNameSuffix = "-DEBUG"
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
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
}

dependencies {
    implementation (dependenies.SupportDependencies.appCompat)
    implementation (dependenies.SupportDependencies.material)
    implementation (dependenies.SupportDependencies.constraint_layout)
    testImplementation (dependenies.TestDependencies.junit)
    androidTestImplementation(dependenies.AndroidTestDependencies.ext_junit)
    androidTestImplementation(dependenies.AndroidTestDependencies.espresso)
}