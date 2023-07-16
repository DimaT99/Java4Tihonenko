import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import repository.AdditionalRepo;
import utils.*;

@Configuration
public class Config {
    @Scope("singleton")
    @Bean
    public AdditionalRepo additionalRepo() {
        return new AdditionalRepo();
    }
    @Bean
    public ConsoleUtils consoleUtils() {
        return new ConsoleUtils();
    }
    @Bean
    public CourseUtils courseUtils() {
        return new CourseUtils();
    }
    @Bean
    public TeacherUtils teacherUtils() {
        return new TeacherUtils();
    }
    @Bean
    public StudentUtils studentUtils() {
        return new StudentUtils();
    }
    @Bean
    public LectureUtils lectureUtils() {
        return new LectureUtils();
    }
}
