package me.camdenorrb.legup.math.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator
import me.camdenorrb.legup.central.lexer.LexerBase
import me.camdenorrb.legup.math.token.impl.ExprToken


class ExprLexer(input: String) : LexerBase<ExprToken<out Any>>(input) {

    override fun afterCollect() {

        val last = tokenList.last()

        check(last is ExprToken.Value || last is ExprToken.Parenthesis) {
            "The expression cannot end with an operator!"
        }

        var count = 0

        tokenList.forEach {
            if (it is ExprToken.Parenthesis.Left) {
                count++
            }
            else if (it is ExprToken.Parenthesis.Right) {
                count--
            }
        }

        check(count == 0) {
            "Mismatch of opening and closing parentheses"
        }
    }

    override fun collect(input: PeekingCharIterator) = input.forEach {
        val token = gatherToken(it, input) ?: return@forEach
        found(token)
    }

    private fun gatherToken(it: Char, input: PeekingCharIterator) = when(it) {

        '+' -> ExprToken.Operator.Modifier.Add

        '/' -> ExprToken.Operator.Modifier.Divide

        '*' -> ExprToken.Operator.Modifier.Multiply

        '(' -> ExprToken.Parenthesis.Left

        ')' -> ExprToken.Parenthesis.Right

        '.', '-', in numberRange -> {
            if (it == '-' && input.peekNext()?.isDigit() == false) ExprToken.Operator.Modifier.Sub
            else gatherNum(it, input)
        }

        in lowerCaseRange, in upperCaseRange -> {
            gatherSymbol(it, input)
        }

        else -> null
    }


    private fun gatherSymbol(it: Char, input: PeekingCharIterator) : ExprToken.Other.Symbol {

        val peeked = input.peekNextUntil { it !in lowerCaseRange && it !in upperCaseRange }
        val value = "$it${peeked.joinToString("")}"

        input.skip(peeked.size)

        return ExprToken.Other.Symbol(value)
    }

    private fun gatherNum(it: Char, input: PeekingCharIterator) : ExprToken.Value? {

        val peeked = input.peekNextUntil { !it.isDigit() && it != '.' }
        val value = "$it${peeked.joinToString("")}"

        input.skip(peeked.size)

        return if ('.' in value) ExprToken.Value.Decimal(value.toDouble()) else ExprToken.Value.Long(value.toLong())
    }


    // TODO: Make this a package level extension
    private fun String.parseNumber() : Number? {
        return if ('.' in this) toDoubleOrNull() else toLongOrNull()
    }


    companion object {

        private val numberRange = '0'..'9'

        private val lowerCaseRange = 'a'..'z'
        private val upperCaseRange = 'A'..'Z'

    }

}
