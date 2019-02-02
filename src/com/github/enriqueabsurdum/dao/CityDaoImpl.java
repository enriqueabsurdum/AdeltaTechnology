package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.CityDao;
import com.github.enriqueabsurdum.models.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {

    private final String INSERT = "INSERT INTO cities (city) VALUES (?)";
    private final String SELECT = "SELECT id_city, city FROM cities WHERE id_city = ?";
    private final String UPDATE = "UPDATE cities SET city = ? WHERE id_city = ?";
    private final String DELETE = "DELETE FROM cities WHERE id_city = ?";
    private final String FINDALL = "SELECT id_city, city FROM cities";
    private final String GETBYCITY = "SELECT id_city, city FROM cities WHERE city = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(City entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getCity());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful INSERT City\n");
            }
            result = sentence.getGeneratedKeys();
            if (result.next()) {
                entity.setId(result.getInt(1));
            }
        } catch (SQLException sqle) {
            System.out.printf("INSERT City error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }

    @Override
    public City read(Integer key) {
        City city = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                city = new City();
                city.setId(result.getInt("id_city"));
                city.setCity(result.getString("city"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT City error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return city;
    }

    @Override
    public void update(City entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getCity());
            sentence.setInt(2, entity.getId());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful UPDATE City\n");
            }
        } catch (SQLException sqle) {
            System.out.printf("UPDATE City error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }

    @Override
    public void delete(Integer key) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(DELETE);
            sentence.setInt(1, key);
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful DELETE\n");
            }
        } catch (SQLException sqle) {
            System.out.printf("DELETE error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                City city = new City();
                city.setId(result.getInt("id_city"));
                city.setCity(result.getString("city"));
                cities.add(city);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return cities;
    }

    @Override
    public City getByCity(String value) {
        City city = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(GETBYCITY);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            if (result.next()) {
                city = new City();
                city.setId(result.getInt("id_city"));
                city.setCity(result.getString("city"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return city;
    }

}
