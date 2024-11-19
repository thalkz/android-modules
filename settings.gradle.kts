pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Test"

include(":app")

include(":component:one:api")
include(":component:one:bindings")
include(":component:one:core")
include(":component:one:lib")

include(":component:two:api")
include(":component:two:bindings")
include(":component:two:core")
include(":component:two:lib")

include("platform:core")
include("platform:di")
