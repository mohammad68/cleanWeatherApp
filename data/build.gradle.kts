plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android{
    compileSdkVersion(AndroidConfig.COMPILE_SDK)
    buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK)
        targetSdkVersion(AndroidConfig.TARGET_SDK)
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

    implementation(project(ProjectModule.DOMAIN))

    implementation(Dependencies.KOTLIN_STANDARD_LIBRARY)

    implementation(Dependencies.HILT_ANDROID)
    kapt(Dependencies.HILT_ANDROID_COMPILER)

    implementation(Dependencies.COROUTINE_CORE)
    implementation(Dependencies.COROUTINE_ANDROID)

    api(Dependencies.RETROFIT)
    api(Dependencies.RETROFIT_JSON)
    api(Dependencies.OK_HTTP_LOGGER)

    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.ROOM_RUNTIME)
    kapt(Dependencies.ROOM_COMPILER)


}