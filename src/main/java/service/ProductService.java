package service;

import dao.DaoException;
import dao.ProductDao;
import model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductService {
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam(ID) int id) {
        ProductDao dao = new ProductDao();
        Product product = dao.read(id);

        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(product).build();
    }

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        ProductDao dao = new ProductDao();
        List<Product> products = dao.getAll();

        return Response.ok(products).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createProduct(final Product product) {
        ProductDao dao = new ProductDao();
        try {
            Product createdProduct = dao.create(product);
            return Response.ok(createdProduct.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{" + ID + "}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(final Product productToUpdate, @PathParam(ID) int id) {
        ProductDao dao = new ProductDao();
        Product updatedProduct = dao.update(productToUpdate);
        if (updatedProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedProduct).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteProduct(@PathParam(ID) int id) {
        ProductDao dao = new ProductDao();

        if (dao.delete(id)) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

