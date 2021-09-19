@file:JsModule("@mui/material")
@file:JsNonModule

package muikt.material.imports

import react.ComponentType
import react.ReactNode

external val Button: ComponentType<ButtonProps>

external interface ButtonProps : ButtonBaseProps {
    var color: String?
    var disableElevation: Boolean
    var disableFocusRipple: Boolean
    var endIcon: ReactNode?
    var fullWidth: Boolean
    var href: String?
    var size: String?
    var startIcon: ReactNode?
    // var sx: SxProps<Theme>
    var variant: String?
}

external interface ButtonClasses : ButtonBaseClasses {
    var text: String?
    var textInherit: String?
    var textPrimary: String?
    var textSecondary: String?
    var outlined: String?
    var outlinedInherit: String?
    var outlinedPrimary: String?
    var outlinedSecondary: String?
    var contained: String?
    var containedInherit: String?
    var containedPrimary: String?
    var containedSecondary: String?
    var disableElevation: String?
    var colorInherit: String?
    var textSizeSmall: String?
    var textSizeMedium: String?
    var textSizeLarge: String?
    var outlinedSizeSmall: String?
    var outlinedSizeMedium: String?
    var outlinedSizeLarge: String?
    var containedSizeSmall: String?
    var containedSizeMedium: String?
    var containedSizeLarge: String?
    var sizeSmall: String?
    var sizeMedium: String?
    var sizeLarge: String?
    var fullWidth: String?
    var startIcon: String?
    var endIcon: String?
    var iconSizeSmall: String?
    var iconSizeMedium: String?
    var iconSizeLarge: String?
}
