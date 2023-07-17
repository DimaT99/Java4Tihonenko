package utils;

import entity.Additional;
import entity.Lecture;
import entity.ResourceType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import repository.AdditionalRepo;

@Component
public class AdditionalUtils {
    ApplicationContext context = new AnnotationConfigApplicationContext(AdditionalRepo.class);
    AdditionalRepo additionalRepo = context.getBean(AdditionalRepo.class);

    public void createAdditional() {
        Additional additional = new Additional();
        additional.setId(Additional.getCount());
        additional.setName("Additional" + Additional.getCount());
        additional.setLectureId(Lecture.getCount());
        additional.setResourceType((ResourceType) ResourceType.resourceType());
        additionalRepo.add(additional);
        additionalRepo.addMap(additional);
    }
}
