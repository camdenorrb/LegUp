package me.camdenorrb.legup.math.token.type


enum class ExprTokenType(val symbol: String, val isOperator: Boolean = true, val isIdentifier: (Char) -> Boolean = { it == symbol[0] }) {

    PLUS("+"),

    POWER("^"),

    EQUALS("="),

    DIVIDE("/"),

    SUBTRACT("-"),

    MULTIPLY("*"),


    NUMERIC_VALUE("", false, { it == '.' || it.isDigit() });


    override fun toString(): String {
        return symbol
    }


    companion object {

        fun byIdentifier(char: Char) : ExprTokenType? {
            return values().find { it.isIdentifier(char) }
        }

    }

}