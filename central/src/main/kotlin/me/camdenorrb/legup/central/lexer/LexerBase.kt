package me.camdenorrb.legup.central.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator

abstract class LexerBase<T : Any>(private val input: String) {

    protected val tokenList = mutableListOf<T>()


    var isParsed = false
        private set


    // Strips the text of anything that makes it difficult to parse
    protected open fun strip(input: String) = input

    // Collects the tokens to tokenList
    protected open fun collect(input: PeekingCharIterator) = Unit

    // Called after collection is done
    protected open fun afterCollect() = Unit



    // Public access to tokenList
    fun tokenList() = tokenList.toList()


    // Call this method as you find tokens in the *implementation*
    protected fun found(token: T) {
        tokenList.add(token)
    }

    // Parse + returns tokens
    operator fun invoke() : List<T> {
        lex()
        return tokenList
    }


    // Attempts to parse through the provided text to find tokens
    fun lex() {
        if (isParsed) return

        collect(PeekingCharIterator(strip(input)))
        afterCollect()

        isParsed = true
    }

}