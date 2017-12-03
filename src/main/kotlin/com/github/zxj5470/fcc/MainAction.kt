package com.github.zxj5470.fcc

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager

class MainAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val application = ApplicationManager.getApplication()
        val myComponent = application.getComponent(MainComponent::class.java)
        myComponent.todo(e)
    }
}
