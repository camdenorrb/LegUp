package me.camdenorrb.legup.math.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator
import me.camdenorrb.legup.central.lexer.LexerBase
import me.camdenorrb.legup.math.token.base.ExprTokenBase
import me.camdenorrb.legup.math.token.base.NumericTokenBase
import me.camdenorrb.legup.math.token.impl.ExprToken
import me.camdenorrb.legup.math.token.impl.numeric.DecimalToken
import me.camdenorrb.legup.math.token.impl.numeric.LongToken
import me.camdenorrb.legup.math.token.type.ExprTokenType.*


private val numberRange = '0'..'9'


class ExprLexer(input: String) : LexerBase<ExprTokenBase>(input) {


    //private var valueBuilder = ""

    /*override fun strip(input: String) : String {
        return input.replace(" ", "")
    }*/

    /*override fun afterCollect() {

        if (valueBuilder.isNotEmpty()) {
            found(NumericTokenBase(valueBuilder.parseNumber()))
            valueBuilder = ""
        }

        check(tokenList.last() is NumericTokenBase) {
            "The expression cannot end with an operator!"
        }
    }*/

    override fun collect(input: PeekingCharIterator) = input.forEach {
        val token = gatherToken(it, input) ?: return@forEach
        println(token)
    }

    private fun gatherToken(it: Char, input: PeekingCharIterator) = when(it) {

        '+' -> ExprToken(ADD, "+")

        '/' -> ExprToken(DIV, "/")

        '*' -> ExprToken(MUL, "*")

        '.', '-', in numberRange -> {
            if (it == '-' && input.peekNext()?.isDigit() == false) ExprToken(SUB, "-")
            else gatherNumber(it, input)
        }

        else -> null
    }

    private fun gatherNumber(it: Char, input: PeekingCharIterator) : NumericTokenBase? {

        val peeked = input.peekNextUntil { !it.isDigit() && it != '.' }
        val value = "$it${peeked.joinToString("")}"

        input.skip(peeked.size)

        return if ('.' in value) DecimalToken(value.toDouble()) else LongToken(value.toLong())
    }


    // TODO: Make this a package level extension
    private fun String.parseNumber() : Number? {
        return if (this.contains('.')) this.toDoubleOrNull() else this.toLongOrNull()
    }

}
