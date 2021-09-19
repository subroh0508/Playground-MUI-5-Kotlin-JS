import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window

@JsModule("@emotion/react")
@JsNonModule
external val emotionReactModule: dynamic

@JsModule("@emotion/styled")
@JsNonModule
external val emotionStyledModule: dynamic

fun main() {
    window.onload = {
        emotionReactModule
        emotionStyledModule

        render(document.getElementById("root")) {
            child(Welcome)
        }
    }
}
