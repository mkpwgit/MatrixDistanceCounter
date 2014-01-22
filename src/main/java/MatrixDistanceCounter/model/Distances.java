package MatrixDistanceCounter.model;

import java.util.List;

/**
 * @author Mikalai Kisel
 */
public class Distances {

    private List<Distance> distances;

    public Distances(List<Distance> distances) {
        this.distances = distances;
    }

    public Double findDistance(String originCity, String originRegion, String destCity, String destRegion) {
        for (Distance distance : distances) {
//            System.out.println("enter");
//            System.out.println("originCity"+ originCity+" destination city: "+destCity);
            if (distance.getRegionNameOrigin().equalsIgnoreCase(originRegion) &&
                    distance.getCityNameOrigin().equalsIgnoreCase(originCity)) {
                if (distance.getRegionNameDestination().equalsIgnoreCase(destRegion) &&
                        distance.getCityNameDestination().equalsIgnoreCase(destCity)) {
                    return distance.getDistance();
                }
            }

            if (distance.getRegionNameOrigin().equalsIgnoreCase(destRegion) &&
                    distance.getCityNameOrigin().equalsIgnoreCase(destCity)) {
                if (distance.getRegionNameDestination().equalsIgnoreCase(originRegion) &&
                        distance.getCityNameDestination().equalsIgnoreCase(originCity)) {
                    return distance.getDistance();
                }
            }

            if (distance.getRegionNameDestination().equalsIgnoreCase(destRegion) &&
                    distance.getCityNameDestination().equalsIgnoreCase(destCity)) {
                if (distance.getRegionNameOrigin().equalsIgnoreCase(originRegion) &&
                        distance.getCityNameOrigin().equalsIgnoreCase(originCity)) {
                    return distance.getDistance();
                }
            }

            if (distance.getRegionNameDestination().equalsIgnoreCase(originRegion) &&
                    distance.getCityNameDestination().equalsIgnoreCase(destCity)) {
                if (distance.getRegionNameOrigin().equalsIgnoreCase(originRegion) &&
                        distance.getCityNameOrigin().equalsIgnoreCase(originCity)) {
                    return distance.getDistance();
                }
            }

        }

        return 1.0;
    }

    public List<Distance> getDistances() {
        return distances;
    }

    public void setDistances(List<Distance> distances) {
        this.distances = distances;
    }
}
