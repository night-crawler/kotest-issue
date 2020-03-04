package org.example

import react.dom.h1
import react.dom.render
import kotlin.browser.document


fun main() {
    val rootElement = document.getElementById("root") ?: return

    render(rootElement) {
        h1 {
            +"sample"
        }
    }
}
