plugins {
    id("com.android.library")
    id(Plugins.kotlinParcelize)
    kotlin(Plugins.kapt)
    kotlin(Plugins.android)
}

android {
    namespace = "ru.gureev.feature_0"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(project(mapOf("path" to ":core")))
    api(project(mapOf("path" to ":data")))
    api(project(mapOf("path" to ":domain")))
    api(project(mapOf("path" to ":models")))
    api(project(mapOf("path" to ":design_system")))

    implementation(project(mapOf("path" to ":features:feature_1:api")))

    implementation(Dependencies.CoreLibraries.core)
    implementation(Dependencies.CoreLibraries.cicerone)
    implementation(Dependencies.NetworkLibraries.retrofit)

    implementation(Dependencies.UI.recycler)
    implementation(Dependencies.UI.adaperDelegate)
    implementation(Dependencies.UI.adaperDelegateViewBinding)

    implementation(Dependencies.DI.dagger2)
    implementation(Dependencies.DI.dagger2Support)

    kapt(Dependencies.DI.dagger2Compiler)
    kapt(Dependencies.DI.dagger2Processor)

}
