plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.thalkz.component.two.bindings"
    compileSdk = 34

    defaultConfig {
        minSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    api(project(":component:two:api"))
    api(project(":component:two:lib"))

    implementation(project(":component:two:core"))

    // Necessary here only because there is no dependency injection framework
    // With Hilt, there will be no need for this dependency
    implementation(project(":component:one:bindings"))

    implementation(project(":platform:core"))
}
