plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
	id("maven-publish") // เพิ่ม plugin สำหรับการเผยแพร่
}

group = "com.dependency"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

publishing {
	publications {
		create<MavenPublication>("catalog") {
			// ใช้ชื่อ component ที่ตรงกับ versionCatalog ของคุณ
			from(components["java"]) // ปรับให้ตรงกับ component ที่ต้องการเผยแพร่
			artifactId = "my-version-catalog"
		}
	}

	repositories {
		maven {
			name = "mavenCentral"
			url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
			credentials {
				username = System.getenv("OSSRH_USERNAME") // อ่านจาก environment variables
				password = System.getenv("OSSRH_PASSWORD")
			}
		}
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
