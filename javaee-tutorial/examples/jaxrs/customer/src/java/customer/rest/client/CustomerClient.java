/*
 * Copyright 2012 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developers.sun.com/license/berkeley_license.html
 */


package customer.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import customer.xml.CustomerType;
import customer.xml.ObjectFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;


public class CustomerClient {
    public static final Logger logger = Logger.getLogger(
                CustomerClient.class.getCanonicalName());

    public static void main(String[] args) {
        Client client = Client.create();

        // Define the URL for testing the example application
        WebResource webResource = client.resource(
                    "http://localhost:8080/customer/Customer");

        ObjectFactory factory = new ObjectFactory();

        // Test the POST method
        CustomerType customerType = new CustomerType();

        customerType.setId(1);
        customerType.setFirstName("Duke");
        customerType.setLastName("OfJava");
        customerType.setCity("JavaTown");
        customerType.setCountry("USA");

        JAXBElement<CustomerType> customer = factory.createCustomer(
                    customerType);

        ClientResponse response = webResource.type("application/xml")
                                             .post(
                    ClientResponse.class,
                    customer);

        logger.log(
            Level.INFO,
            "POST status: {0}",
            response.getStatus());

        if (response.getStatus() == 201) {
            logger.info("POST succeeded");
        } else {
            logger.info("POST failed");
        }

        // Test the GET method using content negotiation
        response = webResource.path("1")
                              .accept(MediaType.APPLICATION_XML)
                              .get(ClientResponse.class);

        CustomerType entity = response.getEntity(CustomerType.class);

        logger.log(
            Level.INFO,
            "GET status: {0}",
            response.getStatus());

        if (response.getStatus() == 200) {
            logger.log(
                    Level.INFO,
                    "GET succeeded, city is {0}",
                    entity.getCity());
        } else {
            logger.info("GET failed");
        }

        // Test the DELETE method
        response = webResource.path("1")
                              .delete(ClientResponse.class);

        logger.log(
            Level.INFO,
            "DELETE status: {0}",
            response.getStatus());

        if (response.getStatus() == 204) {
            logger.info("DELETE succeeded (no content)");
        } else {
            logger.info("DELETE failed");
        }

        response = webResource.path("1")
                              .accept(MediaType.APPLICATION_XML)
                              .get(ClientResponse.class);
        entity = response.getEntity(CustomerType.class);

        logger.log(
            Level.INFO,
            "GET status: {0}",
            response.getStatus());

        try {
            logger.info(entity.getCity());
        } catch (NullPointerException ne) {
            // as expected, returns null because you have deleted the customer
            logger.log(
                Level.INFO,
                "After DELETE, city is: {0}",
                ne.getCause());
        }
    }
}
