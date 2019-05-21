Groovy-all for Gradle
=====================

This project generates an uber JAR from Groovy JARs similar to the the `groovy-all.jar` shipped with Groovy prior to version 2.5.

### Steps to publish

- Update `groovyVersion` in `build.gradle`.
- `git tag -a ${tagName} -m 'Upgrade to Groovy X.Y.Z'`
- Run `git describe --dirty --abbrev=7` to verify it outputs `$tagName`, something like `1.1`, not `1.0-9-gbba51f1`.
- `git push --tags`
- Run [the TC job](https://builds.gradle.org/viewType.html?buildTypeId=GradleGroovy_GradleGroovyAllPublishing) (this job will run `./gradlew publish -Prelease -PartifactoryUser=<username> -PartifactoryPassword=<password>`)
