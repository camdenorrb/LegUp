package me.camdenorrb.legup.math.token.impl

import me.camdenorrb.legup.central.base.Identified
import me.camdenorrb.legup.math.token.base.TokenBase
import kotlin.Double as KotlinDouble
import kotlin.Long as KotlinLong
import kotlin.Number as KotlinNumber


sealed class ExprToken<T : Any> : Identified<T>, TokenBase<ExprToken<out Any>, T> {

    override val type by lazy {
        this
    }

	override val value by lazy {
		identity
	}


    sealed class Operator(override val identity: String, val priority: Int, val isLeft: Boolean = true) : ExprToken<String>() {

        object Equals : Operator("=", 0, false)


	    sealed class Modifier(identity: String, priority: Int, isLeft: Boolean = true) : Operator(identity, priority, isLeft) {

		    object Add : Modifier("+", 2) {

			    override fun eval(input1: KotlinNumber, input2: KotlinNumber): KotlinNumber {
				    return if (input1 is KotlinDouble || input2 is KotlinDouble) {
					    input1.toDouble() + input2.toDouble()
				    }
				    else {
					    input1.toLong() + input2.toLong()
				    }
			    }

		    }

		    object Sub : Modifier("-", 2) {

			    override fun eval(input1: KotlinNumber, input2: KotlinNumber): KotlinNumber {
				    return if (input1 is KotlinDouble || input2 is KotlinDouble) {
					    input1.toDouble() - input2.toDouble()
				    }
				    else {
					    input1.toLong() - input2.toLong()
				    }
			    }

		    }

		    object Multiply : Modifier("*", 3) {

			    override fun eval(input1: KotlinNumber, input2: KotlinNumber): KotlinNumber {
				    return if (input1 is KotlinDouble || input2 is KotlinDouble) {
					    input1.toDouble() * input2.toDouble()
				    }
				    else {
					    input1.toLong() * input2.toLong()
				    }
			    }

		    }

		    object Divide : Modifier("/", 3) {

			    override fun eval(input1: KotlinNumber, input2: KotlinNumber): KotlinNumber {
				    return if (input1 is KotlinDouble || input2 is KotlinDouble) {
					    input1.toDouble() / input2.toDouble()
				    }
				    else {
					    input1.toLong() / input2.toLong()
				    }
			    }

		    }

		    object Exponent : Modifier("^", 4, false) {

			    override fun eval(input1: KotlinNumber, input2: KotlinNumber): KotlinNumber {
				    return if (input1 is KotlinDouble || input2 is KotlinDouble) {
					    Math.pow(input1.toDouble(), input2.toDouble())
				    }
				    else {
					    Math.pow(input1.toDouble(), input2.toDouble()).toLong()
				    }
			    }

		    }


		    abstract fun eval(input1: KotlinNumber, input2: KotlinNumber): KotlinNumber

		    fun eval(input1: Value, input2: Value): KotlinNumber {
			    return eval(input1.value, input2.value)
		    }

	    }

	    companion object {

	    	val operators = listOf(Equals, Modifier.Add, Modifier.Sub, Modifier.Multiply, Modifier.Divide, Modifier.Exponent)

		    fun byIdentifier(identifier: String): Operator? {
			    return operators.find { it.identity.equals(identifier, true) }
		    }

	    }

    }

	open class Value(override val identity: KotlinNumber) : ExprToken<KotlinNumber>() {

        class Long(val longValue: KotlinLong) : Value(longValue)

        class Decimal(val doubleValue: KotlinDouble) : Value(doubleValue)

    }


    sealed class Parenthesis(override val identity: String) : ExprToken<String>() {
        object Left : Parenthesis("(")
        object Right : Parenthesis(")")
    }

	sealed class Other(override val identity: String) : ExprToken<String>() {

		class Symbol(identity: String) : Other(identity)

        class Function(identity: String, vararg val input: Value) : Other(identity) {

            override fun toString(): String {
                return "$identity(${input.joinToString()})"
            }

        }

	}


    override fun toString(): String {
        return "$identity"
    }

}

/*
class ExprToken(override val type: ExprTokenType) : ExprTokenBase {

    override val value = type.toString()

    override fun toString(): String {
        return value
    }

}*/

/*
class ExprToken(override val type: ExprTokenType) : ExprTokenBase {

    override val value = type.toString()


    init {
        check(type.isOperator) {
            "You cannot create an operator token of a non-operator type!"
        }
    }


    override fun toString() = value


    companion object {

        fun isThis(type: ExprTokenType) : Boolean {
            return type.isOperator
        }

    }

}
*/