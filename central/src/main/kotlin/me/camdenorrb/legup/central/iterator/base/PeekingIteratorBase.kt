package me.camdenorrb.legup.central.iterator.base


interface PeekingIteratorBase<out T> : IteratorBase<T> {

    // Peek that specific index in the *whole* collection
    fun peek(index: Int = 0) : T?


    // Peek the addition of the current index and the provided
    fun peekNext(index: Int = 1) : T?

    // Peek the subtraction of the current index and the provided
    fun peekBehind(index: Int = 1) : T?


    // Peeks next until either the predicate returns false or the collection is exhausted
    fun peekNextUntil(predicate: (T) -> Boolean) : List<T> {

        var value = peekNext() ?: return emptyList()
        val results = mutableListOf<T>()

        while (predicate(value)) {
            results.add(value)
            value = peekNext() ?: break
        }

        return results
    }

    // Peeks behind until either the predicate returns false or the collection is exhausted
    fun peekBehindUntil(predicate: (T) -> Boolean) : List<T> {

        var value = peekBehind() ?: return emptyList()
        val results = mutableListOf<T>()

        while (predicate(value)) {
            results.add(value)
            value = peekBehind() ?: break
        }

        return results
    }

}