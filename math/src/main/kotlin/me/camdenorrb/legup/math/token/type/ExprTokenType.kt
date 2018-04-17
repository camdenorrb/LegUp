package me.camdenorrb.legup.math.token.type


enum class ExprTokenType {

    NUMERIC_VALUE {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '.' || char.isDigit()
        }

    },

    EQUALS {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '='
        }

        override fun toString() = "="
    },

    PLUS {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '+'
        }

        override fun toString() = "+"
    },

    SUBTRACT {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '-'
        }

        override fun toString() = "-"
    },

    MULTIPLY {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '*'
        }

        override fun toString() = "*"
    },

    DIVIDE {

        override fun isIdentifier(char: Char) : Boolean {
            return char == '/'
        }

        override fun toString() = "/"
    },

    POWER {

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