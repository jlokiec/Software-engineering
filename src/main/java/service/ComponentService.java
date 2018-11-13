package service;

import dao.ComponentDao;
import dao.DaoException;
import dao.ProductDao;
import model.Component;
import model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/component")
public class ComponentService {
    // paths
    private static final String PATH_CREATE = "create";
    private static final String PATH_UPDATE = "update";
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComponentById(@PathParam(ID) int id) {
        ComponentDao dao = new ComponentDao();
        Component component = dao.read(id);

        return Response.ok(component).build();
    }

    @GET
    @Path("/{" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllComponents() {
        ComponentDao dao = new ComponentDao();
        List<Component> components = dao.getAll();

        return Response.ok(components).build();
    }

    @POST
    @Path("/" + PATH_CREATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComponent(final Component component) {
        ComponentDao dao = new ComponentDao();
        Component createdComponent = null;
        try {
            createdComponent = dao.create(component);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return Response.ok(createdComponent).build();
    }

    @PUT
    @Path("/" + PATH_UPDATE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateComponent(final Component componentToUpdate) {
        ComponentDao dao = new ComponentDao();
        Component updatedComponent = dao.update(componentToUpdate);

        return Response.ok(updatedComponent).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteComponent(@PathParam(ID) int id) {
        ComponentDao dao = new ComponentDao();
        dao.delete(id);

        return Response.ok().build();
    }
}
