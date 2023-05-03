package utils;

import entity.Additional;
import entity.Lecture;
import entity.ResourceType;
import repository.AdditionalRepo;

public class AdditionalUtils {
    AdditionalRepo additionalRepo = new AdditionalRepo();

    public void createAdditional() {
        for (int j = 0; j < 100; j++) {
            if (j == 3) {
                break;
            }
            Additional additional = new Additional();
            additional.setId(Additional.getCount());
            additional.setName("Additional" + Additional.getCount());
            additional.setLectureId(Lecture.getCount());
            additional.setResourceType((ResourceType) ResourceType.resourceType());

            additionalRepo.add(additional);

        }
        for (int i = 0; i < additionalRepo.size(); i++) {
            System.out.println("Index " + i + " " + additionalRepo.get(i));
        }
    }

}