object Dependencies {
    object CoreLibraries {
        const val core = "androidx.core:core-ktx:${Versions.kotlinVersion}"
        const val cicerone = "com.github.terrakok:cicerone:${Versions.ciceroneVersion}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
        const val securityCrypto = "androidx.security:security-crypto:${Versions.securityCryptoVersion}"

        const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
        const val roomCommon = "androidx.room:room-common:${Versions.roomVersion}"

        const val lifecycleLifecycleScope = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val lifecycleViewModelScope = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    }

    object NetworkLibraries {
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
    }

    object SupportLibraries {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    }

    object Material {
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
    }

    object UI {
        const val adaperDelegate =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:${Versions.adaperDelegateVersion}"
        const val adaperDelegateViewBinding =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:${Versions.adaperDelegateVersion}"
        const val recycler =
            "androidx.recyclerview:recyclerview:${Versions.recyclerVersion}"
    }

    object DI {
        const val dagger2 =
            "com.google.dagger:dagger-android:${Versions.daggerVersion}"
        const val dagger2Support =
            "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
        const val dagger2Processor =
            "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
        const val dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    }

    object TestLibraries {
        const val jUnit = "junit:junit:${Versions.jUnitVersion}"
        const val runnner = "com.android.support.test:runner:${Versions.testRunnerVersion}"
        const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    }
}

