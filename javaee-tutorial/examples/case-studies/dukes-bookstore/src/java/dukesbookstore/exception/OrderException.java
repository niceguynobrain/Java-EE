/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package dukesbookstore.exception;


/**
 * <p>This application exception indicates that an order cannot
 * be completed.</p>
 */
public class OrderException extends Exception {
    public OrderException() {
    }

    public OrderException(String msg) {
        super(msg);
    }
}
