package me.camdenorrb.legup.math.token.type


enum class ExprTokenType(val symbol: String, val isIdentifier: (Char) -> Boolean = { it == symbol[0] }, val isOperator: Boolean = true) {

    PLUS("+"),

    POWER("^"),

    EQUALS("="),

    DIVIDE("/"),

    SUBTRACT("-"),

    MULTIPLY("*"),

    NUMERIC_VALUE("", { it == '.' || it.isDigit() }, false);


    override fun toString(): String {
        return symbol
    }


    companion object {

        fun byIdentifier(char: Char) : ExprTokenType? {
            return values().find { it.isIdentifier(char) }
        }

    }

}