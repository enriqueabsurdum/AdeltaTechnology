package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.PlanTypeDao;
import com.github.enriqueabsurdum.models.PlanType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanTypeDaoImpl implements PlanTypeDao {

    private final String INSERT = "INSERT INTO plan_type (type) VALUES (?)";
    private final String SELECT = "SELECT id_plan_type, type FROM plan_type WHERE id_plan_type = ?";
    private final String UPDATE = "UPDATE plan_type SET type = ? WHERE id_plan_type = ?";
    private final String DELETE = "DELETE FROM plan_type WHERE id_plan_type = ?";
    private final String FINDALL = "SELECT id_plan_type, type FROM plan_type";
    private final String GETBYTYPE = "SELECT id_plan_type, type FROM plan_type WHERE type = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(PlanType entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getType());
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
    public PlanType read(Integer key) {
        PlanType planType = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                planType = new PlanType();
                planType.setId(result.getInt("id_plan_type"));
                planType.setType(result.getString("type"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return planType;
    }

    @Override
    public void update(PlanType entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getType());
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
    public List<PlanType> findAll() {
        List<PlanType> planTypes = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                PlanType planType = new PlanType();
                planType.setId(result.getInt("id_plan_type"));
                planType.setType(result.getString("type"));
                planTypes.add(planType);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return planTypes;
    }

}
