/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package dukesbookstore.web.managedbeans;

import dukesbookstore.entity.Book;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 * <p>Managed bean for the
 * <code>/bookshowcart.xhtml</code> page.</p>
 */
@Named("showcart")
@SessionScoped
public class ShowCartBean extends AbstractBean implements Serializable {
    private boolean cartChanged = false;

    public boolean isCartChanged() {
        return cartChanged;
    }

    public void setCartChanged(boolean cartChanged) {
        this.cartChanged = cartChanged;
    }

    /**
     * <p>Return the
     * <code>ShoppingCartItem</code> instance from the user request.</p>
     */
    protected ShoppingCartItem item() {
        ShoppingCartItem item = (ShoppingCartItem) context()
                                                       .getExternalContext()
                                                       .getRequestMap()
                                                       .get("item");

        return (item);
    }

    /**
     * <p>Show the details page for the current book.</p>
     */
    public String details() {
        context()
            .getExternalContext()
            .getSessionMap()
            .put(
            "selected",
            item().getItem());

        return ("bookdetails");
    }

    /**
     * <p>Remove the item from the shopping cart.</p>
     */
    public String remove() {
        Book book = (Book) item()
                               .getItem();
        cart.remove(book.getBookId());
        setCartChanged(true);
        message(
            null,
            "ConfirmRemove",
            new Object[] { book.getTitle() });

        return (null);
    }

    /**
     * <p>Report the change to the shopping cart, based on the values entered in
     * the "Quantity" column.</p>
     */
    public String update() {
        String changed = (String) FacesContext.getCurrentInstance()
                                              .getExternalContext()
                                              .getSessionMap()
                                              .get("changed");

        if ((changed != null) && changed.equals("true")) {
            setCartChanged(true);
        } else {
            setCartChanged(false);
        }

        if (isCartChanged()) {
            message(null, "QuantitiesUpdated");
        } else {
            message(null, "QuantitiesNotUpdated");
        }

        FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .put("changed", "false");

        return (null);
    }
}