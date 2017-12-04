package com.github.zxj5470.fcc.utils

/**
 * @author:zxj5470
 */

fun String.findIndexes(): List<Int> {
    val list = ArrayList<Int>()
    var findDot = false
    var findUpperCase = false
    var tempIndex = 0

    for (i in this.indices) {
        when (this[i]) {
            '.' -> {
                if (findDot) {
                    findUpperCase = false
                }
                if (this[i + 1].isUpperCase()) {//that is the reason why I aborted to use .forEach iterator
                    findUpperCase = true
                    tempIndex = i + 1
                }
            }
            '(' -> {
                if (findUpperCase && tempIndex != -1) {
                    list.add(tempIndex)
                    findUpperCase = false
                    findDot = false
                }

            }
            ' ', ';', '\n', '\r' -> {
                findDot = false
                tempIndex = -1
            }
        }
    }



    return list
}