package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.UserDao;
import com.github.enriqueabsurdum.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final String INSERT = "INSERT INTO users (run, name, last_name, id_profile, email, password) VALUES (?, ?, ?, ?, ?, MD5(?))";
    private final String SELECT = "SELECT id_user, run, name, last_name, id_profile, email, password FROM users WHERE id_user = ?";
    private final String UPDATE = "UPDATE users SET run = ?, name = ?, last_name = ?, id_profile = ?, email = ?, password = MD5(?) WHERE id_user = ?";
    private final String DELETE = "DELETE FROM users WHERE id_user = ?";
    private final String FINDALL = "SELECT id_user, run, name, last_name, id_profile, email, password FROM users";
    private final String GETLOGIN = "SELECT id_user, run, name, last_name, id_profile, email, password FROM users WHERE email = ? AND password = MD5(?)";
    private final String GETBYRUN = "SELECT id_user, run, name, last_name, id_profile, email, password FROM users WHERE run = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(User entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getRun());
            sentence.setString(2, entity.getName());
            sentence.setString(3, entity.getLastName());
            sentence.setInt(4, entity.getProfile().getId());
            sentence.setString(5, entity.getEmail());
            sentence.setString(6, entity.getPassword());
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
    public User read(Integer key) {
        User user = null;
        ProfileDaoImpl daoProfile;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                user = new User();
                daoProfile = new ProfileDaoImpl();
                user.setId(result.getInt("id_user"));
                user.setRun(result.getString("run"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("last_name"));
                user.setProfile(daoProfile.read(result.getInt("id_profile")));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return user;
    }

    @Override
    public void update(User entity) {
        ProfileDaoImpl daoProfile;
        try {
            daoProfile = new ProfileDaoImpl();
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getRun());
            sentence.setString(2, entity.getName());
            sentence.setString(3, entity.getLastName());
            sentence.setInt(4, entity.getProfile().getId());
            sentence.setString(5, entity.getEmail());
            sentence.setString(6, entity.getPassword());
            sentence.setInt(7, entity.getId());
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
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        ProfileDaoImpl daoProfile;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                User user = new User();
                daoProfile = new ProfileDaoImpl();
                user.setId(result.getInt("id_user"));
                user.setRun(result.getString("run"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("last_name"));
                user.setProfile(daoProfile.read(result.getInt("id_profile")));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                users.add(user);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return users;
    }

    @Override
    public User getLogin(String username, String password) {
        User user = null;
        ProfileDaoImpl daoProfile;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(GETLOGIN);
            sentence.setString(1, username);
            sentence.setString(2, password);
            result = sentence.executeQuery();
            if (result.next()) {
                user = new User();
                daoProfile = new ProfileDaoImpl();
                user.setId(result.getInt("id_user"));
                user.setRun(result.getString("run"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("last_name"));
                user.setProfile(daoProfile.read(result.getInt("id_profile")));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
            }
        } catch (SQLException sqle) {
            System.out.printf("LOGIN error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return user;
    }

    @Override
    public User getByRun(String value) {
        User user = null;
        ProfileDaoImpl daoProfile;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(GETBYRUN);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            if (result.next()) {
                user = new User();
                daoProfile = new ProfileDaoImpl();
                user.setId(result.getInt("id_user"));
                user.setRun(result.getString("run"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("last_name"));
                user.setProfile(daoProfile.read(result.getInt("id_profile")));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
            }
        } catch (SQLException sqle) {
            System.out.printf("GET BY RUN error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return user;
    }

}
