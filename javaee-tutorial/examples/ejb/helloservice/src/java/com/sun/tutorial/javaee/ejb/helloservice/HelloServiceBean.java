/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package com.sun.tutorial.javaee.ejb.helloservice;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * HelloServiceBean is a web service endpoint implemented as a stateless
 * session bean.
 */
@Stateless
@WebService
public class HelloServiceBean {
    private String message = "Hello, ";

    public void HelloServiceBean() {
    }

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
