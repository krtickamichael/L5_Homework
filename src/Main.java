import com.engeto.plant.Plant;
import com.engeto.plant.PlantException;
import com.engeto.plant.FlowerList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        FlowerList flowerList = new FlowerList();
        try {
            flowerList.readContentFromFile("resources/kvetiny.txt", "\t");
        } catch (PlantException e) {
            System.err.println("Error reading content:" + e.getMessage());
        }
        System.out.println(" ");
        for (Plant plant : flowerList.getPlant()) {
            System.out.println(plant.getInfo());
        }
        System.out.println(" ");
        for (Plant plant : flowerList.getPlant()) {
            System.out.println(plant.getWateringInfo());
        }
        flowerList.addPlant(new Plant("Růže", "červená", LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 5), 4));
        flowerList.addPlant(new Plant("Tulipán", "modrý", LocalDate.of(2024, 5, 1),
                LocalDate.of(2024, 5, 5), 9));
        flowerList.removePlant(2);

        System.out.println(" ");
        for (Plant plant : flowerList.getPlant()) {
            System.out.println(plant.getWateringInfo());
        }

        String outputdata = "resources/outputFile.txt";
        try (PrintWriter outputWriter = new PrintWriter(new FileWriter(outputdata))) {
            for (Plant plant : flowerList.getPlant()) {
                outputWriter.println(plant.exportData());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


