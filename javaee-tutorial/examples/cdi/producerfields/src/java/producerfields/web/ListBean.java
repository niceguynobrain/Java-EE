/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package producerfields.web;

import producerfields.ejb.RequestBean;
import producerfields.entity.ToDo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;


@Named
@ConversationScoped
public class ListBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ToDo> toDos;
    @EJB
    private RequestBean request;
    @NotNull
    private String inputString;
    private ToDo toDo;

    public void createTask() {
        this.toDo = request.createToDo(inputString);
    }

    /**** GETTERS and SETTERS ****/
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public ToDo getToDo() {
        return toDo;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

    public List<ToDo> getToDos() {
        return request.getToDos();
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }
}
