package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.EmployeeDaoImpl;
import com.github.enriqueabsurdum.dao.MobileDaoImpl;
import com.github.enriqueabsurdum.models.Employee;
import com.github.enriqueabsurdum.models.Mobile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelEmployee extends AbstractTableModel {

    private EmployeeDaoImpl daoEmployee;
    private List<Employee> employees = new ArrayList<>();
    private Employee employee;

    public TableModelEmployee(Employee employee) {
        this.employee = employee;
    }

    public void updateModel() {
        daoEmployee = new EmployeeDaoImpl();
        employees = daoEmployee.findAll();
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
                return "Cargo";
            case 4:
                return "Número telefónico";
            default:
                return "null";
        }
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        employee = employees.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getRun();
            case 1:
                return employee.getName();
            case 2:
                return employee.getLastName();
            case 3:
                return employee.getPosition();
            case 4:
                if (employee.getMobile() == null) {
                    return "Sin teléfono asignado";
                } else {
                    return employee.getMobile().getMobileNumber();
                }
            default:
                return null;
        }
    }
}
