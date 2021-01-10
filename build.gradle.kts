// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(GradlePlugin.GRADLE_BUILD_TOOLS)
        classpath(GradlePlugin.KOTLIN_GRADLE_PLUGIN)
        classpath(GradlePlugin.DAGGER_HILT_PLUGIN)
    }
}

allprojects {
    repositories {
        jcenter()
        maven(url = Repositories.MAVEN_GOOGLE)
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}