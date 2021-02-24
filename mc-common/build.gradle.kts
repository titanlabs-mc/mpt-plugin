plugins {
    java
    id("com.github.johnrengelman.shadow")
}

repositories {
}

dependencies {
}

tasks.processResources {
    expand("version" to project.version)
}
