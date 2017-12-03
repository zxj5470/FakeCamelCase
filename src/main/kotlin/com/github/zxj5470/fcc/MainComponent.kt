package com.github.zxj5470.fcc

import com.github.zxj5470.fcc.utils.countTimes
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor

class MainComponent: ApplicationComponent {

    lateinit var editor: Editor
    lateinit var document: Document



    fun todo(event: AnActionEvent) {
        editor = event.getData(PlatformDataKeys.EDITOR) ?: return
        document = editor.document
        val t=document.text.countTimes("\\.[A-Z]")
        println(document.text)
        println(t)
    }


    override fun getComponentName(): String {
        return "Fake Camel Case"
    }

    override fun disposeComponent() {
    }

    override fun initComponent() {
    }

}