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
