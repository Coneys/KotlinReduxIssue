plugins {
    kotlin("js") version "1.7.20"
}

group = "me.rafal_y8v25d0"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.9.3-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:4.1.2-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:7.2.6-pre.346")
}

kotlin {
    js(org.jetbrains.kotlin.gradle.plugin.KotlinJsCompilerType.LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}