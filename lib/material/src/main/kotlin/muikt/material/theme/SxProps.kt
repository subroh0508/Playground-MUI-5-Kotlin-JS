package muikt.material.theme

import kotlinext.js.jso
import kotlinx.css.CssBuilder
import kotlinx.css.CssValue
import kotlinx.css.RuleContainer
import kotlinx.css.hyphenize

external interface SxProps

operator fun SxProps.set(key: String, value: Any) { asDynamic()[key] = value }

class SxPropsBuilder internal constructor(
    allowClasses: Boolean = true,
    parent: RuleContainer? = null,
) : CssBuilder by CssBuilder(allowClasses = allowClasses, parent = parent) {
    val props: SxProps get(): SxProps = jso {
        declarations.forEach {
            set(it.key.hyphenize(), it.value())
        }

        buildRules(this)
    }

    private fun buildRules(props: SxProps) {
        val resolvedRules = LinkedHashMap<String, CssBuilder>()
        rules.forEach { (selector, passStaticClassesToParent, block) ->
            if (!resolvedRules.containsKey(selector)) {
                resolvedRules[selector] = SxPropsBuilder(
                    allowClasses = false,
                    parent = if (passStaticClassesToParent) this else null,
                )
            }
            val rule = resolvedRules[selector]!!
            rule.block()
        }

        resolvedRules.forEach { props[it.key] = it.value() }

        multiRules.forEach { (selector, passStaticClassesToParent, block) ->
            val blockBuilder = SxPropsBuilder(
                allowClasses = false,
                parent = if (passStaticClassesToParent) this else null,
            ).apply(block)

            props[selector] = blockBuilder.props
        }
    }

    private fun Map.Entry<String, Any>.value() = when (value) {
        is SxPropsBuilder -> (value as SxPropsBuilder).props
        is CssValue -> value.toString()
        else -> value
    }
}

fun SxPropsBuilder.color(v: String) = put("color", v)

