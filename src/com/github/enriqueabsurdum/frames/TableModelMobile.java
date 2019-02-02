package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.MobileDaoImpl;
import com.github.enriqueabsurdum.models.Mobile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelMobile extends AbstractTableModel {

    private MobileDaoImpl daoMobile;
    private List<Mobile> mobiles = new ArrayList<>();
    private Mobile mobile;

    public TableModelMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public void updateModel() {
        daoMobile = new MobileDaoImpl();
        mobiles = daoMobile.findAll();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "IMEI";
            case 1:
                return "Marca";
            case 2:
                return "Modelo";
            case 3:
                return "Sistema operativo";
            case 4:
                return "Número telefónico";
            case 5:
                return "Estado";
            default:
                return "null";
        }
    }

    @Override
    public int getRowCount() {
        return mobiles.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        mobile = mobiles.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mobile.getImei();
            case 1:
                return mobile.getBrand();
            case 2:
                return mobile.getModel();
            case 3:
                return mobile.getOperatingSystem();
            case 4:
                return mobile.getMobileNumber();
            case 5:
                if (mobile.isMobileStatus() == true) {
                    return "Asignado";
                } else {
                    return "Disponible";
                }
            default:
                return null;
        }
    }
}
