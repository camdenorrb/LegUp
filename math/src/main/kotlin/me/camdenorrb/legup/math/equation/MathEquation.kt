package me.camdenorrb.legup.math.equation

import me.camdenorrb.legup.math.ext.asPostFix
import me.camdenorrb.legup.math.token.base.ExprTokenBase


class MathEquation(private val original: List<ExprTokenBase>) {

    val postfix by lazy { original.asPostFix() }






}