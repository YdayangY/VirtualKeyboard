plugins {
    id("java")
}

group = "org.virtualkeyboard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.github.kwhat:jnativehook:2.2.2")
}

tasks.test {
    useJUnitPlatform()
}