package muikt.material

import kotlinext.js.jso
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import react.*
import react.dom.DOMProps
import react.dom.RDOMBuilderImpl
import react.dom.setProp
import kotlin.reflect.KProperty

abstract class MaterialElementBuilder<T: Tag, C: ElementClasses>(
    private val type: ComponentType<*>,
    factory: (TagConsumer<Unit>) -> T,
) : RDOMBuilderImpl<T>(factory) {
    operator fun Tag.getValue(thisRef: Any?, property: KProperty<*>) = get(property.name)
    operator fun Tag.setValue(thisRef: Any?, property: KProperty<*>, value: Any?) { setProp(property.name, value) }

    inline operator fun <reified E: Enum<E>> Tag.getValue(
        thisRef: Any?,
        property: KProperty<*>,
    ): E? = (get(property.name) as? String)?.let { enumValueOf<E>(it) }
    operator fun <E: Enum<*>> Tag.setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: E,
    ) { setProp(property.name, value.name) }

    fun Tag.classes(block: C.() -> Unit) { set("classes", jso(block)) }

    @Suppress("UNCHECKED_CAST", "UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
    override fun create() = createElement(type as ComponentType<DOMProps>, domProps, *childList.toTypedArray())
}
