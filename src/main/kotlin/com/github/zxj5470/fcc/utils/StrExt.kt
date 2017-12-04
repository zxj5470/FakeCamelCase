package com.github.zxj5470.fcc.utils

/**
 * @author:zxj5470
 */

fun String.findIndexes():List<Int>{
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