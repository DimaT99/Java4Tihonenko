package servlets;

import entity.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AbstractRepository;
import repository.PostgreSqlRepo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(value = "/getCourse", initParams = @WebInitParam(name = "id", value = "0"))
public class GetCourse extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext(AbstractRepository.class);
    PostgreSqlRepo postgreSqlRepo = context.getBean(PostgreSqlRepo.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        if (id == null) {
            id = getInitParameter("id");
        }
        List<Course> courseList = postgreSqlRepo.getAllCourse();
        Course course = null;
        for(int i = 0; i < courseList.size(); i++) {
            if(Integer.parseInt(id) == courseList.get(i).getId())
                course = courseList.get(i);
        }
        PrintWriter writer = resp.getWriter();
        if (course == null){
            writer.println("<h2>Enter id</h2>");
        } else {
            writer.println("<h2>" + course + "</h2>");
        }
        writer.close();
    }
}
