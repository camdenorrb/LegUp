package me.camdenorrb.legup.math.token.type


enum class ExprTokenType(val priority: Int, val symbol: String, val isOperator: Boolean = true) {

    PLUS(0, "+"),
    SUBTRACT(0, "-"),

    MULTIPLY(1, "*"),
    DIVIDE(1, "/"),

    EXPONENT(2, "^"),

    PARENTHESIS_OPEN(3, "(", false),
    PARENTHESIS_CLOSE(3, ")", false),

    EQUALS(4, "=", false),


    NUMERIC_VALUE(5, "", false) {

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