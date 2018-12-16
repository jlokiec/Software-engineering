package service;

import dao.DaoException;
import dao.OrderDao;
import model.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/orders")
public class OrderService {
    // paths
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String ID = "id";

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(final Order order) {
        OrderDao dao = new OrderDao();

        try {
            Order createdOrder = dao.create(order);

            return Response.ok(createdOrder.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{" + ID + "}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final Order orderToUpdate, @PathParam(ID) int id) {
        OrderDao dao = new OrderDao();
        Order updatedOrder = dao.update(orderToUpdate);

        if (updatedOrder == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(updatedOrder).build();
    }

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam(ID) int id) {
        OrderDao dao = new OrderDao();
        Order order = dao.read(id);

        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(order).build();
    }

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.getAll();

        return Response.ok(orders).build();
    }
}
