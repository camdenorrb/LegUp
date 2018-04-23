package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.math.token.base.ExprTokenBase
import me.camdenorrb.legup.math.token.type.ExprTokenType
import me.camdenorrb.legup.math.token.type.ExprTokenType.PARENTHESIS_CLOSE
import me.camdenorrb.legup.math.token.type.ExprTokenType.PARENTHESIS_OPEN


class ParenthesisToken(override val type: ExprTokenType) : ExprTokenBase {

    override val value = type.toString()


    init {
        check(type == PARENTHESIS_OPEN || type == PARENTHESIS_CLOSE) {
            "You cannot create a parenthesis token of a non-parenthesis type!"
        }
    }


    override fun toString() = value


    companion object {

        fun isThis(type: ExprTokenType) : Boolean {
            return type == PARENTHESIS_OPEN || type == PARENTHESIS_CLOSE
        }

    }

}