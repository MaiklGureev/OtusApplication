plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinParcelize)
    kotlin(Plugins.kapt)
    kotlin(Plugins.android)
}

android {
    namespace = Config.applicatiınId
    compileSdk = Release.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicatiınId
        minSdk = Release.minSdkVersion
        targetSdk = Release.targetSdkVersion
        versionCode = Release.versionCode
        versionName = Release.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildFeatures {
        viewBinding = true
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
    implementation(Dependencies.CoreLibraries.core)
    implementation(Dependencies.CoreLibraries.cicerone)
    implementation(Dependencies.CoreLibraries.glide)

    implementation(Dependencies.SupportLibraries.appCompat)
    implementation(Dependencies.Material.material)

    implementation(Dependencies.UI.adaperDelegate)
    implementation(Dependencies.UI.adaperDelegateViewBinding)

    implementation(Dependencies.DI.dagger2)
    implementation(Dependencies.DI.dagger2Support)
//
//    annotationProcessor(Dependencies.DI.dagger2Processor)
//    annotationProcessor(Dependencies.DI.dagger2Compiler)
    kapt(Dependencies.DI.dagger2Compiler)
    kapt(Dependencies.DI.dagger2Processor)


    implementation(Dependencies.NetworkLibraries.gson)
    implementation(Dependencies.NetworkLibraries.retrofit)
    implementation(Dependencies.NetworkLibraries.converterGson)
}
