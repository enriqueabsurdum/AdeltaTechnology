package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.EmployeeDao;
import com.github.enriqueabsurdum.models.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final String INSERT = "INSERT INTO employees (run, name, last_name, id_department, position, email, address, id_city, incorporation_date, id_mobile) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT = "SELECT id_employee, run, name, last_name, id_department, position, email, address, id_city, incorporation_date, id_mobile FROM employees WHERE id_employee = ?";
    private final String UPDATE = "UPDATE employees SET run = ?, name = ?, last_name = ?, id_department = ?, position = ?, email = ?, address = ?, id_city = ?, incorporation_date = ?, id_mobile = ? WHERE id_employee = ?";
    private final String DELETE = "DELETE FROM employees WHERE id_employee = ?";
    private final String FINDALL = "SELECT id_employee, run, name, last_name, id_department, position, email, address, id_city, incorporation_date, id_mobile FROM employees";
    private final String FINDBYRUN = "SELECT id_employee, run, name, last_name, id_department, position, email, address, id_city, incorporation_date, id_mobile FROM employees WHERE run = ?";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(Employee entity) {
        DepartmentDaoImpl daoDepartment;
        CityDaoImpl daoCity;
        MobileDaoImpl daoMobile;
        try {
            daoDepartment = new DepartmentDaoImpl();
            daoCity = new CityDaoImpl();
            daoMobile = new MobileDaoImpl();
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setString(1, entity.getRun());
            sentence.setString(2, entity.getName());
            sentence.setString(3, entity.getLastName());
            sentence.setInt(4, daoDepartment.getByDepartment(entity.getDepartment()).getId());
            sentence.setString(5, entity.getPosition());
            sentence.setString(6, entity.getEmail());
            sentence.setString(7, entity.getAddress());
            sentence.setInt(8, daoCity.getByCity(entity.getCity()).getId());
            sentence.setString(9, entity.getIncorporation());
            if (entity.getMobile() == null) {
                sentence.setNull(10, java.sql.Types.INTEGER);
            } else {
                sentence.setInt(10, entity.getMobile().getId());
            }
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
    public Employee read(Integer key) {
        Employee employee = null;
        DepartmentDaoImpl daoDepartment;
        CityDaoImpl daoCity;
        MobileDaoImpl daoMobile;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                employee = new Employee();
                daoDepartment = new DepartmentDaoImpl();
                daoCity = new CityDaoImpl();
                daoMobile = new MobileDaoImpl();
                employee.setId(result.getInt("id_employee"));
                employee.setRun(result.getString("run"));
                employee.setName(result.getString("name"));
                employee.setLastName(result.getString("last_name"));
                employee.setDepartment(daoDepartment.read(result.getInt("id_department")).getDepartment());
                employee.setPosition(result.getString("position"));
                employee.setEmail(result.getString("email"));
                employee.setAddress(result.getString("address"));
                employee.setCity(daoCity.read(result.getInt("id_city")).getCity());
                employee.setIncorporation(result.getString("incorporation_date"));
                employee.setMobile(daoMobile.read(result.getInt("id_mobile")));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return employee;
    }

    @Override
    public void update(Employee entity) {
        DepartmentDaoImpl daoDepartment;
        CityDaoImpl daoCity;
        try {
            daoDepartment = new DepartmentDaoImpl();
            daoCity = new CityDaoImpl();
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setString(1, entity.getRun());
            sentence.setString(2, entity.getName());
            sentence.setString(3, entity.getLastName());
            sentence.setInt(4, daoDepartment.getByDepartment(entity.getDepartment()).getId());
            sentence.setString(5, entity.getPosition());
            sentence.setString(6, entity.getEmail());
            sentence.setString(7, entity.getAddress());
            sentence.setInt(8, daoCity.getByCity(entity.getCity()).getId());
            sentence.setString(9, entity.getIncorporation());
            if (entity.getMobile() == null) {
                sentence.setNull(10, java.sql.Types.INTEGER);
            } else {
                sentence.setInt(10, entity.getMobile().getId());
            }
            sentence.setInt(11, entity.getId());
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
    public List<Employee> findAll() {
        DepartmentDaoImpl daoDepartment;
        CityDaoImpl daoCity;
        MobileDaoImpl daoMobile;
        List<Employee> employees = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                Employee employee = new Employee();
                daoDepartment = new DepartmentDaoImpl();
                daoCity = new CityDaoImpl();
                daoMobile = new MobileDaoImpl();
                employee.setId(result.getInt("id_employee"));
                employee.setRun(result.getString("run"));
                employee.setName(result.getString("name"));
                employee.setLastName(result.getString("last_name"));
                employee.setDepartment(daoDepartment.read(result.getInt("id_department")).getDepartment());
                employee.setPosition(result.getString("position"));
                employee.setEmail(result.getString("email"));
                employee.setAddress(result.getString("address"));
                employee.setCity(daoCity.read(result.getInt("id_city")).getCity());
                employee.setIncorporation(result.getString("incorporation_date"));
                employee.setMobile(daoMobile.read(result.getInt("id_mobile")));
                employees.add(employee);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return employees;
    }

    @Override
    public Employee getByRun(String value) {
        Employee employee = null;
        DepartmentDaoImpl daoDepartment;
        CityDaoImpl daoCity;
        MobileDaoImpl daoMobile;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDBYRUN);
            sentence.setString(1, value);
            result = sentence.executeQuery();
            if (result.next()) {
                employee = new Employee();
                daoDepartment = new DepartmentDaoImpl();
                daoCity = new CityDaoImpl();
                daoMobile = new MobileDaoImpl();
                employee.setId(result.getInt("id_employee"));
                employee.setRun(result.getString("run"));
                employee.setName(result.getString("name"));
                employee.setLastName(result.getString("last_name"));
                employee.setDepartment(daoDepartment.read(result.getInt("id_department")).getDepartment());
                employee.setPosition(result.getString("position"));
                employee.setEmail(result.getString("email"));
                employee.setAddress(result.getString("address"));
                employee.setCity(daoCity.read(result.getInt("id_city")).getCity());
                employee.setIncorporation(result.getString("incorporation_date"));
                employee.setMobile(daoMobile.read(result.getInt("id_mobile")));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return employee;
    }

}
