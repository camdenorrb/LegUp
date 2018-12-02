package me.camdenorrb.legup.central.iterator.base

interface IteratorBase<out T> : Iterator<T> {

    fun skip(amount: Int)

}