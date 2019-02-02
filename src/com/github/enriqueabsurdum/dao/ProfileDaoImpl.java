package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.ProfileDao;
import com.github.enriqueabsurdum.models.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileDaoImpl implements ProfileDao {

    private final String INSERT = "INSERT INTO profiles (profile) VALUES (?)";
    private final String SELECT = "SELECT id_profile, profile FROM profiles WHERE id_profile = ?";
    private final String UPDATE = "UPDATE profiles SET department = ? WHERE id_profile = ?";
    private final String DELETE = "DELETE FROM profiles WHERE id_profile = ?";
    private final String FINDALL = "SELECT id_profile, profile FROM profiles";
    private final String GETBYPROFILE = "SELECT id_profile, profile FROM profiles WHERE profile = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(Profile entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getProfile());
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
    public Profile read(Integer key) {
        Profile profile = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                profile = new Profile();
                profile.setId(result.getInt("id_profile"));
                profile.setProfile(result.getString("profile"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return profile;
    }

    @Override
    public void update(Profile entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getProfile());
            sentence.setInt(2, entity.getId());
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
            System.out.printf("DELETE error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
    }

    @Override
    public List<Profile> findAll() {
        List<Profile> profiles = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                Profile profile = new Profile();
                profile.setId(result.getInt("id_profile"));
                profile.setProfile(result.getString("profile"));
                profiles.add(profile);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return profiles;
    }

    @Override
    public Profile getByProfile(String value) {
        Profile profile = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(GETBYPROFILE);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            if (result.next()) {
                profile = new Profile();
                profile.setId(result.getInt("id_profile"));
                profile.setProfile(result.getString("profile"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return profile;
    }
}
