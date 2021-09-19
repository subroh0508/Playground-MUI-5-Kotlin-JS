import io.kvision.jquery.jQuery
import io.kvision.jquery.invoke
import kotlinx.browser.document
import react.Render

interface DomSpec {
    fun testId() = "test"

    fun run(render: Render, testCase: (String) -> Unit) {
        beforeTest()

        react.dom.render(document.getElementById(testId()), handler = render)
        testCase(document.getElementById(testId())?.innerHTML ?: "")

        afterTest()
    }

    fun beforeTest() {
        val fixture = "<div id=\"${testId()}\"></div>"

        document.body?.insertAdjacentHTML("afterbegin", fixture)
    }

    fun afterTest() {
        document.getElementById(testId())?.let { jQuery(it).remove() }
    }
}