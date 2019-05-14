import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.CheckoutMode
import jetbrains.buildServer.configs.kotlin.v2018_2.DslContext
import jetbrains.buildServer.configs.kotlin.v2018_2.ParameterDisplay
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

open class GradleGroovyAllBase : BuildType() {
    init {
        vcs {
            root(DslContext.settingsRoot)

            checkoutMode = CheckoutMode.ON_SERVER
            cleanCheckout = true
        }

        requirements {
            contains("teamcity.agent.jvm.os.name", "Linux")
        }
    }
}


object GradleGroovyAllPublishing : GradleGroovyAllBase() {
    init {
        name = "Publish Gradle Groovy-all"
        description = "Publish Gradle's groovy-all"

        artifactRules = "build/reports/** => reports"

        params {
            text("ARTIFACTORY_USERNAME", "bot-build-tool", allowEmpty = true)
            password("ARTIFACTORY_PASSWORD", "credentialsJSON:2b7529cd-77cd-49f4-9416-9461f6ac9018", display = ParameterDisplay.HIDDEN)
        }

        steps {
            gradle {
                tasks = "clean publish"
                gradleParams = "-Prelease -PartifactoryUser=%ARTIFACTORY_USERNAME% -PartifactoryPassword=%ARTIFACTORY_PASSWORD%"
            }
        }
    }
}

object GradleGroovyAllSanityCheck : GradleGroovyAllBase() {
    init {
        name = "Gradle Groovy-all Sanity Check"

        triggers {
            vcs {
                branchFilter = """
            +:<default>
            +:refs/heads/*
        """.trimIndent()
            }
        }

        artifactRules = "build/reports/** => reports"

        steps {
            gradle {
                tasks = "clean check"
            }
        }
    }
}
