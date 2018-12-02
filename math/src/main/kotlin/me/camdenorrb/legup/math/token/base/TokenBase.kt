package me.camdenorrb.legup.math.token.base

// Might move to central.
interface TokenBase<out T : Any, out V : Any> {

    val type: T

    val value: V


    override fun toString() : String

}