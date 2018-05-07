package me.camdenorrb.legup.central.iterator.base

interface IteratorBase<out T> : Iterator<T> {

    fun skip(amount: Int)


    fun nextUntil(predicate: (T) -> Boolean) : List<T> {

        if (!hasNext()) return emptyList()

        var value = next()
        val results = mutableListOf<T>()

        while (hasNext() && predicate(value)) {
            results.add(value)
            value = next()
        }

        return results
    }

}