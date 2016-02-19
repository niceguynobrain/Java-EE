/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package dukesbookstore.taglib;

import dukesbookstore.components.MapComponent;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.webapp.UIComponentELTag;


/**
 * <p>{@link UIComponentELTag} for an image map.</p>
 */
public class MapTag extends UIComponentELTag {
    private MethodExpression action = null;
    private MethodExpression actionListener = null;
    private ValueExpression current = null;
    private ValueExpression immediate = null;
    private ValueExpression styleClass = null;

    public void setCurrent(ValueExpression current) {
        this.current = current;
    }

    public void setActionListener(MethodExpression actionListener) {
        this.actionListener = actionListener;
    }

    public void setAction(MethodExpression action) {
        this.action = action;
    }

    public void setImmediate(ValueExpression immediate) {
        this.immediate = immediate;
    }

    public void setStyleClass(ValueExpression styleClass) {
        this.styleClass = styleClass;
    }

    @Override
    public String getComponentType() {
        return ("DemoMap");
    }

    @Override
    public String getRendererType() {
        return ("DemoMap");
    }

    @Override
    public void release() {
        super.release();
        current = null;
        styleClass = null;
        actionListener = null;
        action = null;
        immediate = null;
        styleClass = null;
    }

    @Override
    protected void setProperties(UIComponent component) {
        super.setProperties(component);

        MapComponent map = (MapComponent) component;

        if (styleClass != null) {
            if (!styleClass.isLiteralText()) {
                map.setValueExpression("styleClass", styleClass);
            } else {
                map.getAttributes()
                   .put(
                    "styleClass",
                    styleClass.getExpressionString());
            }
        }

        if (actionListener != null) {
            map.addActionListener(
                    new MethodExpressionActionListener(actionListener));
        }

        if (action != null) {
            map.setActionExpression(action);
        }

        if (immediate != null) {
            if (!immediate.isLiteralText()) {
                map.setValueExpression("immediate", immediate);
            } else {
                map.setImmediate(
                        Boolean.valueOf(immediate.getExpressionString()).booleanValue());
            }
        }
    }
}
