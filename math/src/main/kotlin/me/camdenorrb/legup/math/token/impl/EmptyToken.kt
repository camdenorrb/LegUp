package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.math.token.base.TokenBase

object EmptyToken : TokenBase<Any, Any>{

    override val type = ""

    override val value = ""


    override fun toString() = "EmptyToken"

}