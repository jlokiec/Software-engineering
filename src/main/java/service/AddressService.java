package service;

import dao.AddressDao;
import model.Address;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/address")
public class AddressService {
    // paths
    private static final String PATH_CREATE = "create";
    private static final String PATH_UPDATE = "update";

    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddressById(@PathParam(ID) int id) {
        AddressDao dao = new AddressDao();
        Address address = dao.read(id);

        return Response.ok(address).build();
    }

    @POST
    @Path("/" + PATH_CREATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAddress(final Address address) {
        AddressDao dao = new AddressDao();
        Address createdAddress = dao.create(address);

        return Response.ok(createdAddress).build();
    }

    @PUT
    @Path("/" + PATH_UPDATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAddress(final Address addressToUpdate) {
        AddressDao dao = new AddressDao();
        Address updatedAddress = dao.update(addressToUpdate);

        return Response.ok(updatedAddress).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteAddress(@PathParam(ID) int id) {
        AddressDao dao = new AddressDao();
        dao.delete(id);

        return Response.ok().build();
    }
}