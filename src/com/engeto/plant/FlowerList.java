package com.engeto.plant;

import java.util.ArrayList;
import java.util.List;

public class FlowerList {

        private List<Plant> plantList = new ArrayList<>();

    public FlowerList(List<Plant> plantList) {
        this.plantList.addAll(plantList);
    }

    public List<Plant> getPlantList() {
        return new ArrayList<>(plantList);
    }

    public void addPlantList(Plant plant) {
        this.plantList.add(plant);
    }

    public Plant getPlantIndex (int index) {
        return plantList.get(index);
    }

    public Plant deletePlantindex (int index){
        return plantList.remove(index);
    }

    }
