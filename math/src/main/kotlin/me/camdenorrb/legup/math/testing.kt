package me.camdenorrb.legup.math

import me.camdenorrb.legup.math.ext.asPostFix
import me.camdenorrb.legup.math.lexer.ExprLexer
import me.camdenorrb.legup.math.token.impl.ExprToken
import java.util.*


// The whole purpose of this file is to test the lexer and the process

fun main(args: Array<String>) {

    //val testFile = File("math/src/main/resources/example.txt")

    //println(listOf(LongToken(1), ExprToken(MUL, "*"), LongToken(2), LongToken(3), ExprToken(ADD, "+")))


    //println(ExprLexer("(1.2121212 + PI + 2 - -2)").invoke().joinToString { it.type.name })

    //println(ExprLexer(testFile.readText()).invoke())

    /*
    val text = testFile.readText()

    val totalTime = measureTimeMillis {
        repeat(10_000_000) {
            ExprLexer(text).invoke()
        }
    }

    println("TOTAL: $totalTime, Average: ${totalTime / 10_000_000}")*/
    val input = ExprLexer("(1 + 1) - (34 * 3 + 2)").invoke()

    println(input)
    println(input.asPostFix().joinToString(" "))


    val stack = LinkedList<ExprToken.Value>()

    input.asPostFix().forEach {

        if (it is ExprToken.Value) {
            stack.push(it)
        }
        else if (it is ExprToken.Operator.Modifier) {
            val temp = stack.pop()
            val result = it.eval(stack.pop(), temp)
            stack.push(ExprToken.Value(result))
        }
        println(stack)
    }
    /*val outputQueue = ArrayDeque<ExprTokenBase>()
    val operatorQueue = ArrayDeque<ExprTokenBase>()

    input.forEach {

        if (it is NumericTokenStruct) {
            outputQueue.add(it)
            return@forEach
        }*/

        //if ()


        /*
        val resultQueue = ArrayDeque<NumericTokenStruct>()


        while (outputQueue.size >= 1) {

            val pop = outputQueue.pop()
            if (pop is NumericTokenStruct) resultQueue.push(pop)
            else {

                val pop1 = resultQueue.pop()
                val pop2 = resultQueue.pop()
                println("$pop2 $pop $pop1 = ${calc(pop.type, pop2, pop1)}")
                resultQueue.push(calc(pop.type, pop2, pop1))
            }

            // println("${pop.type}"resultQueue.peekFirst())
            //val calc = calc(op.type, value1, value2)
            //numQueue.push(calc)
            //println("$value1 $op $value2 = $calc")

        }


        println(resultQueue.size)
        println(resultQueue.pop())


    }*/
}


/*
fun calc(type: ExprTokenType, it1: NumericTokenStruct, it2: NumericTokenStruct): NumericTokenStruct {

    val input1 = it1.input.toDouble()
    val input2 = it2.input.toDouble()

    val answer = when (type) {
        ADD -> input1 + input2
        SUB -> input1 - input2
        DIV -> input1 / input2
        MUL -> input1 * input2
        EXP -> input1.pow(input2)
        else -> Double.NaN
    }

    return if (answer % 1 == 0.0) NumericToken.LongToken(answer.toLong()) else NumericToken.DecimalToken(answer)
}

fun prec(token: ExprTokenBase) = when (token.type) {
    ADD, SUB -> 1
    DIV, MUL -> 2
    else -> 0
}

object OperatorComparator : Comparator<ExprTokenBase> {

    override fun compare(it1: ExprTokenBase, it2: ExprTokenBase): Int {
        return prec(it2).compareTo(prec(it1))
    }

}*/
