import org.apache.tools.ant.filters.ReplaceTokens

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation(project(":mpt-common"))
    compileOnly("org.spigotmc:spigot-api:1.17-R0.1-SNAPSHOT")
}

tasks.withType<ProcessResources> {
    filter(ReplaceTokens::class, "tokens" to mapOf("version" to version))
}
