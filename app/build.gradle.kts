plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

android {
    namespace = "com.magtek.mtusdk"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.magtek.mtusdk"
        minSdk = 24
        targetSdk = 35
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
    buildFeatures {
        compose = true
    }
}

//group = "com.magtek"
//version = "1.0.0"
//
//publishing {
//    publications {
//        create<MavenPublication>("aar") {
//            groupId = "com.magtek"
//            artifactId = "mtusdk"
//            version = "1.0.0"
//
//            artifact(file("libs/mtusdk.aar")) {
//                extension = "aar"
//            }
//        }
//    }
//
//    repositories {
//        maven {
//            name = "localRepo"
//            url = uri("${rootProject.buildDir}/repo")
//        }
//    }
//}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}


group = "com.github.meghagettrx"
version = "1.0.0"

publishing {
    publications {
        create<MavenPublication>("aar") {
            groupId = "com.github.meghagettrx"
            artifactId = "mtusdk"
            version = "1.0.0"

            artifact(file("libs/mtusdk.aar")) {
                extension = "aar"
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/meghagettrx/magtek_library")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}