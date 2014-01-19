package MatrixDistanceCounter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikalai Kisel
 */
public class Region {

    private String name;
    private List<Double> GDPs;
    private List<City> cities;

    public Region(String name) {
        this.name = name;
        GDPs = new ArrayList<Double>();
        cities = new ArrayList<City>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public void addGdp(Double gdp) {
        GDPs.add(gdp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGDPs() {
        return GDPs;
    }

    public void setGDPs(List<Double> GDPs) {
        this.GDPs = GDPs;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", GDPs=" + GDPs +
                ", cities=" + cities +
                '}';
    }
}
