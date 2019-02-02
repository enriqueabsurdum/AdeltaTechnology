package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.UserDaoImpl;
import com.github.enriqueabsurdum.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelUser extends AbstractTableModel {

    private UserDaoImpl daoUser;
    private List<User> users = new ArrayList<>();
    private User user;

    public TableModelUser(User user) {
        this.user = user;
    }

    public void updateModel() {
        daoUser = new UserDaoImpl();
        users = daoUser.findAll();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "RUN";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Perfil";
            case 4:
                return "Correo electrónico";
            case 5:
                return "Contraseña";
            default:
                return "null";
        }
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getRun();
            case 1:
                return user.getName();
            case 2:
                return user.getLastName();
            case 3:
                return user.getProfile().getProfile();
            case 4:
                return user.getEmail();
            case 5:
                return user.getPassword();
            default:
                return null;
        }
    }
}
