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

    api(npm("@mui/material", Libraries.Npm.MUI.core))
}
