/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package dukesbookstore.components;

import dukesbookstore.listeners.AreaSelectedEvent;
import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;


/**
 * <p>{@link MapComponent} is a JavaServer Faces component that corresponds
 * to a client-side image map.  It can have one or more children of type
 * {@link AreaComponent}, each representing hot spots, which a user can
 * click on and mouse over.</p>
 *
 * <p>This component is a source of {@link AreaSelectedEvent} events,
 * which are fired whenever the current area is changed.</p>
 */
@FacesComponent("DemoMap")
public class MapComponent extends UICommand {
    private String current = null;

    public MapComponent() {
        super();
    }

    /**
     * <p>Return the alternate text label for the currently selected
     * child {@link AreaComponent}.</p>
     */
    public String getCurrent() {
        return (this.current);
    }

    /**
     * <p>Set the alternate text label for the currently selected child.
     * If this is different from the previous value, fire an
     * {@link AreaSelectedEvent} to interested listeners.</p>
     *
     * @param current The new alternate text label
     */
    public void setCurrent(String current) {
        if (this.getParent() == null) {
            return;
        }

        String previous = this.current;
        this.current = current;

        // Fire an {@link AreaSelectedEvent} if appropriate
        if ((previous == null) && (current == null)) {
            // do nothing
        } else if ((previous != null)
                && (current != null)
                && (previous.equals(current))) {
            // do nothing
        } else {
            this.queueEvent(new AreaSelectedEvent(this));
        }
    }

    /**
     * <p>Return the component family for this component.</p>
     */
    @Override
    public String getFamily() {
        return ("Map");
    }

    /**
     * <p>Return the state to be saved for this component.</p>
     *
     * @param context <code>FacesContext</code> for the current request
     */
    @Override
    public Object saveState(FacesContext context) {
        Object[] values = new Object[2];
        values[0] = super.saveState(context);
        values[1] = current;

        return (values);
    }

    /**
     * <p>Restore the state for this component.</p>
     *
     * @param context <code>FacesContext</code> for the current request
     * @param state   State to be restored
     *
     * @throws IOException if an input/output error occurs
     */
    @Override
    public void restoreState(
        FacesContext context,
        Object state) {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        current = (String) values[1];
    }
}
