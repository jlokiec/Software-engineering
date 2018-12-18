package service;

import dao.DaoException;
import dao.OrderDao;
import dao.ProductDao;
import dao.RatingDao;
import model.Order;
import model.Product;
import model.Rating;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ratings")
public class RatingService {
    // paths
    private static final String PATH_GET_AVERAGE = "get_average";
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String ID = "id";

    @GET
    @Path("/{" + ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam(ID) int id) {
        RatingDao dao = new RatingDao();
        Rating rating = dao.read(id);
        if (rating == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(rating).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(final Rating rating) {
        RatingDao dao = new RatingDao();
        try {
            Rating createdRating = dao.create(rating);
            return Response.ok(createdRating.getId()).build();
        } catch (DaoException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{" + ID + "}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRating(final Rating ratingToUpdate, @PathParam(ID) int id) {
        RatingDao dao = new RatingDao();
        Rating updatedRating = dao.update(ratingToUpdate);
        if (updatedRating == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedRating).build();
    }

    @GET
    @Path("/" + PATH_GET_AVERAGE)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAverage() {
        RatingDao dao = new RatingDao();
        int average = dao.getAverage();
        return Response.ok(average).build();
    }

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRatings() {
        RatingDao dao = new RatingDao();
        List<Rating> ratings = dao.getAll();

        return Response.ok(ratings).build();
    }
}
