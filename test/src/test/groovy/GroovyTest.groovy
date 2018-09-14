class GroovyTest {
    @org.junit.Test
    void "test can be compiled and executed"() {
        println "Groovy version: ${GroovySystem.version} at " +
            new Date().format("yyyy-MM-dd")
    }
}
