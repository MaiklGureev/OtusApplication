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

include(":core")
include(":data")
include(":domain")
include(":models")
include(":design_system")
include(":delegates")

include(":features:feature_0")
include(":features:feature_0:api")
include(":features:feature_0:impl")

include(":features:feature_1")
include(":features:feature_1:api")
include(":features:feature_1:impl")

include(":features:feature_2")
include(":features:feature_2:api")
include(":features:feature_2:impl")

