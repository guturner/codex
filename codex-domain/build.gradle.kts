import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.9.0"
}

group = "io.guy.home"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_19
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.slf4j:slf4j-api:2.0.5")
	implementation("ch.qos.logback:logback-core:1.4.7")
	implementation("ch.qos.logback:logback-classic:1.4.7")

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
