import com.engeto.homework.plants.Plant;
import com.engeto.homework.plants.PlantException;
import com.engeto.homework.plants.PlantList;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, PlantException {
        PlantList plantList = new PlantList();
        plantList.loadPlantsFromFile("C:/Users/Vladk/IdeaProjects/homework.lesson5and6/kvetiny.txt");

        plantList.addPlant(new Plant("Lilie"));
        plantList.addPlant(new Plant("Koriandr", "krásně voní", LocalDate.of(2023,6,15),LocalDate.of(2023,6,30),5));
        plantList.removePlant(plantList.getFlowerByName("Sukulent v koupelně"));

        System.out.println(plantList.getWateringInfo());
        //plantList.savePlantsToFile("PlantList.txt");

        plantList.sortPlantsByName();
        System.out.println(plantList.getWateringInfo());
        plantList.sortPlantsByLastWatered();
        System.out.println(plantList.getWateringInfo());
        System.out.println(plantList.getPlantedInfo());
        System.out.println(plantList.getPlantedLastMonthInfo());
    }
}
