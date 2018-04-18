package me.camdenorrb.legup.math

import me.camdenorrb.legup.math.ext.isPostFix
import me.camdenorrb.legup.math.token.impl.NumericToken
import me.camdenorrb.legup.math.token.impl.OperatorToken
import me.camdenorrb.legup.math.token.type.ExprTokenType
import java.io.File


// The whole purpose of this file is to test the lexer and the process

fun main(args: Array<String>) {

    val testFile = File("math/src/main/resources/example.txt")

    println(listOf(NumericToken(1), NumericToken(2), NumericToken(3), OperatorToken(ExprTokenType.PLUS), OperatorToken(ExprTokenType.PLUS)).isPostFix())

    //println(ExprLexer(testFile.readText()).invoke().isPostFix())

    /*
    val text = testFile.readText()

    val totalTime = measureTimeMillis {
        repeat(10_000_000) {
            ExprLexer(text).invoke()
        }
    }

    println("TOTAL: $totalTime, Average: ${totalTime / 10_000_000}")*/

}
