package service;

import dao.DaoException;
import dao.OrderComponentDao;
import model.OrderComponent;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/order_components")
public class OrderComponentService {
    // paths
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String ID = "id";

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(final OrderComponent orderComponent) {
        OrderComponentDao dao = new OrderComponentDao();

        try {
            OrderComponent createdOrderComponent = dao.create(orderComponent);

            return Response.ok(createdOrderComponent.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{" + ID + "}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final OrderComponent orderComponentToUpdate, @PathParam(ID) int id) {
        OrderComponentDao dao = new OrderComponentDao();
        OrderComponent updatedOrderComponent = dao.update(orderComponentToUpdate);

        if (updatedOrderComponent == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(updatedOrderComponent).build();
    }

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam(ID) int id) {
        OrderComponentDao dao = new OrderComponentDao();
        OrderComponent orderComponent = dao.read(id);

        if (orderComponent == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(orderComponent).build();
    }

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        OrderComponentDao dao = new OrderComponentDao();
        List<OrderComponent> orderComponents = dao.getAll();

        return Response.ok(orderComponents).build();
    }
}
