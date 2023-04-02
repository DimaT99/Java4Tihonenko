package entity;

public class HomeworkRepo extends SuperRepo{
    private static Homework[] homeworks;

    public void createHomeworkMas() {
        homeworks = new Homework[1];
    }

    public static Homework[] getHomeworks() {
        return homeworks;
    }
}
