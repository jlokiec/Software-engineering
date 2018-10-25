package service;

import dao.AddressDao;
import model.Address;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/address")
public class AddressService {
    // parameters
    private static final String ID = "id";

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAddress(final Address address, @Context UriInfo uriInfo) {
        AddressDao dao = new AddressDao();
        Address createdAddress = dao.create(address);

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(createdAddress.getId()));

        return Response.created(uriBuilder.build()).build();
    }

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddressById(@PathParam(ID) int id) {
        AddressDao dao = new AddressDao();
        Address address = dao.read(id);

        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(address).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAddress(final Address addressToUpdate) {
        AddressDao dao = new AddressDao();
        Address updatedAddress = dao.update(addressToUpdate);

        if (updatedAddress == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(updatedAddress).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteAddress(@PathParam(ID) int id) {
        AddressDao dao = new AddressDao();

        if (dao.delete(id)) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}