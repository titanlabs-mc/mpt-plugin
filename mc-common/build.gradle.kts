plugins {
    java
    id("com.github.johnrengelman.shadow")
}

repositories {
}

dependencies {
    compileOnly("org.yaml:snakeyaml:1.28");
}

tasks.processResources {
    expand("version" to project.version)
}
