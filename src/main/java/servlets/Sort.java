package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.PostgreSqlRepo;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/sort")
public class Sort extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        PostgreSqlRepo.sort().forEach(student -> out.println("<h2>" + student.getId() + "  " + student.getName() + "  " + student.getCourseId() + "</h2>"));
        out.println("<br/><a href=\"getAll\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}
