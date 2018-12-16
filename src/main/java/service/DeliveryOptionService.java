package service;

import dao.DaoException;
import dao.DeliveryOptionDao;
import model.DeliveryOption;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/deliveryoption")
public class DeliveryOptionService {
    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryOptionById(@PathParam(ID) int id) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        DeliveryOption deliveryOption = dao.read(id);
        if (deliveryOption == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(deliveryOption).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createDeliveryOption(final DeliveryOption deliveryOption) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        try {
            DeliveryOption createdDeliveryOption = dao.create(deliveryOption);
            return Response.ok(createdDeliveryOption.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryOption(final DeliveryOption deliveryOptionToUpdate) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        DeliveryOption updatedDeliveryOption = dao.update(deliveryOptionToUpdate);
        if (updatedDeliveryOption == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedDeliveryOption).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteDeliveryOption(@PathParam(ID) int id) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        if (dao.delete(id)) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
