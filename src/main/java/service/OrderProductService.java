package service;

import dao.DaoException;
import dao.OrderProductDao;
import model.OrderProduct;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/order_products")
public class OrderProductService {
    // paths
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String ID = "id";

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(final OrderProduct orderProduct) {
        OrderProductDao dao = new OrderProductDao();

        try {
            OrderProduct createdOrderProduct = dao.create(orderProduct);

            return Response.ok(createdOrderProduct.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{" + ID + "}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(final OrderProduct orderProductToUpdate, @PathParam(ID) int id) {
        OrderProductDao dao = new OrderProductDao();
        OrderProduct updatedOrderProduct = dao.update(orderProductToUpdate);

        if (updatedOrderProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(updatedOrderProduct).build();
    }

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam(ID) int id) {
        OrderProductDao dao = new OrderProductDao();
        OrderProduct orderProduct = dao.read(id);

        if (orderProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(orderProduct).build();
    }

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        OrderProductDao dao = new OrderProductDao();
        List<OrderProduct> orderProducts = dao.getAll();

        return Response.ok(orderProducts).build();
    }
}
