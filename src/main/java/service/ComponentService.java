package service;

import dao.ComponentDao;
import dao.DaoException;
import model.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/components")
public class ComponentService {
    private static final String PATH_GET_ALL = "get_all";

    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComponentById(@PathParam(ID) int id) {
        ComponentDao dao = new ComponentDao();
        Component component = dao.read(id);
        if (component == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(component).build();
    }

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllComponents() {
        ComponentDao dao = new ComponentDao();
        List<Component> components = dao.getAll();

        return Response.ok(components).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createComponent(final Component component) {
        ComponentDao dao = new ComponentDao();
        try {
            Component createdComponent = dao.create(component);
            return Response.ok(createdComponent.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateComponent(final Component componentToUpdate) {
        ComponentDao dao = new ComponentDao();
        Component updatedComponent = dao.update(componentToUpdate);
        if (updatedComponent == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedComponent).build();
    }

    @DELETE
    @Path("/{" + ID + "}")
    public Response deleteComponent(@PathParam(ID) int id) {
        ComponentDao dao = new ComponentDao();
        if (dao.delete(id)) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
