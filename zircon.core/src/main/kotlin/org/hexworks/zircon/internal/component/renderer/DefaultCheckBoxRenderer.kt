package org.hexworks.zircon.internal.component.renderer

import org.hexworks.zircon.api.component.CheckBox
import org.hexworks.zircon.api.component.renderer.ComponentRenderContext
import org.hexworks.zircon.api.component.renderer.ComponentRenderer
import org.hexworks.zircon.api.graphics.SubTileGraphics
import org.hexworks.zircon.internal.component.impl.DefaultCheckBox.CheckBoxState.*

class DefaultCheckBoxRenderer : ComponentRenderer<CheckBox>() {

    override fun render(tileGraphics: SubTileGraphics, context: ComponentRenderContext<CheckBox>) {
        val style = context.componentStyle.currentStyle()
        tileGraphics.applyStyle(style)
        val checkBoxState = context.component.state
        val text = context.component.text
        val maxTextLength = tileGraphics.width - BUTTON_WIDTH - 1
        val clearedText = if (text.length > maxTextLength) {
            text.substring(0, maxTextLength - 3).plus("...")
        } else {
            text
        }
        tileGraphics.putText("${STATES[checkBoxState]!!} $clearedText")
    }

    companion object {

        private const val CHECKING_BUTTON = "[+]"
        private const val UNCHECKING_BUTTON = "[-]"
        private const val CHECKED_BUTTON = "[*]"
        private const val UNCHECKED_BUTTON = "[ ]"
        private const val BUTTON_WIDTH = CHECKING_BUTTON.length

        private val STATES = mapOf(
                Pair(UNCHECKED, UNCHECKED_BUTTON),
                Pair(CHECKING, CHECKING_BUTTON),
                Pair(CHECKED, CHECKED_BUTTON),
                Pair(UNCHECKING, UNCHECKING_BUTTON))

    }
}
