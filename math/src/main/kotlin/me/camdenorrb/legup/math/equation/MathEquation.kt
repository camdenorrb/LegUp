package me.camdenorrb.legup.math.equation

import me.camdenorrb.legup.math.lexer.ExprLexer
import me.camdenorrb.legup.math.token.base.ExprTokenBase


class MathEquation(val input: List<ExprTokenBase>) {
    
    /*val postfix by lazy { input.asPostFix() }*/

    
    constructor(input: String) : this(ExprLexer(input))

    constructor(lexer: ExprLexer) : this(lexer.invoke())

    
    fun solve() {
        TODO("Solve the equation if applicable")
    }

}
