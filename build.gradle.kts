import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.launchcodeconsulting"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-maven-noarg")
	implementation("com.expediagroup", "graphql-kotlin-spring-server", "6.1.0")
	implementation("mysql:mysql-connector-java")
	// Logging
	implementation("org.springframework.boot", "spring-boot-starter-log4j2")
	implementation("org.apache.logging.log4j", "log4j-api-kotlin", "1.2.0")
	// Required for Log4j2 to read yaml config
	implementation("com.fasterxml.jackson.dataformat", "jackson-dataformat-yaml", "2.13.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations.implementation {
	// Remove Logback dependency since it's not used and conflicts with Log4j2
	exclude("org.springframework.boot", "spring-boot-starter-logging")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
