package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.PlanDao;
import com.github.enriqueabsurdum.models.Plan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanDaoImpl implements PlanDao {

    private final String INSERT = "INSERT INTO plans (plan, description, id_plan_type) VALUES (?, ?, ?)";
    private final String SELECT = "SELECT id_plan, plan, description, id_plan_type FROM plans WHERE id_plan = ?";
    private final String UPDATE = "UPDATE plans SET plan = ?, description = ?, id_plan_type = ? WHERE id_plan = ?";
    private final String DELETE = "DELETE FROM plans WHERE id_plan = ?";
    private final String FINDALL = "SELECT id_plan, plan, description, id_plan_type FROM plans";
    private final String FINDBYPLAN = "SELECT id_plan, plan, description, id_plan_type FROM plans WHERE plan = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(Plan entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getPlan());
            sentence.setString(2, entity.getDescription());
            sentence.setObject(3, entity.getPlanType().getId());
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
    public Plan read(Integer key) {
        Plan plan = null;
        PlanTypeDaoImpl daoPlanType;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            while (result.next()) {
                plan = new Plan();
                daoPlanType = new PlanTypeDaoImpl();
                plan.setId(result.getInt("id_plan"));
                plan.setPlan(result.getString("plan"));
                plan.setDescription(result.getString("description"));
                plan.setPlanType(daoPlanType.read(result.getInt("id_plan_type")));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return plan;
    }

    @Override
    public void update(Plan entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getPlan());
            sentence.setString(2, entity.getDescription());
            sentence.setInt(3, entity.getPlanType().getId());
            sentence.setInt(4, entity.getId());
            if (sentence.executeUpdate() != 0) {
                System.out.printf("Successful UPDATE\n");
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
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
    public List<Plan> findAll() {
        List<Plan> plans = new ArrayList<>();
        PlanTypeDaoImpl daoPlanType;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                Plan plan = new Plan();
                daoPlanType = new PlanTypeDaoImpl();
                plan.setId(result.getInt("id_plan"));
                plan.setPlan(result.getString("plan"));
                plan.setDescription(result.getString("description"));
                plan.setPlanType(daoPlanType.read(result.getInt("id_plan_type")));
                plans.add(plan);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return plans;
    }

    @Override
    public Plan readByPlan(String value) {
        Plan plan = null;
        PlanTypeDaoImpl daoPlanType;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDBYPLAN);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            while (result.next()) {
                plan = new Plan();
                daoPlanType = new PlanTypeDaoImpl();
                plan.setId(result.getInt("id_plan"));
                plan.setPlan(result.getString("plan"));
                plan.setDescription(result.getString("description"));
                plan.setPlanType(daoPlanType.read(result.getInt("id_plan_type")));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return plan;
    }

}
