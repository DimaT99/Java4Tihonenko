package utils;

import entity.Additional;
import entity.AdditionalRepo;

public class AdditionalUtils {
    public void createAdditional() {
        Additional additional = new Additional();
        AdditionalRepo additionalRepo = new AdditionalRepo();
        additionalRepo.createAdditionalMas();
        AdditionalRepo.additionals[0] = additional;
        System.out.println(AdditionalRepo.additionals[0]);
    }

}