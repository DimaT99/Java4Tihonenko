package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/getAll")
public class GetAll extends HttpServlet {
    private String message;
    public void init() {
        message = "All data from school online";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"getCourseAll\">Courses</a><br/>");
        out.println("<a href=\"getTeacherAll\">Teachers</a><br/>");
        out.println("<a href=\"getLectureAll\">Lectures</a><br/>");
        out.println("</body></html>");
    }
}
