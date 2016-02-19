/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package greetings;

@Informal
public class InformalGreeting extends Greeting {
    @Override
    public String greet(String name) {
        return "Hi, " + name + "!";
    }
}
