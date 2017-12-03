package com.github.zxj5470.fcc

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class FakeCamelBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement,document: Document,quick: Boolean): Array<FoldingDescriptor> {
        val ret=ArrayList<FoldingDescriptor>()


        return ret.toTypedArray()
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = true
    override fun getPlaceholderText(node: ASTNode)= "..."

}