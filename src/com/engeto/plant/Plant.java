package com.engeto.plant;
import java.time.LocalDate;


public class Plant implements Comparable<Plant> {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate plantWatering;
    private int wateringFrequency;

    public Plant(String name, String notes, LocalDate planted, LocalDate plantWatering, int wateringFrequency) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.plantWatering = plantWatering;
        this.wateringFrequency = wateringFrequency;
    }

    public Plant(String name, LocalDate planted, int wateringFrequency) {
        this.name = name;
        this.notes = null;
        this.planted = planted;
        this.plantWatering = LocalDate.now();
        this.wateringFrequency = wateringFrequency;
    }

    public Plant(String name) {
        this.name = name;
        this.notes = " ";
        this.planted = LocalDate.now();
        this.plantWatering = LocalDate.now();
        this.wateringFrequency = 7;
    }

    public void setPlantWatering() throws PlantException {
        if (plantWatering.isBefore(planted)) {
            throw new PlantException("the date of the last watering must not be older than the date of planting the plant.");
        }
    }

    public void setWateringFrequency() throws PlantException {
        if (wateringFrequency == 0 || wateringFrequency < 0) {
            throw new PlantException("the filling frequency must not be zero or a negative number");
        }
    }

    public String getWateringInfo() {
        return "name: " + name + " the date of the last watering: " + plantWatering + " date of recommended next watering: " + nextRecommendedWatering();
    }

    public LocalDate nextRecommendedWatering() {
        return plantWatering.plusDays(wateringFrequency);
    }

    public String getInfo() {
        return "name: " + name + " note: " + notes + " planted: " + planted + " plantWatering: " + plantWatering + " wateringFrequency: " + wateringFrequency;
    }

    public String exportData() {
        return name + "\t" + notes + "\t" + wateringFrequency + "\t" + planted + "\t" + plantWatering;
    }

    @Override
    public int compareTo(Plant plant) {
        return this.name.compareTo(plant.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getPlantWatering() {
        return plantWatering;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }
}

