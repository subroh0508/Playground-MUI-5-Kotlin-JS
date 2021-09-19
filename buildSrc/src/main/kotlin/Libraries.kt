@Suppress("unused")
object Libraries {
    class JsWrappers(kotlinVersion: String) {
        private val wrappersBuild = "pre.246-kotlin-$kotlinVersion"
        private val prefix = "org.jetbrains.kotlin-wrappers:kotlin"

        private val reactVersion = "${Npm.react}-$wrappersBuild"
        val react = "$prefix-react:$reactVersion"
        val reactDom = "$prefix-react-dom:$reactVersion"

        private val cssVersion = "1.0.0-$wrappersBuild"
        val css = "$prefix-css:$cssVersion"

        private val cssTypeVersion = "3.0.9-$wrappersBuild"
        val cssType = "$prefix-csstype:$cssTypeVersion"

        private val extensionsVersion = "1.0.1-$wrappersBuild"
        val extensions = "$prefix-extensions:$extensionsVersion"
    }

    object Npm {
        const val react = "17.0.2"

        object MUI {
            const val core = "^5.0.0"
            const val lab = "^5.0.0-alpha.46"
        }

        object Emotion {
            const val react = "^11.4.1"
            const val styled = "^11.3.0"
        }
    }
}
