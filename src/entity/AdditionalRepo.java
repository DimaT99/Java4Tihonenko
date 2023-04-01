package entity;

public class AdditionalRepo extends SuperRepo{
    private static Additional[] additionals;
    public void createAdditionalMas() {
        additionals = new Additional[1];
    }

    public static Additional[] getAdditionals() {
        return additionals;
    }
}
