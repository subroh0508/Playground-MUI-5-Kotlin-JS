import muikt.material.ButtonVariant
import muikt.material.button
import react.*
import react.dom.attrs
import react.dom.onClick

val Welcome = functionComponent<Props> {
    var count by useState(0)

    button {
        attrs {
            variant = ButtonVariant.contained
            onClick = { count++ }
        }

        +"$count time(s) PUSHED"
    }
}

