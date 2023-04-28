package repository;

import entity.Additional;

public class AdditionalRepo {
    private static Additional[] additionals;
    public void createAdditionalMas() {
        additionals = new Additional[1];
    }

    public static Additional[] getAdditionals() {
        return additionals;
    }
}
