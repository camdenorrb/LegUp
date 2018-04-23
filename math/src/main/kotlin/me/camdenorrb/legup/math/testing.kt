package me.camdenorrb.legup.math

import me.camdenorrb.legup.math.ext.asPostFix
import me.camdenorrb.legup.math.lexer.ExprLexer
import java.io.File


// The whole purpose of this file is to test the lexer and the process

fun main(args: Array<String>) {

    val testFile = File("math/src/main/resources/example.txt")

    //println(listOf(NumericToken(1), OperatorToken(ExprTokenType.MULTIPLY), NumericToken(2), NumericToken(3), OperatorToken(ExprTokenType.PLUS)).asPostFix())

    println(ExprLexer(testFile.readText()).invoke().asPostFix())

    /*
    val text = testFile.readText()

    val totalTime = measureTimeMillis {
        repeat(10_000_000) {
            ExprLexer(text).invoke()
        }
    }

    println("TOTAL: $totalTime, Average: ${totalTime / 10_000_000}")*/

}
