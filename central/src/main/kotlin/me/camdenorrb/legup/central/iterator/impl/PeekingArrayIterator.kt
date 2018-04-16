package me.camdenorrb.legup.central.iterator.impl

import me.camdenorrb.legup.central.iterator.base.PeekingIteratorBase


class PeekingArrayIterator<out T>(private val input: Array<T>) : PeekingIteratorBase<T> {

    var currentIndex = 0


    override fun next() = input[currentIndex++]

    override fun hasNext() = currentIndex < input.size


    override fun peek(index: Int) = input.getOrNull(index)

    override fun peekNext(index: Int) = input.getOrNull(currentIndex + index)

    override fun peekBehind(index: Int) = input.getOrNull(currentIndex - index)

}