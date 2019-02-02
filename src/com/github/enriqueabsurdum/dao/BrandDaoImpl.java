package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.BrandDao;
import com.github.enriqueabsurdum.models.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDaoImpl implements BrandDao {

    private final String INSERT = "INSERT INTO brands (brand) VALUES (?)";
    private final String SELECT = "SELECT id_brand, brand FROM brands WHERE id_brand = ?";
    private final String UPDATE = "UPDATE brands SET brand = ? WHERE id_brand = ?";
    private final String DELETE = "DELETE FROM brands WHERE id_brand = ?";
    private final String FINDALL = "SELECT id_brand, brand FROM brands";
    private final String GETBYBRAND = "SELECT id_brand, brand FROM brands WHERE brand = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(Brand entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getBrand());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful INSERT\n");
            }
            result = sentence.getGeneratedKeys();
            if (result.next()) {
                entity.setId(result.getInt(1));
            }
        } catch (SQLException sqle) {
            System.out.printf("INSERT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }

    @Override
    public Brand read(Integer key) {
        Brand brand = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                brand = new Brand();
                brand.setId(result.getInt("id_brand"));
                brand.setBrand(result.getString("brand"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return brand;
    }

    @Override
    public void update(Brand entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getBrand());
            sentence.setInt(2, entity.getId());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful UPDATE Brand\n");
            }
        } catch (SQLException sqle) {
            System.out.printf("UPDATE Brand error: %s\n", sqle.getMessage());
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
    public List<Brand> findAll() {
        List<Brand> brands = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                Brand brand = new Brand();
                brand.setId(result.getInt("id_brand"));
                brand.setBrand(result.getString("brand"));
                brands.add(brand);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return brands;
    }

    @Override
    public Brand getByBrand(String value) {
        Brand brand = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(GETBYBRAND);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            if (result.next()) {
                brand = new Brand();
                brand.setId(result.getInt("id_brand"));
                brand.setBrand(result.getString("brand"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return brand;
    }
}
