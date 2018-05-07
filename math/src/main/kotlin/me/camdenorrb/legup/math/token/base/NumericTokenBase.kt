package me.camdenorrb.legup.math.token.base

import me.camdenorrb.legup.math.token.type.ExprTokenType


abstract class NumericTokenBase(val input: Number) : ExprTokenBase {

    override val value = input.toString()

    override val type = ExprTokenType.NUMBER


    override fun toString() = value

}