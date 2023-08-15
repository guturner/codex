pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
		gradlePluginPortal()
	}
}
rootProject.name = "codex-api"

include(":codex-domain")
project(":codex-domain").projectDir = file("../codex-domain")
