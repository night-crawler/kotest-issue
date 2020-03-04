plugins {
    id("org.jetbrains.kotlin.js") version "1.3.70"
//    id("org.jetbrains.kotlin.multiplatform") version "1.3.70"
    kotlin("plugin.serialization") version "1.3.70"
    id("com.dorongold.task-tree") version "1.5"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val kotlinVersion: String by extra
val reactVersion: String by extra
val extensionsVersion: String by extra
val reactRouterDomVersion: String by extra
val reactReduxVersion: String by extra
val reduxVersion: String by extra
val styledVersion: String by extra
val ktorClientVersion: String by extra

repositories {
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { url = uri("https://kotlin.bintray.com/kotlin-js-wrappers/") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx.html/") }
    maven { url = uri("https://dl.bintray.com/cfraser/muirwik") }
}

kotlin {
    target {
        browser {
            @UseExperimental(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDceDsl::class)
            dceTask {
                // dceOptions
                keep("ktor-ktor-io.\$\$importsForInline\$\$.ktor-ktor-io.io.ktor.utils.io")
            }
            compilations.all {
                kotlinOptions {
                    friendModulesDisabled = false
                    metaInfo = true
                    sourceMap = true
                    sourceMapEmbedSources = "always"
                    moduleKind = "commonjs"
                    main = "call"
                }
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }

    sourceSets {
        named("main") {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains:kotlin-react:$reactVersion-kotlin-$kotlinVersion")
                implementation("org.jetbrains:kotlin-react-dom:$reactVersion-kotlin-$kotlinVersion")
                implementation(npm("react", reactVersion.split("-").first()))
                implementation(npm("react-dom", reactVersion.split("-").first()))
                implementation(npm("core-js", "3.6.4"))
            }
        }

        named("test") {
            dependencies {
                implementation(npm("core-js", "3.6.4"))
                implementation(kotlin("stdlib-js"))
                implementation(kotlin("test-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.3")
                implementation("io.kotest:kotest-core:4.0.0-BETA1")
                implementation("io.kotest:kotest-core:4.0.0-BETA1")
                implementation("io.kotest:kotest-assertions:4.0.0-BETA1")
            }
        }
    }
}