package me.camdenorrb.legup.math.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator
import me.camdenorrb.legup.central.lexer.LexerBase
import me.camdenorrb.legup.math.token.base.TokenBase
import me.camdenorrb.legup.math.token.impl.NumericToken
import me.camdenorrb.legup.math.token.impl.OperatorToken
import me.camdenorrb.legup.math.token.type.ExprTokenType

class ExprLexer(input: String) : LexerBase<TokenBase<Any, Any>>(input) {

    private var valueBuilder = ""

    //private var isReadingNumber = false

    //private var valueHolder: Number? = null

    //private var currentToken: ExprTokenType? = null


    override fun strip(input: String) : String {
        return input.replace(" ", "")
    }

    override fun afterCollect() {

        if (valueBuilder.isNotEmpty()) {
            found(NumericToken(valueBuilder.parseNumber()))
            valueBuilder = ""
        }

        //valueHolder = null
        //currentToken = null
        //isReadingNumber = false
    }

    override fun collect(input: PeekingCharIterator) = input.forEach {

        if (it.isDigit() || it == '.') {
            valueBuilder += it
            return@forEach
        }

        if (valueBuilder.isNotEmpty()) {
            found(NumericToken(valueBuilder.parseNumber()))
            valueBuilder = ""
        }

        val token = ExprTokenType.byIdentifier(it) ?: return@forEach
        found(OperatorToken(token))

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