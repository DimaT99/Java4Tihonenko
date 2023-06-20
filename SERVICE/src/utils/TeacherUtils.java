package utils;


import entity.Teacher;

public class TeacherUtils {
    //private TeacherRepo teacherRepo = new TeacherRepo();

    public void createTeacher() {

        Teacher teacher = new Teacher();
        teacher.setId(Teacher.getCount());
        teacher.setName("Teacher" + Teacher.getCount());

        //teacherRepo.add(teacher);
        System.out.println(teacher);
    }
}
