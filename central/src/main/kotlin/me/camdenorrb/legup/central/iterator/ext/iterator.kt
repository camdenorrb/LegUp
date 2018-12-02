package me.camdenorrb.legup.central.iterator.ext


fun <T> Iterator<T>.nextUntil(predicate: (T) -> Boolean) : List<T> {

	if (!hasNext()) return emptyList()

	var value = next()
	val results = mutableListOf<T>()

	while (hasNext() && predicate(value)) {
		results.add(value)
		value = next()
	}

	return results
}