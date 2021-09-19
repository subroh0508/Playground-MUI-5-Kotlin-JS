package muikt.material

import kotlinx.html.BUTTON
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import muikt.material.imports.Button
import muikt.material.imports.ButtonClasses
import react.RBuilder
import react.ReactNode

fun RBuilder.button(
    block: ButtonElementBuilder<BUTTON>.() -> Unit,
) { child(buttonElement(block)) }

fun <T: Tag> RBuilder.button(
    block: ButtonElementBuilder<T>.() -> Unit,
    factory: (TagConsumer<Unit>) -> T,
) { child(buttonElement(block, factory)) }

fun buttonElement(
    block: ButtonElementBuilder<BUTTON>.() -> Unit,
) = buttonElement(block) { BUTTON(mapOf(), it) }

fun <T: Tag> buttonElement(
    block: ButtonElementBuilder<T>.() -> Unit,
    factory: (TagConsumer<Unit>) -> T,
) = ButtonElementBuilder(factory).apply(block).create()

class ButtonElementBuilder<T: Tag> internal constructor(
    factory: (TagConsumer<Unit>) -> T,
) : ButtonBaseElementBuilder<T, ButtonClasses>(factory, Button) {
    var Tag.color: ButtonColor? by attrs
    var Tag.disableElevation: Boolean by attrs
    var Tag.disableFocusRipple: Boolean by attrs
    var Tag.endIcon: ReactNode? by attrs
    var Tag.fullWidth: Boolean by attrs
    var Tag.href: String? by attrs
    var Tag.size: ButtonSize? by attrs
    var Tag.startIcon: ReactNode? by attrs
    // var Tag.sx: SxProps<Theme> by attrs
    var Tag.variant: ButtonVariant? by attrs
}

enum class ButtonColor { inherit, primary, secondary, success, error, info, warning }
enum class ButtonSize { small, medium, large }
enum class ButtonVariant { contained, outlined, text }
