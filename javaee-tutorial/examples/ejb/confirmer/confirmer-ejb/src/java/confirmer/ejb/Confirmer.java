/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package confirmer.ejb;

import javax.ejb.Remote;


/**
 * This is the business interface for Confirmer enterprise bean.
 */
@Remote
public interface Confirmer {
    void sendNotice(String recipient);
}
