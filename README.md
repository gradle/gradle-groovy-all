Groovy-all for Gradle
=====================

This project generates an uber JAR from Groovy JARs similar to the the `groovy-all.jar` shipped with Groovy prior to version 2.5.

### Steps to publish

- Update the version in `gradle.properties`
- Run [the TC job](https://builds.gradle.org/viewType.html?buildTypeId=GradleGroovy_GradleGroovyAllPublishing) (this job will run `./gradlew publish -Prelease -PgroovyVersion=2.5.7 -PgradleGroovyAllVersion=1.0 -PartifactoryUser=<username> -PartifactoryPassword=<password>`)
