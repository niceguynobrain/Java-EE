/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package encoder;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * Managed bean that calls a Coder implementation to perform a transformation
 * on an input string
 */
@Named
@RequestScoped
public class CoderBean {
    @Inject
    Coder coder;
    private String codedString;
    private String inputString;
    @Max(26)
    @Min(0)
    @NotNull
    private int transVal;

    public void encodeString() {
        setCodedString(coder.codeString(inputString, transVal));
    }

    public void reset() {
        setInputString("");
        setTransVal(0);
    }

    /**** GETTERS and SETTERS ****/
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inString) {
        inputString = inString;
    }

    public String getCodedString() {
        return codedString;
    }

    public void setCodedString(String str) {
        codedString = str;
    }

    public int getTransVal() {
        return transVal;
    }

    public void setTransVal(int tval) {
        transVal = tval;
    }
}
