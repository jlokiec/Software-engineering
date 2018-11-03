package service;

import dao.DiscountCodeExistsException;
import dao.DiscountDao;
import model.Discount;
import model.patch.DiscountActiveOnly;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/discounts")
public class DiscountService {
    // parameters
    private static final String ID = "id";

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDiscount(final Discount discount, @Context UriInfo uriInfo) {
        DiscountDao dao = new DiscountDao();

        try {
            Discount createdDiscount = dao.create(discount);

            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(createdDiscount.getId()));

            return Response.created(uriBuilder.build()).build();
        } catch (DiscountCodeExistsException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscountById(@PathParam(ID) int id) {
        DiscountDao dao = new DiscountDao();
        Discount discount = dao.read(id);

        if (discount == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(discount).build();
    }

    @PATCH
    @Path("/{" + ID + "}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDiscountActive(final DiscountActiveOnly discountActiveOnly, @PathParam(ID) int id) {
        DiscountDao dao = new DiscountDao();
        boolean newActive = discountActiveOnly.isActive();

        if (dao.updateActive(id, newActive)) {
            return Response.ok().build();
        }

        return Response.noContent().build();
    }
}
