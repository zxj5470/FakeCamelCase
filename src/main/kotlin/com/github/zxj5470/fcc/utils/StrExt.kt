package com.github.zxj5470.fcc.utils

/**
 * @author:zxj5470
 */
fun String.countTimes(regex: String): Int {
    var count = 0
    var temp = -1
    var b: Int
    this.forEachIndexed { index, _ ->
        b = this.indexOf(regex, index)
        if (b > temp) {
            temp = b
            count++
        }
    }
    return count
}