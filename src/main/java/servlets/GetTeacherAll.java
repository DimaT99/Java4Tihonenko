package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.PostgreSqlRepo;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/getTeacherAll")
public class GetTeacherAll extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        PostgreSqlRepo.getAllTeacher().forEach(teacher -> out.println("<h1>" + teacher + "</h1>"));
        out.println("<br/><a href=\"getTeacher\">Get teacher by id</a>");
        out.println("<br/><a href=\"getAll\">Return to main</a>");
        out.println("</body></html>");
        out.close();
    }
}
