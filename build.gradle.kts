// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Build.build_tools_gradle)
        classpath(Build.kotlin_build_plugin)
    }
}

allprojects {
    repositories {
        jcenter()
        maven(url = Repositories.maven_google)
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}