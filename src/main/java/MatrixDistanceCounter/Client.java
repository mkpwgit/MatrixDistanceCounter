package MatrixDistanceCounter;

import MatrixDistanceCounter.fileprocessing.FileProcessing;
import MatrixDistanceCounter.model.City;
import MatrixDistanceCounter.model.Distance;
import MatrixDistanceCounter.model.Distances;
import MatrixDistanceCounter.model.Region;

import java.io.IOException;
import java.util.List;

/**
 * @author Mikalai Kisel
 */
public class Client {

    public static final String CITIES_PATH = "powiaty.txt";
    public static final String REGIONS_PATH = "wojewodstwa.txt";
    public static final String DISTANCES_PATH = "result1-10.txt";
    public static final String RESULT_PATH = "result-distance.txt";


    public static void main(String[] args) throws IOException {
        FileProcessing fileProcessing = new FileProcessing(CITIES_PATH, true);
        List<Region> regions = fileProcessing.readCities(11);

        FileProcessing fileProcessing2 = new FileProcessing(REGIONS_PATH, true);
        fileProcessing2.readRegions(regions, 11);

        FileProcessing readDistanceProcessing = new FileProcessing(DISTANCES_PATH, true);
        Distances distances = new Distances(readDistanceProcessing.readDistances());

        /*for (Region region : regions)
            System.out.println(region);*/

        writeResult(regions, distances);

    }

    public static void writeResult(List<Region> regions, Distances distances) throws IOException {
        FileProcessing writeResultProcessing = new FileProcessing(RESULT_PATH, false);
        for (int i = 0; i < regions.size(); i++) {
            System.out.println(i+"!!!!!!!!!!!!!!!!!!!!!");
            for (int j = i + 1; j < regions.size(); j++) {
                Region originRegion = regions.get(i);
                Region destRegion = regions.get(j);
                for (int y = 0; y < 11; y++) {
                    Double sumDistance = 0d;
                    for (int k = 0; k < originRegion.getCities().size(); k++) {
                        for (int l = 0; l < destRegion.getCities().size(); l++) {
                            City originCity = originRegion.getCities().get(k);
                            City destCity = destRegion.getCities().get(l);

                            Double distance = distances.findDistance(originCity.getCity(), originRegion.getName(),
                                    destCity.getCity(), destRegion.getName());
                            System.out.println(originCity.getCity()+ " "+destCity.getCity()+"Distance: "+distance);

                            sumDistance += (originCity.getGDPs().get(y)
                                    / originRegion.getGDPs().get(y)) *
                                    (destCity.getGDPs().get(y) /
                                            destRegion.getGDPs().get(y)) * distance;
                            System.out.println("Total sum: "+sumDistance );

                        }
                    }
                    System.out.println(originRegion.getName()+" "+destRegion.getName()+ "Result sum!!!!!! "+sumDistance);
                    writeResultProcessing.writeResultLine(originRegion.getName(), destRegion.getName(), sumDistance);
                }
            }
        }
        writeResultProcessing.closeResource();
    }
}
