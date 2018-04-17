package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.math.token.base.TokenBase
import me.camdenorrb.legup.math.token.type.ExprTokenType


class NumericToken(override val value: Number) : TokenBase<ExprTokenType, Number> {

    override val type = ExprTokenType.NUMERIC_VALUE

    override fun toString() = value.toString()

}