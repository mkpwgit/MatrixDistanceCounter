package MatrixDistanceCounter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikalai Kisel
 */
public class City {

    private String city;
    private List<Double> GDPs;

    public City(String city) {
        this.city = city;
        GDPs = new ArrayList<Double>();
    }

    public void addGdp(Double gdp) {
        GDPs.add(gdp);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Double> getGDPs() {
        return GDPs;
    }

    public void setGDPs(List<Double> GDPs) {
        this.GDPs = GDPs;
    }

    @Override
    public String toString() {
        return "City{" +
                "city='" + city + '\'' +
                ", GDPs=" + GDPs +
                '}';
    }
}
