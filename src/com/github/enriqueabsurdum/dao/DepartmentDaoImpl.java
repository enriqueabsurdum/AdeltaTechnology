package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.DepartmentDao;
import com.github.enriqueabsurdum.models.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private final String INSERT = "INSERT INTO departments (department) VALUES (?)";
    private final String SELECT = "SELECT id_department, department FROM departments WHERE id_department = ?";
    private final String UPDATE = "UPDATE departments SET department = ? WHERE id_department = ?";
    private final String DELETE = "DELETE FROM departments WHERE id_department = ?";
    private final String FINDALL = "SELECT id_department, department FROM departments";
    private final String GETBYDEPARTMENT = "SELECT id_department, department FROM departments WHERE department = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(Department entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getDepartment());
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
    public Department read(Integer key) {
        Department department = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                department = new Department();
                department.setId(result.getInt("id_department"));
                department.setDepartment(result.getString("department"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return department;
    }

    @Override
    public void update(Department entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getDepartment());
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
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                Department department = new Department();
                department.setId(result.getInt("id_department"));
                department.setDepartment(result.getString("department"));
                departments.add(department);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return departments;
    }

    @Override
    public Department getByDepartment(String value) {
        Department department = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(GETBYDEPARTMENT);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            if (result.next()) {
                department = new Department();
                department.setId(result.getInt("id_department"));
                department.setDepartment(result.getString("department"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return department;
    }

}
