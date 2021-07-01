import org.apache.tools.ant.filters.ReplaceTokens

repositories {
    mavenCentral()
    maven("https://repo.velocitypowered.com/releases/")
    maven("https://libraries.minecraft.net/")
    maven("https://repo.spongepowered.org/maven")
}

dependencies {
    implementation(project(":mpt-common"))
    compileOnly ("com.velocitypowered:velocity-api:1.1.8")
    annotationProcessor ("com.velocitypowered:velocity-api:1.1.8")
}


tasks.withType<ProcessResources> {
    from(java.sourceSets.getByName("main").allSource)
    inputs.property("version", version)
    filter(ReplaceTokens::class, "tokens" to mapOf("version" to version))
    into("$buildDir/src")
}