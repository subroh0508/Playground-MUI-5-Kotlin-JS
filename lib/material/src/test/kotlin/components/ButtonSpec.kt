package components

import DomSpec
import kotlinx.browser.document
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
        listOf(
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
            "MuiButton-root",
            "MuiButton-contained",
            "MuiButton-containedPrimary",
            "MuiButton-sizeMedium",
            "MuiButton-containedSizeMedium",
            "MuiButtonBase-root",
        ).forEach { assertContains(innerHTML, it) }
    }
}