import Service.City;

import java.util.List;

public interface CityDAO {
    City add(City city);
    City getByID(int id);
    List<City> getAllCities();
    City updateCity(City city);
    void deleteCity(City city);
}