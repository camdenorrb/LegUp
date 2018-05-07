package me.camdenorrb.legup.central.iterator.impl

import me.camdenorrb.legup.central.iterator.base.PeekingIteratorBase


class PeekingArrayIterator<out T>(private val input: Array<T>) : PeekingIteratorBase<T> {

    var nextIndex = 0


    override fun next() = input[nextIndex++]

    override fun hasNext() = nextIndex < input.size


    override fun peek(index: Int) = input.getOrNull(index)

    override fun peekNext(add: Int) = input.getOrNull(nextIndex + add)

    override fun peekBehind(sub: Int) = input.getOrNull(nextIndex - sub)


    override fun skip(amount: Int) {
        nextIndex += amount
        nextIndex = nextIndex.coerceAtMost(input.size)
    }

}