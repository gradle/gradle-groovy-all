class GroovyTest {
    @org.junit.Test
    void "test can be compiled and executed"() {
        println "Groovy version: ${GroovySystem.version} at " +
            new Date().format("yyyy-MM-dd")

        def gradleGroovyVersionProps = new Properties()
        gradleGroovyVersionProps.load(
            new StringReader(
                getClass().getResource("/gradle-groovy-all-version.properties").text
            )
        )
        println "Gradle Groovy package version: ${gradleGroovyVersionProps.version}"
    }
}
