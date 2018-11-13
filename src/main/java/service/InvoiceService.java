package service;

import dao.AddressDao;
import dao.DaoException;
import dao.InvoiceDao;
import model.Address;
import model.Invoice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/invoice")
public class InvoiceService {
    // paths
    private static final String PATH_CREATE = "create";
    private static final String PATH_UPDATE = "update";

    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInvoiceById(@PathParam(ID) int id) {
        InvoiceDao dao = new InvoiceDao();
        Invoice invoice = dao.read(id);

        return Response.ok(invoice).build();
    }

    @POST
    @Path("/" + PATH_CREATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInvoice(final Invoice invoice) {
        InvoiceDao dao = new InvoiceDao();
        Invoice createdInvoice = null;
        try {
            createdInvoice = dao.create(invoice);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return Response.ok(createdInvoice).build();
    }

    @PUT
    @Path("/" + PATH_UPDATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInvoice(final Invoice invoiceToUpdate) {
        InvoiceDao dao = new InvoiceDao();
        Invoice updatedInvoice = dao.update(invoiceToUpdate);

        return Response.ok(updatedInvoice).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteInvoice(@PathParam(ID) int id) {
        InvoiceDao dao = new InvoiceDao();
        dao.delete(id);

        return Response.ok().build();
    }
}
