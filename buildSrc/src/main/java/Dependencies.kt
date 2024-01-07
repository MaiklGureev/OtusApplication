object Dependencies {
    object CoreLibraries {
        //implementation 'com.github.bumptech.glide:glide:4.16.0'
        val core = "androidx.core:core-ktx:${Versions.kotlinVersion}"
        val cicerone = "com.github.terrakok:cicerone:${Versions.ciceroneVersion}"
        val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    }

    object NetworkLibraries {
        //    implementation 'com.google.code.gson:gson:2.10.1'
        // compile 'com.squareup.retrofit2:converter-gson:2.3.0'
        val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
        val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    }

    object SupportLibraries {
        val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    }

    object Material {
        val material = "com.google.android.material:material:${Versions.materialVersion}"
    }

    object UI {
        val adaperDelegate =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:${Versions.adaperDelegateVersion}"
        val adaperDelegateViewBinding =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:${Versions.adaperDelegateVersion}"
        val recycler =
            "androidx.recyclerview:recyclerview:${Versions.recyclerVersion}"
    }

    object DI {
        val dagger2 =
            "com.google.dagger:dagger-android:${Versions.daggerVersion}"
        val dagger2Support =
            "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
        val dagger2Processor =
            "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
        val dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    }

    object TestLibraries {
        val jUnit = "junit:junit:${Versions.jUnitVersion}"
        val runnner = "com.android.support.test:runner:${Versions.testRunnerVersion}"
        val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    }
}

