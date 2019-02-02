package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.BrandDao;
import com.github.enriqueabsurdum.interfaces.MobileDao;
import com.github.enriqueabsurdum.models.Mobile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MobileDaoImpl implements MobileDao {

    private final String INSERT = "INSERT INTO mobiles (imei, id_brand, model, storage_capacity, front_camera, back_camera, internal_storage, operating_system, antivirus, mobile_date, mobile_number, mobile_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT = "SELECT id_mobile, imei, id_brand, model, storage_capacity, front_camera, back_camera, internal_storage, operating_system, antivirus, mobile_date, mobile_number, mobile_status FROM mobiles WHERE id_mobile = ?";
    private final String UPDATE = "UPDATE mobiles SET imei = ?, id_brand = ?, model = ?, storage_capacity = ?, front_camera = ?, back_camera = ?, internal_storage = ?, operating_system = ?, antivirus = ?, mobile_date = ?, mobile_number = ?, mobile_status = ? WHERE id_mobile = ?";
    private final String DELETE = "DELETE FROM mobiles WHERE id_mobile = ?";
    private final String FINDALL = "SELECT id_mobile, imei, id_brand, model, storage_capacity, front_camera, back_camera, internal_storage, operating_system, antivirus, mobile_date, mobile_number, mobile_status FROM mobiles";
    private final String FINDBYIMEI = "SELECT id_mobile, imei, id_brand, model, storage_capacity, front_camera, back_camera, internal_storage, operating_system, antivirus, mobile_date, mobile_number, mobile_status FROM mobiles WHERE imei = ?";
    private final String UPDATEMOBILE = "UPDATE mobiles SET mobile_date = ?, mobile_status = ? WHERE id_mobile = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(Mobile entity) {
        BrandDao daoBrand;
        try {
            daoBrand = new BrandDaoImpl();
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getImei());
            sentence.setInt(2, daoBrand.getByBrand(entity.getBrand()).getId());
            sentence.setString(3, entity.getModel());
            sentence.setString(4, entity.getStorageCapacity());
            sentence.setString(5, entity.getFrontCamera());
            sentence.setString(6, entity.getBackCamera());
            sentence.setString(7, entity.getInternalStorage());
            sentence.setString(8, entity.getOperatingSystem());
            sentence.setBoolean(9, entity.isAntivirus());
            sentence.setString(10, entity.getMobileDate());
            sentence.setString(11, entity.getMobileNumber());
            sentence.setBoolean(12, entity.isMobileStatus());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful INSERT\n");
            }
            result = sentence.getGeneratedKeys();
            if (result.next()) {
                entity.setId(result.getInt(1));
            }
        } catch (SQLException sqle) {
            System.out.printf("INSERT Mobile error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }

    @Override
    public Mobile read(Integer key) {
        Mobile mobile = null;
        BrandDaoImpl daoBrand;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                mobile = new Mobile();
                daoBrand = new BrandDaoImpl();
                mobile.setId(result.getInt("id_mobile"));
                mobile.setImei(result.getString("imei"));
                mobile.setBrand(daoBrand.read(result.getInt("id_brand")).getBrand()); // Other java class
                mobile.setModel(result.getString("model"));
                mobile.setStorageCapacity(result.getString("storage_capacity"));
                mobile.setFrontCamera(result.getString("front_camera"));
                mobile.setBackCamera(result.getString("back_camera"));
                mobile.setInternalStorage(result.getString("internal_storage"));
                mobile.setOperatingSystem(result.getString("operating_system"));
                mobile.setAntivirus(result.getBoolean("antivirus"));
                mobile.setMobileDate(result.getString("mobile_date"));
                mobile.setMobileNumber(result.getString("mobile_number"));
                mobile.setMobileStatus(result.getBoolean("mobile_status"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return mobile;
    }

    @Override
    public void update(Mobile entity) {
        BrandDaoImpl daoBrand;
        try {
            daoBrand = new BrandDaoImpl();
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getImei());
            sentence.setInt(2, daoBrand.getByBrand(entity.getBrand()).getId());
            sentence.setString(3, entity.getModel());
            sentence.setString(4, entity.getStorageCapacity());
            sentence.setString(5, entity.getFrontCamera());
            sentence.setString(6, entity.getBackCamera());
            sentence.setString(7, entity.getInternalStorage());
            sentence.setString(8, entity.getOperatingSystem());
            sentence.setBoolean(9, entity.isAntivirus());
            sentence.setString(10, entity.getMobileDate());
            sentence.setString(11, entity.getMobileNumber());
            sentence.setBoolean(12, entity.isMobileStatus());
            sentence.setInt(13, entity.getId());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful UPDATE\n");
            }
        } catch (SQLException sqle) {
            System.out.printf("UPDATE error: %s\n", sqle.getMessage());
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
            System.out.printf("DELETE Mobile error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }

    @Override
    public List<Mobile> findAll() {
        List<Mobile> mobiles = new ArrayList<>();
        BrandDaoImpl daoBrand;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                Mobile mobile = new Mobile();
                daoBrand = new BrandDaoImpl();
                mobile.setId(result.getInt("id_mobile"));
                mobile.setImei(result.getString("imei"));
                mobile.setBrand(daoBrand.read(result.getInt("id_brand")).getBrand());
                mobile.setModel(result.getString("model"));
                mobile.setStorageCapacity(result.getString("storage_capacity"));
                mobile.setFrontCamera(result.getString("front_camera"));
                mobile.setBackCamera(result.getString("back_camera"));
                mobile.setInternalStorage(result.getString("internal_storage"));
                mobile.setOperatingSystem(result.getString("operating_system"));
                mobile.setAntivirus(result.getBoolean("antivirus"));
                mobile.setMobileDate(result.getString("mobile_date"));
                mobile.setMobileNumber(result.getString("mobile_number"));
                mobile.setMobileStatus(result.getBoolean("mobile_status"));
                mobiles.add(mobile);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL Mobile error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return mobiles;
    }

    @Override
    public Mobile readByImei(String value) {
        Mobile mobile = null;
        BrandDaoImpl daoBrand;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDBYIMEI);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            if (result.next()) {
                mobile = new Mobile();
                daoBrand = new BrandDaoImpl();
                mobile.setId(result.getInt("id_mobile"));
                mobile.setImei(result.getString("imei"));
                mobile.setBrand(daoBrand.read(result.getInt("id_brand")).getBrand());
                mobile.setModel(result.getString("model"));
                mobile.setStorageCapacity(result.getString("storage_capacity"));
                mobile.setFrontCamera(result.getString("front_camera"));
                mobile.setBackCamera(result.getString("back_camera"));
                mobile.setInternalStorage(result.getString("internal_storage"));
                mobile.setOperatingSystem(result.getString("operating_system"));
                mobile.setAntivirus(result.getBoolean("antivirus"));
                mobile.setMobileDate(result.getString("mobile_date"));
                mobile.setMobileNumber(result.getString("mobile_number"));
                mobile.setMobileStatus(result.getBoolean("mobile_status"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT Mobile by IMEI error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return mobile;
    }

    @Override
    public void updateById(Mobile entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATEMOBILE);

            if (entity.getMobileDate() == null) {
                sentence.setNull(1, java.sql.Types.INTEGER);
            } else {
                sentence.setString(1, entity.getMobileDate());
            }
            sentence.setBoolean(2, entity.isMobileStatus());
            sentence.setInt(3, entity.getId());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful UPDATE\n");
            }
        } catch (SQLException sqle) {
            System.out.printf("UPDATE error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }
}
