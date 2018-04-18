package me.camdenorrb.legup.math.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator
import me.camdenorrb.legup.central.lexer.LexerBase
import me.camdenorrb.legup.math.token.base.ExprTokenBase
import me.camdenorrb.legup.math.token.impl.NumericToken
import me.camdenorrb.legup.math.token.impl.OperatorToken
import me.camdenorrb.legup.math.token.type.ExprTokenType
import me.camdenorrb.legup.math.token.type.ExprTokenType.NUMERIC_VALUE

class ExprLexer(input: String) : LexerBase<ExprTokenBase>(input) {

    private var valueBuilder = ""


    override fun strip(input: String) : String {
        return input.replace(" ", "")
    }

    override fun afterCollect() {

        if (valueBuilder.isNotEmpty()) {
            found(NumericToken(valueBuilder.parseNumber()))
            valueBuilder = ""
        }

        check(tokenList.last() !is OperatorToken) {
            "The expression cannot end with an operator!"
        }
    }

    override fun collect(input: PeekingCharIterator) = input.forEach {

        if (NUMERIC_VALUE.isIdentifier(it.toString())) {
            valueBuilder += it
            return@forEach
        }

        if (valueBuilder.isNotEmpty()) {
            found(NumericToken(valueBuilder.parseNumber()))
            valueBuilder = ""
        }

        val token = ExprTokenType.byIdentifier(it.toString()) ?: return@forEach

        check(tokenList.last() !is OperatorToken) {
            "Cannot have 2 operators side by side!"
        }

        found(OperatorToken(token))
    }




    private fun String.parseNumber() : Number {
        return if (this.contains('.')) this.toDouble() else this.toLong()
    }

}