plugins {
    kotlin("jvm") version "1.9.20"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src/main")
        }

        test {
            java.srcDirs("src/test")
        }
    }

    wrapper {
        gradleVersion = "8.4"
    }
}
