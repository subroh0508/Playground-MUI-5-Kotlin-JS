plugins {
    kotlin("js")
}

kotlin {
    js { browser() }
}

dependencies {
    val wrapper = Libraries.JsWrappers(kotlinVersion)

    api(wrapper.react)
    api(wrapper.reactDom)
    api(wrapper.css)
    api(wrapper.cssType)

    api(npm("@emotion/react", Libraries.Npm.Emotion.react))
    api(npm("@emotion/styled", Libraries.Npm.Emotion.styled))
}
