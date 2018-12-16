package service;

import dao.AddressDao;
import dao.DaoException;
import dao.InvoiceDao;
import model.Address;
import model.Invoice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/invoices")
public class InvoiceService {
    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInvoiceById(@PathParam(ID) int id) {
        InvoiceDao dao = new InvoiceDao();
        Invoice invoice = dao.read(id);
        if (invoice == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(invoice).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createInvoice(final Invoice invoice) {
        InvoiceDao dao = new InvoiceDao();
        try {
            Invoice createdInvoice = dao.create(invoice);
            return Response.ok(createdInvoice.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInvoice(final Invoice invoiceToUpdate) {
        InvoiceDao dao = new InvoiceDao();
        Invoice updatedInvoice = dao.update(invoiceToUpdate);
        if (updatedInvoice == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedInvoice).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteInvoice(@PathParam(ID) int id) {
        InvoiceDao dao = new InvoiceDao();
        if (dao.delete(id)) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
