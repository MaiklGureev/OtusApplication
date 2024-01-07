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
    }
}

rootProject.name = "OtusApp"
include(":app")


include(":features:feature_0")
include(":features:feature_1")
include(":features:feature_2")
