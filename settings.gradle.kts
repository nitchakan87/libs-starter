
rootProject.name = "starter"
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // Define versions
            version("kotlin", "1.8.22")
            version("spring_boot", "3.1.7")
            version("jackson", "2.15.2")
            version("slf4j", "2.0.7")

            // Define libraries
            library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin")
            library("spring-boot-starter", "org.springframework.boot", "spring-boot-starter").versionRef("spring_boot")
            library("spring-boot-starter-web", "org.springframework.boot", "spring-boot-starter-web").versionRef("spring_boot")
            library("jackson-module-kotlin", "com.fasterxml.jackson.module", "jackson-module-kotlin").versionRef("jackson")
            library("slf4j-api", "org.slf4j", "slf4j-api").versionRef("slf4j")

            // Define plugins
            plugin("spring-boot", "org.springframework.boot").versionRef("spring_boot")
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
        }
    }
}


