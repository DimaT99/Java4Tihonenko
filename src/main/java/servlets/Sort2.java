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

@WebServlet(value = "/sort2")
public class Sort2 extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext(AbstractRepository.class);
    PostgreSqlRepo postgreSqlRepo = context.getBean(PostgreSqlRepo.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<style>\n" +
                "body {n" +
                "font-family: Montserrat;\n" +
                "font-size: 16px;\n" +
                "font-weight: 500;\n" +
                "}\n" +
                "h2:nth-child(odd) {\n" +
                "background-color: white;\n" +
                "}\n" +
                "h2:nth-child(even) {\n" +
                "background-color: green;\n" +
                "}\n" +
                "</style>\n" +
                "<body>\n");
        postgreSqlRepo.sort2().forEach(lecture -> out.println("<h2>" + lecture.getCourseId() + "  " +
                lecture.getId() + "  " + lecture.getName() + "  " + lecture.getDescription() + "  " + lecture.getLectureDate() + "</h2>"));
        out.println("<br/><a href=\"http://localhost:63342/Java4Tihonenko/servlets/html/start.html\">Return to main</a>");
        out.println("<br/><a href=\"getAll\">All information from online school</a>");
        out.println("</body></html>");
        out.close();
    }
}
