plugins {
    kotlin("js")
}

kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useChrome()
                }
            }
        }
    }
}

dependencies {
    val wrapper = Libraries.JsWrappers(kotlinVersion)

    api(wrapper.react)
    api(wrapper.reactDom)
    api(wrapper.css)

    api(npm("@mui/material", Libraries.Npm.MUI.core))

    testImplementation(kotlinTestJs)
    testImplementation(Libraries.jQuery)

    testImplementation(npm("@emotion/react", Libraries.Npm.Emotion.react))
    testImplementation(npm("@emotion/styled", Libraries.Npm.Emotion.styled))
}
