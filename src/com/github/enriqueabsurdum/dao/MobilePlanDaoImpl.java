package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.MobilePlanDao;
import com.github.enriqueabsurdum.models.MobilePlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MobilePlanDaoImpl implements MobilePlanDao {

    private final String INSERT = "INSERT INTO mobiles_plans (id_mobile, id_plan) VALUES (?, ?)";
    private final String SELECT = "SELECT id_mobile_plan, id_mobile, id_plan FROM mobiles_plans WHERE id_brand = ?";
    private final String UPDATE = "UPDATE mobiles_plans SET id_mobile = ?, id_plan = ? WHERE id_mobile_plan = ?";
    private final String DELETE = "DELETE FROM mobiles_plans WHERE id_mobile_plan = ?";
    private final String DELETEBYMOBILE = "DELETE FROM mobiles_plans WHERE id_mobile = ?";
    private final String FINDALL = "SELECT id_mobile_plan, id_mobile, id_plan FROM mobiles_plans";
    private final String FINDBYMOBILE = "SELECT id_mobile_plan, id_mobile, id_plan FROM mobiles_plans WHERE id_mobile = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(MobilePlan entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setInt(1, entity.getIdMobile());
            sentence.setInt(2, entity.getIdPlan());
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
    public MobilePlan read(Integer key) {
        MobilePlan mobilePlan = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                mobilePlan = new MobilePlan();
                mobilePlan.setId(result.getInt("id_mobile_plan"));
                mobilePlan.setIdMobile(result.getInt("id_mobile"));
                mobilePlan.setIdPlan(result.getInt("id_plan"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return mobilePlan;
    }

    @Override
    public void update(MobilePlan entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setInt(1, entity.getIdMobile());
            sentence.setInt(2, entity.getIdPlan());
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
    public List<MobilePlan> findAll() {
        List<MobilePlan> mobilePlans = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                MobilePlan mobilePlan = new MobilePlan();
                mobilePlan.setId(result.getInt("id_mobile_plan"));
                mobilePlan.setIdMobile(result.getInt("id_mobile"));
                mobilePlan.setIdPlan(result.getInt("id_plan"));
                mobilePlans.add(mobilePlan);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return mobilePlans;
    }

    @Override
    public List<MobilePlan> findByMobile(Integer key) {
        List<MobilePlan> mobilePlans = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDBYMOBILE);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            while (result.next()) {
                MobilePlan mobilePlan = new MobilePlan();
                mobilePlan.setId(result.getInt("id_mobile_plan"));
                mobilePlan.setIdMobile(result.getInt("id_mobile"));
                mobilePlan.setIdPlan(result.getInt("id_plan"));
                mobilePlans.add(mobilePlan);
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return mobilePlans;
    }

    @Override
    public MobilePlan readByMobile(Integer key) {
        MobilePlan mobilePlan = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDBYMOBILE);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                mobilePlan = new MobilePlan();
                mobilePlan.setId(result.getInt("id_mobile_plan"));
                mobilePlan.setIdMobile(result.getInt("id_mobile"));
                mobilePlan.setIdPlan(result.getInt("id_plan"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return mobilePlan;
    }

    @Override
    public void deleteByMobile(Integer key) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(DELETEBYMOBILE);
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

}
