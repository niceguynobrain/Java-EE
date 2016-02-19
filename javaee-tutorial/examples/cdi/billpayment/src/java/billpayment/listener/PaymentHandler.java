/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package billpayment.listener;

import billpayment.payment.Credit;
import billpayment.payment.Debit;
import billpayment.event.PaymentEvent;
import billpayment.interceptor.Logged;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;


/**
 * Handler for the two kinds of PaymentEvent.
 */
@Logged
@SessionScoped
public class PaymentHandler implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(
                PaymentHandler.class.getCanonicalName());

    /**
     * Note: Since this bean is @SessionScoped, one instance per
     * session will be created NOT TRUE?
     */
    public PaymentHandler() {
        logger.log(Level.INFO, "PaymentHandler created.");
    }

    /**
     * Handles a Credit payment.
     *
     * @param event   a Credit event
     */
    public void creditPayment(@Observes
    @Credit
    PaymentEvent event) {
        logger.log(
                Level.INFO,
                "PaymentHandler - Credit Handler: {0}",
                event.toString());

        // call a specific Credit handler class...
    }

    /**
     * Handles a Debit payment.
     *
     * @param event   a Debit event
     */
    public void debitPayment(@Observes
    @Debit
    PaymentEvent event) {
        logger.log(
                Level.INFO,
                "PaymentHandler - Debit Handler: {0}",
                event.toString());

        // call a specific Debit handler class...
    }
}
