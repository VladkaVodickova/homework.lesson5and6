package com.engeto.homework.plants;

import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PlantList {
    private List<Plant> plantList;

    public PlantList() {
        plantList = new ArrayList<>();
    }

    public void addPlant (Plant plant){
        plantList.add(plant);
    }

    public void removePlant (Plant plant){
        plantList.remove(plant);
    }

    public void loadPlantsFromFile(String filePath) throws IOException, PlantException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");

                String name = parts[0];
                String notes = parts[1];
                int wateringFrequency = Integer.parseInt(parts[2]);
                LocalDate wateringDate = LocalDate.parse(parts[3]);
                LocalDate plantedDate = LocalDate.parse(parts[4]);

                Plant plant = new Plant(name, notes, plantedDate, wateringDate, wateringFrequency);
                plantList.add(plant);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File not found: " + filePath);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + filePath, e);
        } catch (DateTimeParseException e){
            throw new PlantException("Invalid date format: " + e.getMessage());
        } catch (NumberFormatException e){
            throw new PlantException("Invalid number format: " + e.getMessage());
        }
    }

    public void savePlantsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Plant plant : plantList) {
                writer.write(plant.getName() + "\t" + plant.getNotes() + "\t" + plant.getFrequencyOfWatering() + "\t" + plant.getWatering() + "\t" + plant.getPlanted());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error writing to file: " + filename, e);
        }
    }

    public String getWateringInfo(){
        StringBuilder wateringInfo = new StringBuilder();
        for (Plant plant: plantList){
            wateringInfo.append(plant.getWateringInfo()).append("\n");
        }
        return wateringInfo.toString();
    }

    public Plant getFlowerByName(String name){
        for (Plant plant: plantList){
            if (plant.getName().equals(name)){
                return plant;
            }
        }
        return null;
    }
}