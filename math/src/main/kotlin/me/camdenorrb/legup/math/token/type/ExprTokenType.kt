package me.camdenorrb.legup.math.token.type


enum class ExprTokenType(val isOperator: Boolean) {

    NUMERIC_VALUE(false) {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '.' || char.isDigit()
        }

    },

    EQUALS(true) {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '='
        }

        override fun toString() = "="
    },

    PLUS(true) {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '+'
        }

        override fun toString() = "+"
    },

    SUBTRACT(true) {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '-'
        }

        override fun toString() = "-"
    },

    MULTIPLY(true) {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '*'
        }

        override fun toString() = "*"
    },

    DIVIDE(true) {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '/'
        }

        override fun toString() = "/"
    },

    POWER(true) {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '^'
        }

        override fun toString() = "^"
    };


    abstract fun isIdentifier(char: Char) : Boolean


    companion object {

        fun byIdentifier(char: Char) : ExprTokenType? {
            return values().find { it.isIdentifier(char) }
        }

    }

}