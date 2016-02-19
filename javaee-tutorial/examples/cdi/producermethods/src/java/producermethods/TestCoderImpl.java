/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package producermethods;


/**
 * Coder implementation that does nothing but display the values of the
 * arguments.
 */
public class TestCoderImpl implements Coder {
    /**
     * Returns a string that displays the values of the arguments.
     *
     * @param s     the input string
     * @param tval  the number of characters to shift
     * @return      string displaying argument values
     */
    @Override
    public String codeString(
        String s,
        int tval) {
        return ("input string is " + s + ", shift value is " + tval);
    }
}
