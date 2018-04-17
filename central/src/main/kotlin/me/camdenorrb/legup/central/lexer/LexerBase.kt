package me.camdenorrb.legup.central.lexer

import me.camdenorrb.legup.central.iterator.impl.PeekingCharIterator


abstract class LexerBase<T : Any>(private val input: String) {

    private val tokenList = mutableListOf<T>()


    var isParsed = false
        private set


    // Strips the text of anything that makes it difficult to parse
    protected open fun strip(input: String) = input

    // Collects the tokens to tokenList
    protected open fun collect(input: PeekingCharIterator) = Unit

    // Called after collection is done
    protected open fun afterCollect() = Unit



    // Compiles the tokenList
    fun compile() = tokenList.toList()


    // Call this method as you find tokens in the *implementation*
    protected fun found(token: T) {
        tokenList.add(token)
    }

    // Parse + compile
    operator fun invoke() : List<T> {
        parse()
        return compile()
    }


    // Attempts to parse through the provided text to find tokens
    fun parse() {
        if (isParsed) return

        collect(PeekingCharIterator(strip(input)))
        afterCollect()

        isParsed = true
    }

}