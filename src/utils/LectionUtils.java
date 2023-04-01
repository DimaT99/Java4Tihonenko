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
            lection.setCourseId(CourseRepo.getCourses()[0].getId());
            lection.setId(Lection.getCount());
            lection.setName("Lecture" + Lection.getCount());
            if (Lection.getCount() == 1) {
                LectionRepo lectionRepo = new LectionRepo();
                lectionRepo.createLectionMas();
                LectionRepo.getLections()[0] = lection;
            } else {
                Lection[] lections = Arrays.copyOf(LectionRepo.getLections(), (LectionRepo.getLections().length * 3) / 2 + 1);
                for (int i = LectionRepo.getLections().length; i < lections.length; i++) {
                    lections[i] = lection;
                    LectionRepo lectionRepo = new LectionRepo();
                    lectionRepo.createLectionMas();
                    for (int a = 0; a < LectionRepo.getLections().length; a++) {
                        LectionRepo.getLections()[a] = lections[a];
                    }
                }
            }
        }
        for (int i = 0; i < LectionRepo.getLections().length; i++) {
            System.out.println("Index " + i + " " + LectionRepo.getLections()[i]);
        }
    }
}

