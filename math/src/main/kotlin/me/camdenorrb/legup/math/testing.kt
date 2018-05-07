package me.camdenorrb.legup.math

import me.camdenorrb.legup.math.lexer.ExprLexer


// The whole purpose of this file is to test the lexer and the process

fun main(args: Array<String>) {

    //val testFile = File("math/src/main/resources/example.txt")

    //println(listOf(LongToken(1), ExprToken(MUL, "*"), LongToken(2), LongToken(3), ExprToken(ADD, "+")))

    ExprLexer("1.2121212").invoke()
    //println(ExprLexer(testFile.readText()).invoke())

    /*
    val text = testFile.readText()

    val totalTime = measureTimeMillis {
        repeat(10_000_000) {
            ExprLexer(text).invoke()
        }
    }

    println("TOTAL: $totalTime, Average: ${totalTime / 10_000_000}")*/

}
