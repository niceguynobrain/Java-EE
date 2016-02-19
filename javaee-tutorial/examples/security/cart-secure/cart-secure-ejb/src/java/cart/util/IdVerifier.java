/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package cart.util;

public class IdVerifier {
    public IdVerifier() {
    }

    public boolean validate(String id) {
        boolean result = true;

        for (int i = 0; i < id.length(); i++) {
            if (Character.isDigit(id.charAt(i)) == false) {
                result = false;
            }
        }

        return result;
    }
}
