/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package billpayment.event;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Common payment event that handles Debit and Credit payment types.
 */
public class PaymentEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    public BigDecimal value;
    public Date datetime;
    public String paymentType;

    public PaymentEvent() {
    }

    @Override
    public String toString() {
        return this.paymentType + " = $" + this.value.toString() + " at "
        + this.datetime.toString();
    }

    /**** GETTERS and SETTERS ****/
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
