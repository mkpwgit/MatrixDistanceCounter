package MatrixDistanceCounter.model;

/**
 * @author Mikalai Kisel
 */
public class Distance {

    private String cityNameOrigin;
    private String regionNameOrigin;
    private String cityNameDestination;
    private String regionNameDestination;
    private Double distance;

    public Distance(String cityNameOrigin, String regionNameOrigin, String cityNameDestination, String regionNameDestination, Double distance) {
        this.cityNameOrigin = cityNameOrigin;
        this.regionNameOrigin = regionNameOrigin;
        this.cityNameDestination = cityNameDestination;
        this.regionNameDestination = regionNameDestination;
        this.distance = distance;
    }

    public Distance() {
    }

    public String getCityNameOrigin() {
        return cityNameOrigin;
    }

    public void setCityNameOrigin(String cityNameOrigin) {
        this.cityNameOrigin = cityNameOrigin;
    }

    public String getRegionNameOrigin() {
        return regionNameOrigin;
    }

    public void setRegionNameOrigin(String regionNameOrigin) {
        this.regionNameOrigin = regionNameOrigin;
    }

    public String getCityNameDestination() {
        return cityNameDestination;
    }

    public void setCityNameDestination(String cityNameDestination) {
        this.cityNameDestination = cityNameDestination;
    }

    public String getRegionNameDestination() {
        return regionNameDestination;
    }

    public void setRegionNameDestination(String regionNameDestination) {
        this.regionNameDestination = regionNameDestination;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "cityNameOrigin='" + cityNameOrigin + '\'' +
                ", regionNameOrigin='" + regionNameOrigin + '\'' +
                ", cityNameDestination='" + cityNameDestination + '\'' +
                ", regionNameDestination='" + regionNameDestination + '\'' +
                ", distance=" + distance +
                '}';
    }
}
