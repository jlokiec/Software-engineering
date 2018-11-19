package service;

import dao.AppRatingDao;
import dao.DaoException;
import model.AppRating;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/app_rating")
public class AppRatingService {
    // paths
    private static final String PATH_AVERAGE_RATING = "avg";

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(final AppRating appRating, @Context UriInfo uriInfo) {
        AppRatingDao dao = new AppRatingDao();
        AppRating createdAppRating = null;

        try {
            createdAppRating = dao.create(appRating);
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(createdAppRating.getId()));

        return Response.created(uriBuilder.build()).build();
    }

    @GET
    @Path("/" + PATH_AVERAGE_RATING)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAverageRating() {
        AppRatingDao dao = new AppRatingDao();

        Double averageRating = dao.getAverageRating();

        return Response.ok(averageRating).build();
    }
}
