package service;

import dao.QuestionDao;
import model.Question;
import org.pmw.tinylog.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/questions")
public class QuestionService {
    // paths
    private static final String PATH_GET_ALL = "get_all";

    // parameters
    private static final String LOGIN = "login";

    @GET
    @Path("/" + PATH_GET_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuestions() {
        QuestionDao dao = new QuestionDao();
        List<Question> questions = dao.getAll();

        Logger.info("Sending list of {} questions", questions.size());

        return Response.ok(questions).build();
    }

    @GET
    @Path("/{" + LOGIN + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestionForLogin(@PathParam(LOGIN) String login) {
        QuestionDao dao = new QuestionDao();

        Question question = dao.getQuestionForLogin(login);

        if (question == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(question).build();
    }
}
