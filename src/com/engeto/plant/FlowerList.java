package com.engeto.plant;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class FlowerList {

    private List<Plant> plants;

    public FlowerList (){
          plants = new ArrayList<>();
    }

    public List<Plant> getPlant() {
        return new ArrayList<>(plants);
    }

    public void addPlant(Plant plant){
        plants.add(plant);
    }

    public void addPlants (List<Plant> newPlans){
        plants.addAll(newPlans);
    }

    public void removePlant(Plant plant){
        plants.remove(plant);
    }

    public void removePlant(int index){
        plants.remove(index);
    }

    public void readContentFromFile(String filename, String delimiter) throws PlantException {
        FlowerList flowerList = new FlowerList();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            plants.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(delimiter);
                if (parts.length != 5) {
                    throw new PlantException("Line format error: " + line + "incorrect number of items ");
                }
                String name = parts[0];
                String notes = parts[1];
                int wateringFrequency = Integer.parseInt(parts[2]);
                LocalDate plantWatering = LocalDate.parse(parts[3]);
                LocalDate planted = LocalDate.parse(parts[4]);

                plants.add(new Plant(name, notes, planted, plantWatering, wateringFrequency));
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("File " + filename + "not found:" + e.getMessage());
        }
    }
}