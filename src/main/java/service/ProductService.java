package service;

import dao.DaoException;
import dao.ProductDao;
import model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/product")
public class ProductService {
    // paths
    private static final String PATH_CREATE = "create";
    private static final String PATH_UPDATE = "update";
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam(ID) int id) {
        ProductDao dao = new ProductDao();
        Product product = dao.read(id);

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
    @Path("/" + PATH_CREATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(final Product product) {
        ProductDao dao = new ProductDao();
        Product createdProduct = null;
        try {
            createdProduct = dao.create(product);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return Response.ok(createdProduct).build();
    }

    @PUT
    @Path("/" + PATH_UPDATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(final Product productToUpdate) {
        ProductDao dao = new ProductDao();
        Product updatedProduct = dao.update(productToUpdate);

        return Response.ok(updatedProduct).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteProduct(@PathParam(ID) int id) {
        ProductDao dao = new ProductDao();
        dao.delete(id);

        return Response.ok().build();
    }
}

