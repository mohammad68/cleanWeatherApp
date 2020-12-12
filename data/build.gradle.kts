
plugins {
    id ("com.android.library")
    id ("kotlin-android")
}

dependencies {
    implementation(Dependencies.KOTLIN_STANDARD_LIBRARY)
    implementation(project(ProjectModule.DOMAIN))
}