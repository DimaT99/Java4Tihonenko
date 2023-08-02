package controller;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.StudentUtils;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class SuperController {

    private final StudentUtils studentUtils;

    @Autowired
    public SuperController(final StudentUtils studentUtils) {
        this.studentUtils = studentUtils;
    }

    @GetMapping(path = "", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Student>> getCategories() {
        List<Student> studentServiceAll = studentUtils.findAll();
        return new ResponseEntity<>(studentServiceAll, HttpStatus.OK);
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        studentUtils.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
