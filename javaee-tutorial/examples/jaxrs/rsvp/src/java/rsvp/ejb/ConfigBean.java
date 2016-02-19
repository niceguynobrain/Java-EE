/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package rsvp.ejb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rsvp.entity.Event;
import rsvp.entity.Person;
import rsvp.entity.Response;
import rsvp.util.ResponseEnum;


@Singleton
@Startup
public class ConfigBean {
    private static final Logger logger = Logger.getLogger(
                "rsvp.ejb.ConfigBean");
    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        // create the event owner
        Person dad = new Person();
        dad.setFirstName("Father");
        dad.setLastName("OfJava");
        em.persist(dad);

        // create the event
        Event event = new Event();
        event.setName("Duke's Birthday Party");
        event.setLocation("Top of the Mark");

        Calendar cal = new GregorianCalendar(2010, Calendar.MAY, 23, 19, 0);
        event.setEventDate(cal.getTime());
        em.persist(event);

        // set the relationships
        dad.getOwnedEvents()
           .add(event);
        dad.getEvents()
           .add(event);
        event.setOwner(dad);
        event.getInvitees()
             .add(dad);

        Response dadsResponse = new Response(
                    event,
                    dad,
                    ResponseEnum.ATTENDING);
        em.persist(dadsResponse);
        event.getResponses()
             .add(dadsResponse);

        // create some invitees
        Person duke = new Person();
        duke.setFirstName("Duke");
        duke.setLastName("OfJava");
        em.persist(duke);

        Person tux = new Person();
        tux.setFirstName("Tux");
        tux.setLastName("Penguin");
        em.persist(tux);

        // set the relationships
        event.getInvitees()
             .add(duke);
        duke.getEvents()
            .add(event);

        Response dukesResponse = new Response(event, duke);
        em.persist(dukesResponse);
        event.getResponses()
             .add(dukesResponse);
        duke.getResponses()
            .add(dukesResponse);

        event.getInvitees()
             .add(tux);
        tux.getEvents()
           .add(event);

        Response tuxsResponse = new Response(event, tux);
        em.persist(tuxsResponse);
        event.getResponses()
             .add(tuxsResponse);
        tux.getResponses()
           .add(tuxsResponse);
    }
}
