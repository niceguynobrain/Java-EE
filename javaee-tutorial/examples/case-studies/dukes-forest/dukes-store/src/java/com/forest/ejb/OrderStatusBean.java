/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forest.ejb;

import com.forest.entity.OrderStatus;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author markito
 */
@Stateless
public class OrderStatusBean extends AbstractFacade<OrderStatus>
    implements Serializable {
    @PersistenceContext(unitName = "forestPU")
    private EntityManager em;

    public OrderStatusBean() {
        super(OrderStatus.class);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderStatus getStatusByName(String status) {
        Query createNamedQuery = getEntityManager()
                                     .createNamedQuery(
                    "OrderStatus.findByStatus");

        //SELECT o FROM OrderStatus o WHERE o.status = :status
        createNamedQuery.setParameter("status", status);

        return (OrderStatus) createNamedQuery.getSingleResult();
    }
}
