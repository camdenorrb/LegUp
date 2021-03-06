package me.camdenorrb.legup.math.ext

import me.camdenorrb.legup.math.token.impl.ExprToken
import me.camdenorrb.legup.math.token.impl.ExprToken.Operator
import me.camdenorrb.legup.math.token.impl.ExprToken.Other.Function
import me.camdenorrb.legup.math.token.impl.ExprToken.Value
import java.util.*

// Move this to MathEquation class which'll handle types
/*fun <T : Iterable<ExprTokenBase>> T.solve() : Long {

    check(isPostFix()) {
        "Can't solve a non-postfix expression!"
    }

    var isDouble = false


    return TODO("Implement later")
}*/



fun <X : Any, T : Iterable<X>> T.splitBy(shouldSplit: (X) -> Boolean) : List<List<X>> {

    var builder = mutableListOf<X>()
    val result = mutableListOf<List<X>>()

    forEach {

        if (!shouldSplit(it)) {
            builder.add(it)
            return@forEach
        }

        result.add(builder)
        builder = mutableListOf()
    }

    if (builder.isNotEmpty()) result.add(builder)
    return result
}


// 2 + (2 - 2)
// [[2, +], [2 - 2]]
// 2 2 2 -+

fun <T : Iterable<ExprToken<out Any>>> T.asPostFix() : List<ExprToken<out Any>> {

    val queue = mutableListOf<ExprToken<out Any>>()
	val stack = LinkedList<ExprToken<out Any>>()

    forEach {

        when(it) {

            is Value -> queue += it
            is Function, is ExprToken.Parenthesis.Left -> stack += it

	        is Operator -> {
		        while (stack.isNotEmpty()) {

			        val top = stack.peek()
			        if (top is ExprToken.Parenthesis.Left) break

			        if (top is Function || (top is Operator && (top.priority > it.priority || (top.isLeft && it.priority == top.priority)))) {
				        queue += stack.pop()
			        }
			        else {
				        break
			        }
		        }

		        println(stack)
		        stack.push(it)
	        }

	        is ExprToken.Parenthesis.Right -> {

		        while (stack.peek() !is ExprToken.Parenthesis.Left) {
			        queue += stack.pop()
		        }

		        check(stack.pop() is ExprToken.Parenthesis.Left) {
			        "Mismatch in parenthesis (1)"
		        }
	        }

        }

    }

	check(stack.peek() !is ExprToken.Parenthesis) {
		"Mismatch in parenthesis (2)"
	}

	queue.addAll(stack)

	return queue
}


/*
fun <T : Iterable<ExprTokenBase>> T.asPostFix() : List<ExprTokenBase> {

    val inputs = this.splitBy { it is ParenthesisToken }

    println(inputs)


    /*
    val test = inputs.map {

        val partition = it.partition { it.type.isOperator }
        val operators = partition.first.toMutableList()

        val output = mutableListOf<ExprTokenBase>()

        var count = 0

        partition.second.windowed(2, 2, true).forEach {

            output.add(it[0])
            it.getOrNull(1)?.let { output.add(it) }

            val first = operators.first()

            if (operators.none { first.type.priority < it.type.priority }) {
                for (i in 0 until count) output.add(operators.removeAt(i))
                count = 0
            }
            else {
                operators.add(operators.removeAt(0))
                if (count < operators.size) count++
            }

        }

        operators.forEach { output.add(it) }
        return@map output

    }.foldRight(mutableListOf<ExprTokenBase>()) { holder, it ->

        val lastIndex = holder.indexOfLast { it is ExprToken }

        if (lastIndex >= 1) holder.addAll(lastIndex, it)
        else holder.addAll(it)

        println(holder)
        holder
    }


    println(test)
    // Finish check
    check(test.isPostFix()) {
        "There was an issue with the conversion to postfix."
    }

    println(test.isPostFix())

    return test
}*/


/*fun <T : Iterable<ExprTokenBase>> T.isPostFix() : Boolean {

    if (!last().type.isOperator) return false


    var temp = 1

    this.forEach {
        if (it.type.isOperator) temp++ else temp--
        if (temp >= 1) return false
    }

    return temp == 0
}*/