plugins {
    id("com.android.library")

    id(Plugins.kotlinParcelize)
    kotlin(Plugins.kapt)
    kotlin(Plugins.android)
}

android {
    namespace = "ru.gureev.core"
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
    buildFeatures {
        viewBinding = true
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
    implementation(project(mapOf("path" to ":design_system")))

    implementation(Dependencies.CoreLibraries.core)
    implementation(Dependencies.CoreLibraries.cicerone)
    implementation(Dependencies.CoreLibraries.lifecycleLiveData)
    implementation(Dependencies.CoreLibraries.lifecycleViewModelScope)
    implementation(Dependencies.CoreLibraries.lifecycleLifecycleScope)
//    implementation(Dependencies.CoreLibraries.glide)
//
    implementation(Dependencies.SupportLibraries.appCompat)
    implementation(Dependencies.Material.material)
//
//    implementation(Dependencies.UI.adaperDelegate)
//    implementation(Dependencies.UI.adaperDelegateViewBinding)

    implementation(Dependencies.DI.dagger2)
    implementation(Dependencies.DI.dagger2Support)

    kapt(Dependencies.DI.dagger2Compiler)
    kapt(Dependencies.DI.dagger2Processor)


//    implementation(Dependencies.NetworkLibraries.gson)
//    implementation(Dependencies.NetworkLibraries.retrofit)
//    implementation(Dependencies.NetworkLibraries.converterGson)
}
