package service;

import dao.UserDao;
import model.User;
import model.patch.UserActiveOnly;
import model.patch.UserLoggedInOnly;
import model.patch.UserPasswordOnly;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/users")
public class UserService {
    // paths
    private static final String PATH_ACTIVE = "active";
    private static final String PATH_LOGGED_IN = "logged_in";
    private static final String PATH_PASSWORD = "password";

    // parameters
    private static final String ID = "id";

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user, @Context UriInfo uriInfo) {
        UserDao userDao = new UserDao();
        User createdUser = userDao.create(user);

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(createdUser.getId()));

        return Response.created(uriBuilder.build()).build();
    }

    // docelowo do usunięcia
    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam(ID) int id) {
        UserDao dao = new UserDao();
        User user = dao.read(id);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(user).build();
    }

    @PATCH
    @Path("/{" + ID + "}/" + PATH_ACTIVE)
    public Response updateUserActive(final UserActiveOnly userActiveOnly, @PathParam(ID) int id) {
        UserDao dao = new UserDao();

        if (dao.updateActive(userActiveOnly, id)) {
            return Response.ok().build();
        }

        return Response.noContent().build();
    }

    @PATCH
    @Path("/{" + ID + "}/" + PATH_LOGGED_IN)
    public Response updateUserLoggedIn(final UserLoggedInOnly userLoggedInOnly, @PathParam(ID) int id) {
        UserDao dao = new UserDao();

        if (dao.updateLoggedIn(userLoggedInOnly, id)) {
            return Response.ok().build();
        }

        return Response.noContent().build();
    }

    @PATCH
    @Path("/{" + ID + "}/" + PATH_PASSWORD)
    public Response updateUserPassword(final UserPasswordOnly userPasswordOnly, @PathParam(ID) int id) {
        UserDao dao = new UserDao();

        if (dao.updatePassword(userPasswordOnly, id)) {
            return Response.ok().build();
        }

        return Response.noContent().build();
    }
}
