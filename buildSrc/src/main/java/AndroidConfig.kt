object AndroidConfig {
    const val COMPILE_SDK = 30
    const val MIN_SDK = 16
    const val TARGET_SDK = 30
    const val BUILD_TOOLS_VERSION = "30.0.1"

    const val ID = "com.example.weather"
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}


interface BuildType {
    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val isShrinkResources: Boolean
    val isDebuggable: Boolean
    val versionNameSuffix: String
}

object BuildTypeDebug: BuildType {
    override val isMinifyEnabled = false
    override val isShrinkResources = false
    override val isDebuggable = false
    override val versionNameSuffix = "-DEBUG"
}

object BuildTypeRelease: BuildType {
    override val isMinifyEnabled = true
    override val isShrinkResources = true
    override val isDebuggable = true
    override val versionNameSuffix = ""
}

