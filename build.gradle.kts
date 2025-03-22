plugins {
    id("java")
    id("org.flywaydb.flyway") version "9.22.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.h2database:h2:2.3.232")
    implementation("org.flywaydb:flyway-core:11.4.1")
}

tasks.test {
    useJUnitPlatform()
}

flyway {
    url = "jdbc:h2:~/goit_test"
    user = "root"
    password = "12345"
    locations = arrayOf("filesystem:src/main/resources/db/migration")
}