package muikt.material.components

import muikt.material.imports.ButtonBase
import kotlinx.html.BUTTON
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import muikt.material.imports.ButtonBaseActions
import muikt.material.imports.ButtonBaseClasses
import react.*
import react.dom.FocusEventHandler

fun RBuilder.buttonBase(
    block: ButtonBaseElementBuilder<BUTTON, ButtonBaseClasses>.() -> Unit,
) { child(buttonBaseElement(block)) }

fun <T: Tag> RBuilder.buttonBase(
    block: ButtonBaseElementBuilder<T, ButtonBaseClasses>.() -> Unit,
    factory: (TagConsumer<Unit>) -> T,
) { child(buttonBaseElement(block, factory)) }

fun buttonBaseElement(
    block: ButtonBaseElementBuilder<BUTTON, ButtonBaseClasses>.() -> Unit,
) = buttonBaseElement(block) { BUTTON(mapOf(), it) }

fun <T: Tag> buttonBaseElement(
    block: ButtonBaseElementBuilder<T, ButtonBaseClasses>.() -> Unit,
    factory: (TagConsumer<Unit>) -> T,
) = ButtonBaseElementBuilder<T, ButtonBaseClasses>(factory).apply(block).create()

open class ButtonBaseElementBuilder<T: Tag, C: ButtonBaseClasses> internal constructor(
    factory: (TagConsumer<Unit>) -> T,
    type: ComponentType<*> = ButtonBase,
) : MaterialElementBuilder<T, C>(type, factory) {
    var Tag.onFocusVisible: FocusEventHandler<*>? by attrs
    var Tag.action: Ref<ButtonBaseActions>? by attrs
    var Tag.centerRipple: Boolean by attrs
    var Tag.disabled: Boolean by attrs
    var Tag.disableRipple: Boolean by attrs
    var Tag.disableTouchRipple: Boolean by attrs
    var Tag.focusRipple: Boolean by attrs
    var Tag.focusVisibleClassName: String by attrs
    var Tag.LinkComponent: ElementType<*>? by attrs
    // var Tag.sx: SxProps by attrs
    var Tag.tabIndex: Int by attrs
    var Tag.TouchRippleProps: Props? by attrs
}
