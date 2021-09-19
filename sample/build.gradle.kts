plugins {
    kotlin("js")
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
                outputFileName = "bundle.js"
            }
        }
    }
}

dependencies {
    implementation(project(":lib:material"))

    val wrapper = Libraries.JsWrappers(kotlinVersion)

    implementation(wrapper.react)
    implementation(wrapper.reactDom)

    implementation(npm("@emotion/react", Libraries.Npm.Emotion.react))
    implementation(npm("@emotion/styled", Libraries.Npm.Emotion.styled))
}
