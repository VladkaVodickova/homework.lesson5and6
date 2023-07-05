package com.engeto.homework.plants;

import java.time.LocalDate;
import java.util.List;

public class Plant implements Comparable<Plant>{
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this.name = name;
        this.notes = "";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name) {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        LocalDate plantingDate = getPlanted();
        if (watering.isBefore(plantingDate)) {
            throw new PlantException("The last watering date cannot be earlier than the planting date.");
        }
        this.watering = watering;
    }
    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Enter a valid number of days greater than 0.");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    //methods
    public String getWateringInfo(){
        LocalDate nextWatering = watering.plusDays(frequencyOfWatering);
        return "Flower: "+ name + "\nLast watering: " + watering + "\nNext watering: " + nextWatering;
    }

    @Override
    public int compareTo(Plant otherPlant) {
        return this.name.compareTo(otherPlant.getName());
    }
}
