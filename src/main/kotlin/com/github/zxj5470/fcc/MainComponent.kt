package com.github.zxj5470.fcc

/**
 * @author:zxj5470
 *
 * @thanks_to:vkurdin/idea-php-lambda-folding
 */
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
        val returnList=document.text.findIndexes()

        returnList.forEach(System.out::println)
    }

    private fun String.findIndexes():List<Int>{
        val str=this
        val list=ArrayList<Int>()
        var flag=false;
        str.forEachIndexed { index, c ->
                when{
                    c=='.'->{
                        flag=true
                    }
                    c.isUpperCase()-> {
                        if(flag){
                            list.add(index)
                            flag=false
                        }
                    }
                    else-> {
                        flag=false
                    }
                }
        }
        return list
    }


    override fun getComponentName(): String {
        return "FakeCamelCase"
    }

    override fun disposeComponent() {
    }

    override fun initComponent() {
    }

}