package me.camdenorrb.legup.math.token.base

// Might not be needed.
interface TokenBase<out T : Any, out V : Any> {

    val type: T

    val value: V


    override fun toString() : String

}