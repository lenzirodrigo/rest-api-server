package com.lenzi.server.webapp;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.lenzi.server.persistence.dao.CustomerDao;
import com.lenzi.server.persistence.model.Customer;

@Path("/hello")
public class HelloWorld {

    @Inject
    private CustomerDao customerDao;

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        System.out.println(customerDao.sayHola());
        return input;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
        input.setVal2(input.getVal1());
        return Response.ok().entity(input).build();
    }

    @GET
    @Path("/customer/{id}")
    @Produces("text/plain")
    public String getCustomerName(@PathParam("id") Long id) {
        Customer customer = customerDao.getCustomerBy(id);

        return customer.getName();
    }

}

