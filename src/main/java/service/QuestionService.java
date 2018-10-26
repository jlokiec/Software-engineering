package service;

import dao.QuestionDao;
import model.Question;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/questions")
public class QuestionService {
    // paths
    private static final String PATH_GET_ALL = "get_all";

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuestions() {
        QuestionDao dao = new QuestionDao();
        List<Question> questions = dao.getAll();

        return Response.ok(questions).build();
    }
}
