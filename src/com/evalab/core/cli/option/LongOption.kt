package com.evalab.core.cli.option

import com.evalab.core.cli.exception.IllegalOptionValueException

public class LongOption : Option<Long> {
    constructor(longForm: String, shortForm: Char? = null, helpDesc: String? = null) : super(longForm, true, shortForm, helpDesc)

    throws(javaClass<IllegalOptionValueException>())
    override fun parse(arg: String): Long {
        try {
            return arg.toLong()
        } catch (e: NumberFormatException) {
            throw IllegalOptionValueException(this, arg)
        }
    }
}