package service;

import dao.DaoException;
import dao.DeliveryOptionDao;
import model.DeliveryOption;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/deliveryoption")
public class DeliveryOptionService {
    // paths
    private static final String PATH_CREATE = "create";
    private static final String PATH_UPDATE = "update";

    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryOptionById(@PathParam(ID) int id) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        DeliveryOption deliveryOption = dao.read(id);

        return Response.ok(deliveryOption).build();
    }

    @POST
    @Path("/" + PATH_CREATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryOption(final DeliveryOption deliveryOption) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        DeliveryOption createdDeliveryOption = null;
        try {
            createdDeliveryOption = dao.create(deliveryOption);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return Response.ok(createdDeliveryOption).build();
    }

    @PUT
    @Path("/" + PATH_UPDATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryOption(final DeliveryOption deliveryOptionToUpdate) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        DeliveryOption updatedDeliveryOption = dao.update(deliveryOptionToUpdate);

        return Response.ok(updatedDeliveryOption).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteDeliveryOption(@PathParam(ID) int id) {
        DeliveryOptionDao dao = new DeliveryOptionDao();
        dao.delete(id);

        return Response.ok().build();
    }
}
