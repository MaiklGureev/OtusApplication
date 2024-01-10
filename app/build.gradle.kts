import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import java.io.ByteArrayOutputStream

plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinParcelize)
    kotlin(Plugins.kapt)
    kotlin(Plugins.android)
}

val minorVersionCode: Int by lazy {
    val stdout = ByteArrayOutputStream()
    rootProject.exec {
        commandLine("git", "rev-list", "--count", "HEAD")
        standardOutput = stdout
    }
    stdout.toString().trim().toIntOrNull() ?: 0
}

android {
    namespace = Config.applicatiınId
    compileSdk = Release.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicatiınId
        minSdk = Release.minSdkVersion
        targetSdk = Release.targetSdkVersion
        versionCode = minorVersionCode
        versionName = Release.versionName.format(minorVersionCode)

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    signingConfigs {
        create("release") {
            storeFile = file("simple_keystore.jks")
            storePassword = "123321"
            keyAlias = "key0"
            keyPassword = "123321"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }

    applicationVariants.all {
        val variant = this
        variant.outputs.map { it as BaseVariantOutputImpl }
            .forEach { output ->
                output.outputFileName = output.outputFileName
                    .replace("app-", "Application-")
                    .replace(".apk", "-${Release.versionName.format(minorVersionCode)}.apk")
                    .replace("-prod-release-", "-")
            }
    }

    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
            preferProjectModules()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    // Include KSP generated files
    kotlin {
        sourceSets.all {
            kotlin.srcDirs("build/generated/ksp/$name/kotlin")
        }
    }
}

dependencies {

    implementation(project(mapOf("path" to ":features:feature_0:api")))
    implementation(project(mapOf("path" to ":features:feature_0:impl")))

    implementation(project(mapOf("path" to ":features:feature_1:api")))
    implementation(project(mapOf("path" to ":features:feature_1:impl")))

    implementation(project(mapOf("path" to ":features:feature_2:api")))
    implementation(project(mapOf("path" to ":features:feature_2:impl")))

    implementation(Dependencies.CoreLibraries.core)
    implementation(Dependencies.CoreLibraries.securityCrypto)
    implementation(Dependencies.CoreLibraries.cicerone)
    implementation(Dependencies.CoreLibraries.glide)

    implementation(Dependencies.CoreLibraries.room)
    kapt(Dependencies.CoreLibraries.roomCompiler)

    implementation(Dependencies.SupportLibraries.appCompat)
    implementation(Dependencies.Material.material)

    implementation(Dependencies.UI.adaperDelegate)
    implementation(Dependencies.UI.adaperDelegateViewBinding)

    implementation(Dependencies.DI.dagger2)
    implementation(Dependencies.DI.dagger2Support)

    kapt(Dependencies.DI.dagger2Compiler)
    kapt(Dependencies.DI.dagger2Processor)

    implementation(Dependencies.NetworkLibraries.gson)
    implementation(Dependencies.NetworkLibraries.retrofit)
    implementation(Dependencies.NetworkLibraries.loggingInterceptor)
    implementation(Dependencies.NetworkLibraries.converterGson)
}
