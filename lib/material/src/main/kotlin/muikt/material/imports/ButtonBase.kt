@file:JsModule("@mui/material")
@file:JsNonModule

package muikt.material.imports

import muikt.material.ElementClasses
import react.*
import react.dom.FocusEventHandler

external val ButtonBase: ComponentType<ButtonBaseProps>

external interface ButtonBaseProps : PropsWithChildren, PropsWithClassName {
    var action: Ref<ButtonBaseActions>?
    var centerRipple: Boolean
    //var disabled: Boolean
    var disableRipple: Boolean
    var disableTouchRipple: Boolean
    var focusRipple: Boolean
    var focusVisibleClassName: String
    var LinkComponent: ElementType<*>?
    var onFocusVisible: FocusEventHandler<*>?
    // var sx: SxProps
    var tabIndex: Int
    var TouchRippleProps: Props?
}

external interface ButtonBaseActions {
    fun focusVisible()
}

external interface ButtonBaseClasses : ElementClasses {
    var disabled: String?
    var focusVisible: String?
}
