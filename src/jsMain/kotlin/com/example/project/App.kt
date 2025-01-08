package com.example.project

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapCssModule
import io.kvision.core.style
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.module
import io.kvision.panel.root
import io.kvision.startApplication
import io.kvision.utils.em
import io.kvision.utils.px



class App : Application() {
    override fun start() {
        root("kvapp") {
            val text = div("Hello world")
            fun a(text: String) = """
                ${text}!
            """.trimIndent()
            text.style {
                fontSize = 70.px
                margin = 2.em
                setStyle("", "")
            }
            button("add !").onClick {
                text.content?.let { text.content = a(it) }
            }
        }
    }
}

fun main() {
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        CoreModule
    )
}
