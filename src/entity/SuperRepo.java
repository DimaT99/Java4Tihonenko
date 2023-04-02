package entity;

public class SuperRepo {
    private static SuperRepo[] superRepos;

    public static SuperRepo[] getSuperRepos() {
        return superRepos;
    }

    public void getAll() {
        getSuperRepos();
        System.out.println(superRepos);
    }

    public void add() {
        SchoolSuper schoolSuper = new SchoolSuper(1, "SchoolSuper");
        schoolSuper.createObject();
        System.out.println(schoolSuper);
    }

    public void getByld() {
        for (int i = 0; i < superRepos.length; i++) {
            if (superRepos == null) {
                System.out.println(0);
                return;
            } else {
                SchoolSuper schoolSuper = new SchoolSuper();
                SuperRepo superRepo = superRepos[i];
                if (schoolSuper.getId() == 2) {
                    System.out.println(superRepo);
                }
            }
            System.out.println(superRepos[1]);
        }
    }

    public void deleteByld() {
        SuperRepo[] superRepos1 = new SuperRepo[superRepos.length - 1];
        for (int i = 0; i < superRepos1.length - 1; i++) {
            if (i >= 1) {
                superRepos1[i] = superRepos[i + 1];
                continue;
            }
            superRepos1[i] = superRepos[i];
        }
        for (int i = 0; i < superRepos1.length; i++) {
            System.out.println(superRepos1[i]);
        }
    }
}