Groovy-all for Gradle
=====================

This project generates an uber JAR from Groovy JARs similar to the the `groovy-all.jar` shipped with Groovy prior to version 2.5.

### Steps to publish

- Update `groovyVersion` in `build.gradle` or add a parameter `-PgroovyVersion=X`.
- To release a version, run `./gradlew publish -Prelease`
