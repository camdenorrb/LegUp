package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.math.token.base.TokenBase
import me.camdenorrb.legup.math.token.type.ExprTokenType


class OperatorToken(override val type: ExprTokenType) : TokenBase<ExprTokenType, String> {

    override val value = type.toString()


    init {
        check(type.isOperator) {
            "You cannot create an operator token of a non-operator type!"
        }
    }


    override fun toString() = value

}