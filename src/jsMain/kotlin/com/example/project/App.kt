package com.example.project

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapCssModule
import io.kvision.core.*
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.module
import io.kvision.panel.root
import io.kvision.startApplication
import io.kvision.theme.Theme
import io.kvision.theme.ThemeManager
import io.kvision.utils.em
import io.kvision.utils.px

fun Container.countButton() {
    var count = 0
    fun text(count: Int) : String {
        return "Click: $count"
    }
    val btn = button(text(count))
    btn.onClick {
        count++
        btn.text = text(count)
        console.log(btn.text)
    }
}

class App : Application() {
    override fun start() {
        root("kvapp") {
            div {
                style {
                    height = 10.em
                    width = 10.em
                    background = Background(color = Color.name(Col.RED))
                }
            }
            countButton()
            countButton()
            countButton()
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
