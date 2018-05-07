package me.camdenorrb.legup.central.iterator.impl

import me.camdenorrb.legup.central.iterator.base.PeekingIteratorBase


class PeekingCharIterator(private val input: CharArray) : PeekingIteratorBase<Char> {

    var currentIndex = 0


    constructor(input: String) : this(input.toCharArray())


    override fun next() = input[currentIndex++]

    override fun hasNext() = currentIndex < input.size


    override fun peek(index: Int) = input.getOrNull(index)

    override fun peekNext(add: Int) = input.getOrNull(currentIndex + add)

    override fun peekBehind(sub: Int) = input.getOrNull(currentIndex - sub)


    override fun skip(amount: Int) {
        currentIndex += amount
        currentIndex = currentIndex.coerceAtMost(input.size)
    }

}