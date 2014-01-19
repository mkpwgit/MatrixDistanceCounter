package MatrixDistanceCounter.fileprocessing;

import MatrixDistanceCounter.model.City;
import MatrixDistanceCounter.model.Distance;
import MatrixDistanceCounter.model.Region;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileProcessing {

    private String filePath;
    private BufferedReader br;
    private BufferedWriter bw;

    public FileProcessing(String filePath, boolean input) throws IOException {
        this.filePath = filePath;
        if (input)
            br = new BufferedReader(new FileReader(filePath));
        else
            bw = new BufferedWriter(new FileWriter(filePath));
    }

    public List<Region> readCities(int yearCount) throws IOException {
        List<Region> regions = new ArrayList<Region>();
        Set<String> regionsName = new HashSet<String>();
        String line;
        Region currentRegion = null;
        while ((line = br.readLine()) != null) {
            String[] lineParts = line.split(",");
            String region = lineParts[0].trim();
            if (!regionsName.contains(region)) {
                regionsName.add(region);
                currentRegion = new Region(region);
                regions.add(currentRegion);
            }
            String cityName = lineParts[1].trim();
            City city = new City(cityName);
            for (int i = 0; i < yearCount; i++) {
                Double gdp = Double.valueOf(lineParts[i + 2].trim());
                city.addGdp(gdp);
            }

            currentRegion.addCity(city);

        }

        return regions;
    }

    public void readRegions(List<Region> regions, int years) throws IOException {
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] lineParts = line.split(",");
            String regionName = lineParts[0].trim();
            Region currentRegion = null;
            for (int i=0; i<regions.size(); i++) {
                System.out.println(regionName+" "+regions.get(i).getName());
                if (regionName.equalsIgnoreCase(regions.get(i).getName())) {
                    currentRegion = regions.get(i);
                    break;
                }
            }

            for (int i = 0; i < years; i++) {
                Double gdp = Double.valueOf(lineParts[i + 1].trim());
                currentRegion.addGdp(gdp);
            }
        }
    }

    public List<Distance> readDistances() throws IOException {
        String line = null;
        List<Distance> distances = new ArrayList<Distance>();
        while ((line = br.readLine()) != null) {
            String[] lineParts = line.split(",");
            Distance distance = new Distance();

            distance.setCityNameOrigin(lineParts[0].trim());
            distance.setRegionNameOrigin(lineParts[1].trim());
            distance.setCityNameDestination(lineParts[2].trim());
            distance.setRegionNameDestination(lineParts[3].trim());
            distance.setDistance(Double.valueOf(lineParts[4].trim()));

            distances.add(distance);
        }

        return distances;
    }

    public void writeResultLine(String originRegion, String destRegion, Double totalDistance) throws IOException {
        StringBuilder resultLine = new StringBuilder();
        resultLine.append(originRegion).append(",").append(destRegion).append(",").append(totalDistance).append('\n');
        bw.write(new String(resultLine));
    }

    public void closeResource() throws IOException {
        bw.close();
    }

}
