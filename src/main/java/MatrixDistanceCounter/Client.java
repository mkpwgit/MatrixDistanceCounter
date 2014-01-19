package MatrixDistanceCounter;

import MatrixDistanceCounter.fileprocessing.FileProcessing;
import MatrixDistanceCounter.model.City;
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
    public static final String EXTERNAL_RESULT_PATH = "result-distance-external.txt";
    public static final String INNER_RESULT_PATH = "result-distance-inner.txt";


    public static void main(String[] args) throws IOException {
        FileProcessing fileProcessing = new FileProcessing(CITIES_PATH, true);
        List<Region> regions = fileProcessing.readCities(11);

        FileProcessing fileProcessing2 = new FileProcessing(REGIONS_PATH, true);
        fileProcessing2.readRegions(regions, 11);

        FileProcessing readDistanceProcessing = new FileProcessing(DISTANCES_PATH, true);
        Distances distances = new Distances(readDistanceProcessing.readDistances());

        /*for (Region region : regions)
            System.out.println(region);*/

//        writeResultInner(regions, distances);
        writeResultExternal(regions, distances);

    }

    public static void writeResultExternal(List<Region> regions, Distances distances) throws IOException {
        FileProcessing writeResultProcessing = new FileProcessing(EXTERNAL_RESULT_PATH, false);
        for (int i = 0; i < regions.size(); i++) {
            for (int j = i + 1; j < regions.size(); j++) {
                Region originRegion = regions.get(i);
                Region destRegion = regions.get(j);
                for (int y = 0; y < 11; y++) {
                    Double resultSumDistance = 0d;
                    for (int k = 0; k < originRegion.getCities().size(); k++) {
                        Double sumDistance = 0d;
                        City originCity = originRegion.getCities().get(k);
                        Double gdp = (originCity.getGDPs().get(y)
                                / originRegion.getGDPs().get(y));
                        for (int l = 0; l < destRegion.getCities().size(); l++) {

                            City destCity = destRegion.getCities().get(l);

                            Double distance = distances.findDistance(originCity.getCity(), originRegion.getName(),
                                    destCity.getCity(), destRegion.getName());

                            sumDistance += (destCity.getGDPs().get(y) /
                                    destRegion.getGDPs().get(y)) / distance;

                        }
                        sumDistance *= gdp;
                        resultSumDistance += sumDistance;
                    }
                    writeResultProcessing.writeResultLine(originRegion.getName(), destRegion.getName(), resultSumDistance);
                }
            }
        }
        writeResultProcessing.closeResource();
    }

    public static void writeResultInner(List<Region> regions, Distances distances) throws IOException {
        FileProcessing writeResultProcessing = new FileProcessing(INNER_RESULT_PATH, false);
        for (Region region : regions) {
            for (int y = 0; y < 11; y++) {
                Double resultSumDistance = 0d;
                for (int k = 0; k < region.getCities().size(); k++) {
                    Double sumDistance = 0d;
                    City originCity = region.getCities().get(k);
                    Double gdp = originCity.getGDPs().get(y) / region.getGDPs().get(y);
                    for (int l = 0; l < region.getCities().size(); l++) {

                        City destCity = region.getCities().get(l);
                        Double distance;
                        if (k != l) {
                            distance = distances.findDistance(originCity.getCity(), region.getName(),
                                    destCity.getCity(), region.getName());

                        } else {
                            distance = 10.84701;
                        }

                        sumDistance += (destCity.getGDPs().get(y) /
                                region.getGDPs().get(y)) * distance;
                    }
                    sumDistance *= gdp;
                    resultSumDistance += sumDistance;
                }
                writeResultProcessing.writeResultLine2(region.getName(), resultSumDistance);
            }
        }
        writeResultProcessing.closeResource();
    }
}
