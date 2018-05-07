package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.math.token.base.ExprTokenBase
import me.camdenorrb.legup.math.token.type.ExprTokenType

class ExprToken(override val type: ExprTokenType, override val value: String) : ExprTokenBase {

    override fun toString() = value

}