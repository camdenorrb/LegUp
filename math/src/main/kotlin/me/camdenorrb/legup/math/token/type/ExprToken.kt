package me.camdenorrb.legup.math.token.type


enum class ExprToken(val identifier: Char) {

    EQUALS('='),
    PLUS('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    POWER('^');


    override fun toString(): String {
        return identifier.toString()
    }


    companion object {

        fun byIdentifier(char: Char, ignoreCase: Boolean = false): ExprToken? {
            return values().find { it.identifier.equals(char, ignoreCase) }
        }

    }

}