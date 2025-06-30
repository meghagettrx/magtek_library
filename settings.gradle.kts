pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Required for JitPack-style dependencies
        maven(url = "https://jitpack.io")
        flatDir {
            dirs("mtusdk/libs") // or your correct path to mtusdk.aar
        }
    }
}

rootProject.name = "MagtekWrapper"
include(":mtusdk")
