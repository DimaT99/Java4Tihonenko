package entity;

import utils.LectionUtils;

public class LectionRepo extends SuperRepo {
    private static Lection[] lections;

    public void createLectionMas() {
        lections = new Lection[Lection.getCount()];
    }

    public static Lection[] getLections() {
        return lections;
    }

    @Override
    public void getAll() {
        for (int i = 0; i < lections.length; i++) {
            System.out.println(lections[i]);
        }
    }

    @Override
    public void add() {
        LectionUtils lectionUtils = new LectionUtils();
        lectionUtils.createLection();
    }

    @Override
    public void getByld() {
        if (lections == null) {
            System.out.println(0);
            return;
        } else {
            for (int i = 0; i < lections.length; i++) {
                Lection lection = lections[i];
                if (lection.getId() == 2) {
                    System.out.println(lection);
                }
            }
            System.out.println(lections[1]);
        }
    }

    @Override
    public void deleteByld() {
        Lection[] lections1 = new Lection[lections.length - 1];
        for (int i = 0; i < lections1.length; i++) {
            if (i >= 1) {
                lections1[i] = lections[i + 1];
                continue;
            }
            lections1[i] = lections[i];
        }
        for (int i = 0; i < lections1.length; i++) {
            System.out.println(lections1[i]);
        }
    }
}