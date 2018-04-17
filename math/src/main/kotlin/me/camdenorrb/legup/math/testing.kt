package me.camdenorrb.legup.math

import me.camdenorrb.legup.math.lexer.ExprLexer
import java.io.File


// The whole purpose of this file is to test the lexer and the process

fun main(args: Array<String>) {

    val testFile = File("math/src/main/resources/example.txt")
    println(ExprLexer(testFile.readText()).invoke())

}
