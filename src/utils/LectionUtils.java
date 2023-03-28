package utils;

import entity.*;

import java.util.Arrays;

public class LectionUtils {
    Course course;
    Homework homework;
    Additional additional;


    private Lection lection;

    public LectionUtils(Lection lection) {
        this.lection = lection;
        System.out.println(lection);
    }

    public LectionUtils() {

    }

    public void createLection() {

        for (int j = 0; j < 100; j++) {
            if (j == 3) {
                break;
            }
            Lection lection = new Lection();
            lection.courseId = CourseRepo.courses[0].getId();
            lection.setId(Lection.count);
            lection.setName("Lection" + Lection.count);
            if (Lection.count == 1) {
                LectionRepo lectionRepo = new LectionRepo();
                lectionRepo.createLectionMas();
                LectionRepo.lections[0] = lection;
            } else {
                Lection[] lections = Arrays.copyOf(LectionRepo.lections, (LectionRepo.lections.length * 3) / 2 + 1);
                for (int i = LectionRepo.lections.length; i < lections.length; i++) {
                    lections[i] = lection;
                    LectionRepo.lections = lections;
                    System.out.println(lections.length);
                }
                for (int i = 0; i < LectionRepo.lections.length; i++) {
                    System.out.println("Index i = " + lections[i]);
                }
            }
        }

    }

}

