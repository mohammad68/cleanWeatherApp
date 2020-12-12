// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Build.GRADLE_BUILD_TOOLS)
        classpath(Build.KOTLIN_GRADLE_PLUGIN)
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