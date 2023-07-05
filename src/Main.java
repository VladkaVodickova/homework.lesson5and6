import com.engeto.homework.plants.Plant;
import com.engeto.homework.plants.PlantException;
import com.engeto.homework.plants.PlantList;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, PlantException {
        PlantList plantList = new PlantList();
        plantList.loadPlantsFromFile("C:/Users/xxx/IdeaProjects/homework.lesson5and6/kvetiny-spatne-frekvence.txt");

        //plantList.addPlant(new Plant("Lilie"));
        //plantList.addPlant(new Plant("Koriandr", LocalDate.now(),5));
        //plantList.removePlant(plantList.getFlowerByName("Sukulent v koupelně"));

        System.out.println(plantList.getWateringInfo());
        //plantList.savePlantsToFile("PlantList.txt");
    }
}
