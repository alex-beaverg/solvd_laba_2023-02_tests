package com.solvd.tests.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Printers {
    public static final Logger PRINT = LogManager.getLogger("InsteadOfSOUT");
    public static final Logger PRINTLN = LogManager.getLogger("InsteadOfSOUT_ln");
    public static final Logger PRINT2LN = LogManager.getLogger("ln_InsteadOfSOUT_ln");
}