/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package dukesbookstore.exception;


/**
 * <p>This application exception indicates that books have not been found.</p>
 */
public class BooksNotFoundException extends Exception {
    public BooksNotFoundException() {
    }

    public BooksNotFoundException(String msg) {
        super(msg);
    }
}
