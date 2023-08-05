package controller;

import entity.EnumRole;
import entity.Person;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.Menu;
import utils.StudentUtils;

@Controller
public class StudentController {


    private final StudentUtils studentUtils;

    private final Menu menu;

    @Autowired
    public StudentController(StudentUtils studentUtils, Menu menu) {
        this.studentUtils = studentUtils;
        this.menu = menu;
    }

    @RequestMapping("/mvc")
    @ResponseBody
    public String mvc() {
        return "Hello in a Spring MVC";
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("message", "Hello, World!");
        model.addAttribute("menu", menu.getMenuItems());
        return "hello";
    }

    @GetMapping("/form")
    public String showStudentForm(Model model) {
        model.addAttribute("menu", menu.getMenuItems());
        return "jadder";
    }

    @GetMapping("/all-students")
    public String home(Model model) {
        model.addAttribute("menu", menu.getMenuItems());
        model.addAttribute("students", studentUtils.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String type) {
        Student student = new Student();
        Person person = new Person();
        student.setName(name);
        person.setEmail(email);
        person.setEnumRole(EnumRole.STUDENT);
        studentUtils.save(student);
        return "redirect:/all-students";
    }
}
