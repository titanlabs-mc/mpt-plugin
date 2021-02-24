plugins {
    java
}

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:6.1.0")
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "com.github.johnrengelman.shadow")

    group = "dev.titanlabs.mpt"
    version = "0.1.0"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("javax.annotation:javax.annotation-api:1.3.2")
        compileOnly("org.projectlombok:lombok:1.18.12")
        annotationProcessor("org.projectlombok:lombok:1.18.12")
    }
}
