import com.engeto.plant.Plant;
import com.engeto.plant.PlantException;
import com.engeto.plant.FlowerList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        FlowerList flowerList = new FlowerList();

        listOfValues(flowerList);
        System.out.println(" ");
        System.out.println("Sorted by watering info:");
        getWateringInfo(flowerList);
        System.out.println(" ");

        addPlant(flowerList);


        printToFile(flowerList, "resources/outPutFile.txt");
        readFromFile(flowerList, "resources/outPutFile.txt");
        getInfo(flowerList);
        Collections.sort(flowerList.getPlants());
        System.out.println(" ");
        System.out.println("Extract and load from file:");
        getInfo(flowerList);


        List<Plant> plants = flowerList.getPlants();
        Collections.sort(plants);
        System.out.println(" ");
        System.out.println("Sorted by name:");
        for (Plant plant : plants) {
            System.out.println(plant.getInfo());
        }
        System.out.println(" ");

        List<Plant> plants2 = new ArrayList<>();
        plants2.addAll(flowerList.getPlants());
        Collections.sort(plants2, Comparator.comparing(Plant::getPlantWatering));
        System.out.println("Seřazeno podle datumu poslední zálivky:");
        for (Plant plant : plants2) {
            System.out.println(plant.getPlantWatering());
        }
    }

    private static void addPlant(FlowerList flowerList) {
        System.out.println("Add and delete plants:");
        try {
            flowerList.addPlant(new Plant("Růže", "červená", LocalDate.of(2024, 1, 1),
                    LocalDate.of(2024, 1, 5), 4));
        } catch (PlantException e) {
            System.err.println("Error add plant:" + e.getMessage());
        }
        try {
            flowerList.addPlant(new Plant("Tulipán", "modrý", LocalDate.of(2024, 5, 1),
                    LocalDate.of(2024, 5, 5), 9));
        } catch (PlantException e) {
            System.err.println("Error add plant:" + e.getMessage());
        }
        flowerList.removePlant(2);
    }

    private static void listOfValues(FlowerList flowerList) {
        System.out.println(" ");
        readFromFile(flowerList,"resources/kvetiny.txt");
        System.out.println("listing the values of the loaded file:");
        getInfo(flowerList);
    }

    private static void getWateringInfo(FlowerList flowerList) {
        for (Plant plant : flowerList.getPlants()) {
            System.out.println(plant.getWateringInfo());
        }
    }

    private static void getInfo(FlowerList flowerList) {
        for (Plant plant : flowerList.getPlants()) {
            System.out.println(plant.getInfo());
        }
    }

    private static void printToFile(FlowerList flowerList, String outPutFile) {
        try {
        flowerList.printContentToFile(outPutFile,"\t");
        } catch (PlantException e){
            System.err.println("Error printing content:" + e.getMessage());
        }
    }

    private static void readFromFile(FlowerList flowerList,String filename) {
        try {
            flowerList.readContentFromFile(filename,"\t");
        } catch (PlantException e) {
            System.err.println("Error reading content:" + e.getMessage());
        }
    }
}



