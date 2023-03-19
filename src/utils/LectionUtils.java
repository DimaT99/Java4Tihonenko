package utils;

import entity.Additional;
import entity.Course;
import entity.Homework;
import entity.Lection;

public class LectionUtils {
    Course course;
    Homework homework;
    Additional additional;

private Lection lection;

    public LectionUtils(Lection lection) {
        this.lection = lection;
        System.out.println(lection);
    }

}
