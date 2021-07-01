import org.apache.tools.ant.filters.ReplaceTokens

repositories {
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation(project(":mpt-common"))
    compileOnly("net.md-5:bungeecord-api:1.16-R0.4")
}

tasks.withType<ProcessResources> {
    filter(ReplaceTokens::class, "tokens" to mapOf("version" to version))
}
