import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.2"
	kotlin("jvm") version "1.9.0"
	kotlin("plugin.spring") version "1.9.0"
}

group = "io.guy.home"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_19
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	api(project(":codex-domain"))

	implementation("org.slf4j:slf4j-api:2.0.5")
	implementation("ch.qos.logback:logback-core:1.4.7")
	implementation("ch.qos.logback:logback-classic:1.4.7")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	api("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.testcontainers:testcontainers:1.19.0")
	testImplementation("org.testcontainers:mongodb:1.19.0")
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "19"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
