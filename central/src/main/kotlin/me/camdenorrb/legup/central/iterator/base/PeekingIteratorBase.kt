package me.camdenorrb.legup.central.iterator.base


interface PeekingIteratorBase<out T> : IteratorBase<T> {

    // Peek that specific index in the *whole* collection
    fun peek(index: Int = 0) : T?


    // Peek the addition of the next index and the provided
    fun peekNext(add: Int = 0) : T?

    // Peek the subtraction of the next index and the provided
    fun peekBehind(sub: Int = 0) : T?


    // Peeks next until either the predicate returns false or the collection is exhausted
    fun peekNextUntil(until: (T) -> Boolean) : List<T> {

        var value = peekNext() ?: return emptyList()
        val results = mutableListOf<T>()

        var add = 1

        while (!until(value)) {
            results.add(value)
            value = peekNext(add++) ?: break
        }

        return results
    }

    // Peeks behind until either the predicate returns false or the collection is exhausted
    fun peekBehindUntil(until: (T) -> Boolean) : List<T> {

        var value = peekBehind() ?: return emptyList()
        val results = mutableListOf<T>()

        var sub = 1

        while (!until(value)) {
            results.add(value)
            value = peekBehind(sub++) ?: break
        }

        return results
    }

}