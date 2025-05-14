plugins {
    id("java")
}

group = "band.kessoku.tachyon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation("club.snowlyicewolf:amarok-json-for-java:1.7.8")
    implementation("it.unimi.dsi:fastutil:8.5.15")
    compileOnly("org.jetbrains:annotations:26.0.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}