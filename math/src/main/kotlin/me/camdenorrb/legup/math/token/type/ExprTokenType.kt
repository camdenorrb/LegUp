package me.camdenorrb.legup.math.token.type


enum class ExprTokenType(val symbol: String, val isOperator: Boolean = true) {

    PLUS("+"),
    SUBTRACT("-"),

    MULTIPLY("*"),
    DIVIDE("/"),

    EXPONENT("^"),

    PARENTHESIS("") {

        override fun isIdentifier(input: String) : Boolean {
            return input == "(" || input == ")"
        }

    },

    EQUALS("="),


    NUMERIC_VALUE("", false) {

        override fun isIdentifier(input: String) : Boolean {
            return input == "." || input.toIntOrNull() != null
        }

    };


    // Might turn input back to Char
    open fun isIdentifier(input: String) = input == symbol

    override fun toString() = symbol


    companion object {

        fun byIdentifier(input: String) : ExprTokenType? {
            return values().find { it.isIdentifier(input) }
        }

    }

}