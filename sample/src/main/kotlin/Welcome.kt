import kotlinx.css.Color
import kotlinx.css.borderColor
import kotlinx.css.px
import kotlinx.css.width
import muikt.material.components.ButtonColor
import muikt.material.components.ButtonVariant
import muikt.material.components.button
import muikt.material.theme.color
import react.*
import react.dom.attrs
import react.dom.onClick

val Welcome = functionComponent<Props> {
    var count by useState(0)

    button {
        attrs.variant = ButtonVariant.contained

        +"$count time(s) PUSHED"
    }
}

