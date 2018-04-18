package me.camdenorrb.legup.math.ext

import me.camdenorrb.legup.math.token.base.ExprTokenBase


// Move this to MathEquation class which'll handle types
fun <T : Iterable<ExprTokenBase>> T.solve() : Number {

    check(isPostFix()) {
        "Can't solve a non-postfix expression!"
    }

    var isDouble = false


    return TODO("Implement later")
}



fun <T : Iterable<ExprTokenBase>> T.asPostFix() : List<ExprTokenBase> {

    // Finish check
    check(isPostFix()) {
        "There was an issue with the conversion to postfix."
    }

    return TODO("Implement later")
}


fun <T : Iterable<ExprTokenBase>> T.isPostFix() : Boolean {

    if (!last().type.isOperator) return false


    var temp = 1

    this.forEach {
        if (it.type.isOperator) temp++ else temp--
        if (temp >= 1) return false
    }

    return temp == 0
}