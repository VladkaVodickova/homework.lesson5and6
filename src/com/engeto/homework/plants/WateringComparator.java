package com.engeto.homework.plants;

import java.util.Comparator;

public class WateringComparator implements Comparator<Plant> {

    @Override
    public int compare(Plant plant, Plant otherPlant ) {
        return plant.getWatering().compareTo(otherPlant.getWatering());
    }
}
