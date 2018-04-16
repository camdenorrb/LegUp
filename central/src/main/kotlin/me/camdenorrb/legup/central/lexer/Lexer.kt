package me.camdenorrb.legup.central.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator


abstract class Lexer<T : Any>(private val input: String) {

    private val tokenMap = mutableMapOf<T, MutableList<String>>()


    var isParsed = false
        private set


    // Strips the text of anything that makes it difficult to parse
    protected open fun strip(input: String) = input

    // Collects the tokens to tokenMap
    protected open fun collect(input: PeekingCharIterator) = Unit


    // Compiles the tokenMap
    fun compile() = tokenMap.toList()


    // Call this method as you find tokens in the *implementation*
    protected fun found(token: T, value: String) {
        tokenMap.getOrPut(token, { mutableListOf() }).add(value)
    }


    // Attempts to parse through the provided text to find tokens
    fun parse() {
        if (isParsed) return

        collect(PeekingCharIterator(strip(input)))
        isParsed = true
    }

}