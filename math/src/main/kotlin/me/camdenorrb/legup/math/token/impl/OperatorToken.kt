package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.math.token.base.TokenBase
import me.camdenorrb.legup.math.token.type.ExprTokenType


class OperatorToken(override val type: ExprTokenType) : TokenBase<ExprTokenType, String> {

    override val value = type.toString()


    init {
        check(type != ExprTokenType.NUMERIC_VALUE) {
            "You can't create an operator token of a Numeric Value!"
        }
    }


    override fun toString() = value

}