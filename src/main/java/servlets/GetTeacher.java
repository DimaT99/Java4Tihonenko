package servlets;

import entity.Teacher;
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
import java.util.List;
@WebServlet(value = "/getTeacher")
public class GetTeacher extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext(AbstractRepository.class);
    PostgreSqlRepo postgreSqlRepo = context.getBean(PostgreSqlRepo.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        if (id == null) {
            id = getInitParameter("id");
        }
        List<Teacher> teacherList = postgreSqlRepo.getAllTeacher();
        Teacher teacher = null;
        for(int i = 0; i < teacherList.size(); i++) {
            if(Integer.parseInt(id) == teacherList.get(i).getId())
                teacher = teacherList.get(i);
        }
        PrintWriter writer = resp.getWriter();
        if (teacher == null){
            writer.println("<h2>Enter id</h2>");
        } else {
            writer.println("<h2>" + teacherList + "</h2>");
        }
        writer.close();
    }
}
