package com.github.zxj5470.fcc

import com.github.zxj5470.fcc.utils.findIndexes
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class FakeCamelBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val ret = ArrayList<FoldingDescriptor>()
        val content = root.text
        val indices = content.findIndexes()
//        println(root.language.javaClass) //to print the type `class com.intellij.openapi.fileTypes.PlainTextLanguage`
        indices.forEach {
            val end = it + 1
            val s = content.subSequence(it, end).toString().toLowerCase()
            ret.add(getFold(root, TextRange.from(it, 1), s))
        }
//        count how many function matched...
        println(ret.size)

        return ret.toTypedArray()
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = true

    override fun getPlaceholderText(node: ASTNode) = "..."


    private fun getFold(elem: PsiElement, range: TextRange, placeHolder: String) =
            object : FoldingDescriptor(elem, range) {
                override fun getPlaceholderText(): String? {
                    return placeHolder
                }
            }
}