package me.camdenorrb.legup.math.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator
import me.camdenorrb.legup.central.lexer.LexerBase
import me.camdenorrb.legup.math.token.type.ExprToken

class ExprLexer(input: String) : LexerBase<String>(input) {

    private var valueBuilder = ""

    //private var isReadingNumber = false

    //private var valueHolder: Number? = null

    private var currentToken: ExprToken? = null


    override fun strip(input: String) : String {
        return input.replace(" ", "")
    }

    override fun afterCollect() {
        valueBuilder = ""
        //valueHolder = null
        currentToken = null
        //isReadingNumber = false
    }

    override fun collect(input: PeekingCharIterator) = input.forEach {

        if (it.isDigit() || it == '.') {
            valueBuilder += it
            return@forEach
        }


       // valueBuilder.

        val token = ExprToken.byIdentifier(it) ?: return@forEach


    }

    private fun String.parseNumber() : Number {

        if (contains('.')) {

            val testValue = this.toDouble()

            if (testValue >= Float.MIN_VALUE && testValue <= Float.MAX_VALUE) {
                return testValue.toFloat()
            }

            return testValue
        }

        else {

            val testValue = this.toLong()

            return when (testValue) {
                in Byte.MIN_VALUE..Byte.MAX_VALUE -> testValue.toByte()
                in Short.MIN_VALUE..Short.MAX_VALUE -> testValue.toShort()
                in Int.MIN_VALUE..Int.MAX_VALUE -> testValue.toInt()
                else -> testValue
            }

        }

    }

}