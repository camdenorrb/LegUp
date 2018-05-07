package me.camdenorrb.legup.math.token.type

enum class ExprTokenType {

    ADD,
    SUB,

    MUL,
    DIV,

    EXP,

    PAREN_L,
    PAREN_R,

    EQUALS,

    NUMBER;


    // Might turn input back to Char
    //open fun isIdentifier(input: String) = input == symbol

    //override fun toString() = symbol



    /*companion object {

        fun byIdentifier(input: String) : ExprTokenType? {
            return values().find { it.isIdentifier(input) }
        }

    }*/

}