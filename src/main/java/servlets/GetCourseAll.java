package servlets;

import jakarta.servlet.ServletException;
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

@WebServlet(value = "/getCourseAll")
public class GetCourseAll extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext(AbstractRepository.class);
    PostgreSqlRepo postgreSqlRepo = context.getBean(PostgreSqlRepo.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        postgreSqlRepo.getAllCourse().forEach(course -> out.println("<h1>" + course + "</h1>"));
        out.println("<br/><a href=\"getCourse\">Get course by id</a>");
        out.println("<br/><a href=\"getAll\">Return to main</a>");
        out.println("</body></html>");
        out.close();
    }
}
