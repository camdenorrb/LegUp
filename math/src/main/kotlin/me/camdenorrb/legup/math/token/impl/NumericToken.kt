package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.math.token.base.ExprTokenBase
import me.camdenorrb.legup.math.token.type.ExprTokenType


class NumericToken(val input: Number) : ExprTokenBase {

    override val value = input.toString()

    override val type = ExprTokenType.NUMERIC_VALUE


    override fun toString() = value

}