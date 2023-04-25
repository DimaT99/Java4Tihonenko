package utils;

import entity.Additional;
import repository.AdditionalRepo;

public class AdditionalUtils {
    public void createAdditional() {
        Additional additional = new Additional();
        AdditionalRepo additionalRepo = new AdditionalRepo();
        additionalRepo.createAdditionalMas();
        AdditionalRepo.getAdditionals()[0] = additional;
        System.out.println(AdditionalRepo.getAdditionals()[0]);
    }

}