package com.github.enriqueabsurdum.dao;

import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.database.DatabaseResource;
import com.github.enriqueabsurdum.interfaces.AuditDao;
import com.github.enriqueabsurdum.models.Audit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuditDaoImpl implements AuditDao {

    private final String INSERT = "INSERT INTO audit (id_mobile, date_audit, minutes, data) VALUES (?, ?, ?, ?)";
    private final String SELECT = "SELECT id_audit, id_mobile, date_audit, minutes, data FROM audit WHERE id_audit = ?";
    private final String UPDATE = "UPDATE audit SET id_mobile = ?, date_audit = ?, minutes = ?, data = ? WHERE id_audit = ?";
    private final String DELETE = "DELETE FROM audit WHERE id_audit = ?";
    private final String FINDALL = "SELECT date_audit, id_mobile, minutes, data FROM audit";

    private Connection connection;
    private PreparedStatement sentence;
    private ResultSet result;

    @Override
    public void create(Audit entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            sentence.setInt(1, entity.getIdMobile());
            sentence.setString(2, entity.getDate());
            sentence.setInt(3, entity.getMinutes());
            sentence.setInt(4, entity.getData());
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
    public Audit read(Integer key) {
        Audit audit = null;
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(SELECT);
            sentence.setInt(1, key);
            result = sentence.executeQuery();
            if (result.next()) {
                audit = new Audit();
                audit.setId(result.getInt("id_audit"));
                audit.setId(result.getInt("id_mobile"));
                audit.setDate(result.getString("date_audit"));
                audit.setMinutes(result.getInt("minutes"));
                audit.setData(result.getInt("data"));
            }
        } catch (SQLException sqle) {
            System.out.printf("SELECT error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return audit;
    }

    @Override
    public void update(Audit entity) {
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(UPDATE);
            sentence.setInt(1, entity.getIdMobile());
            sentence.setString(2, entity.getDate());
            sentence.setInt(3, entity.getMinutes());
            sentence.setInt(4, entity.getData());
            sentence.setInt(5, entity.getId());
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
    public List<Audit> findAll() {
        List<Audit> audits = new ArrayList<>();
        try {
            connection = new DatabaseConnection().getConnect();
            sentence = connection.prepareStatement(FINDALL);
            result = sentence.executeQuery();
            while (result.next()) {
                Audit audit = new Audit();
                audit.setId(result.getInt("id_audit"));
                audit.setIdMobile(result.getInt("id_mobile"));
                audit.setDate(result.getString("date_audit"));
                audit.setMinutes(result.getInt("minutes"));
                audit.setData(result.getInt("data"));
                audits.add(audit);
            }
        } catch (SQLException sqle) {
            System.out.printf("FINDALL error: %s\n", sqle.getMessage());
        } finally {
            DatabaseResource.closeConnection(connection, sentence, result);
        }
        return audits;
    }
}
