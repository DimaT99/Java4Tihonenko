package servlets;

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
@WebServlet(value = "/getLectureAll")

public class GetLectureAll extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext(AbstractRepository.class);
    PostgreSqlRepo postgreSqlRepo = context.getBean(PostgreSqlRepo.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        postgreSqlRepo.getAllLecture().forEach(lecture -> out.println("<h1>" + lecture + "</h1>"));
        out.println("<br/><a href=\"getLecture\">Get lecture by id</a>");
        out.println("<br/><a href=\"getAll\">Return to main</a>");
        out.println("</body></html>");
        out.close();
    }
}
