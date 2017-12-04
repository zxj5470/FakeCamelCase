package com.github.zxj5470.fcc

/**
 * @author:zxj5470
 *
 * @thanks_to:vkurdin/idea-php-lambda-folding
 */
import com.github.zxj5470.fcc.utils.findIndexes
import com.intellij.lang.folding.FoldingBuilderEx
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
        val psi=event.getData(PlatformDataKeys.PSI_FILE)?:return
        FakeCamelBuilder().buildFoldRegions(psi,document,true)
    }




    override fun getComponentName(): String {
        return "FakeCamelCase"
    }

    override fun disposeComponent() {
    }

    override fun initComponent() {
    }

}