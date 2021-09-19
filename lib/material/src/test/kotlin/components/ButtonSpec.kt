package components

import DomSpec
import muikt.material.components.ButtonVariant
import muikt.material.components.button
import kotlin.test.Test
import kotlin.test.assertContains

object ButtonSpec : DomSpec {
    @Test
    fun renderDefault() = run({
        button {
            +"BUTTON"
        }
    }) { innerHTML ->
        console.log(innerHTML)
        listOf(
            "button",
            "MuiButton-root",
            "MuiButton-text",
            "MuiButton-textPrimary",
            "MuiButton-sizeMedium",
            "MuiButton-textSizeMedium",
            "MuiButtonBase-root",
        ).forEach { assertContains(innerHTML, it) }
    }

    @Test
    fun renderContained() = run({
        button {
            attrs.variant = ButtonVariant.contained
            +"BUTTON"
        }
    }) { innerHTML ->
        listOf(
            "button",
            "MuiButton-root",
            "MuiButton-contained",
            "MuiButton-containedPrimary",
            "MuiButton-sizeMedium",
            "MuiButton-containedSizeMedium",
            "MuiButtonBase-root",
        ).forEach { assertContains(innerHTML, it) }
    }
}