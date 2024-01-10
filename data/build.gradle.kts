plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin(Plugins.kapt)
}

android {
    namespace = "ru.gureev.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(project(mapOf("path" to ":models")))

    implementation(Dependencies.DI.dagger2)
    kapt(Dependencies.DI.dagger2Compiler)
    kapt(Dependencies.DI.dagger2Processor)

    implementation(Dependencies.CoreLibraries.room)
    kapt(Dependencies.CoreLibraries.roomCompiler)

    implementation(Dependencies.NetworkLibraries.retrofit)

    testCompileOnly("org.mockito:mockito-core:2.6.3")
    androidTestCompileOnly("'org.mockito:mockito-android:2.6.3")
}
