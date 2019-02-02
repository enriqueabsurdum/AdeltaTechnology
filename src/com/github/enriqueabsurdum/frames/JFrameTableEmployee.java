package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.EmployeeDaoImpl;
import com.github.enriqueabsurdum.dao.MobileDaoImpl;
import com.github.enriqueabsurdum.models.Employee;
import com.github.enriqueabsurdum.models.Mobile;
import com.github.enriqueabsurdum.models.User;
import javax.swing.JOptionPane;

public class JFrameTableEmployee extends javax.swing.JFrame {

    private TableModelEmployee model;
    private User user;
    private Employee employee;
    private EmployeeDaoImpl daoEmployee;
    private MobileDaoImpl daoMobile;
    private JFrameAddEmployee jFrameAddEmployee;

    // Este constructor se debe borrar
    public JFrameTableEmployee() {
        initComponents();
        this.model = new TableModelEmployee(employee);
        this.model.updateModel();
        this.tblEmployees.setModel(model);
        getRowCountEmployees();
    }

    public JFrameTableEmployee(User user) {
        initComponents();
        this.user = user;
        this.setProfiles();
        this.model = new TableModelEmployee(employee);
        this.model.updateModel();
        this.tblEmployees.setModel(model);
        getRowCountEmployees();
    }

    private void getRowCountEmployees() {
        lblCountMobiles.setText(String.valueOf(this.model.getRowCount() + " empleados registrados."));
    }

    private Employee getEmployeeSelected() {
        daoEmployee = new EmployeeDaoImpl();
        String run = (String) tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 0);
        return daoEmployee.getByRun(run);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnDetail = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnEdit = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnDelete = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        lblCountMobiles = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empleados");
        setBackground(java.awt.Color.white);
        setResizable(false);

        jToolBar1.setBackground(new java.awt.Color(120, 129, 142));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(0, 40, 0, 40));
        jToolBar1.setMaximumSize(new java.awt.Dimension(80, 70));
        jToolBar1.setMinimumSize(new java.awt.Dimension(80, 70));
        jToolBar1.setOpaque(false);
        jToolBar1.setPreferredSize(new java.awt.Dimension(80, 70));

        btnDetail.setBackground(new java.awt.Color(128, 179, 232));
        btnDetail.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnDetail.setForeground(java.awt.Color.white);
        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-detail-24.png"))); // NOI18N
        btnDetail.setText("Detalle");
        btnDetail.setBorderPainted(false);
        btnDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetail.setFocusable(false);
        btnDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetail.setIconTextGap(8);
        btnDetail.setMaximumSize(new java.awt.Dimension(80, 70));
        btnDetail.setMinimumSize(new java.awt.Dimension(80, 70));
        btnDetail.setPreferredSize(new java.awt.Dimension(80, 70));
        btnDetail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDetail);
        jToolBar1.add(jSeparator1);
        jToolBar1.add(jSeparator5);
        jToolBar1.add(jSeparator3);

        btnEdit.setBackground(new java.awt.Color(249, 192, 89));
        btnEdit.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnEdit.setForeground(java.awt.Color.white);
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-edit-24.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setIconTextGap(8);
        btnEdit.setMaximumSize(new java.awt.Dimension(80, 70));
        btnEdit.setMinimumSize(new java.awt.Dimension(80, 70));
        btnEdit.setPreferredSize(new java.awt.Dimension(80, 70));
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator9);

        btnDelete.setBackground(new java.awt.Color(246, 118, 124));
        btnDelete.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnDelete.setForeground(java.awt.Color.white);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-delete-24.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setIconTextGap(8);
        btnDelete.setMaximumSize(new java.awt.Dimension(80, 70));
        btnDelete.setMinimumSize(new java.awt.Dimension(80, 70));
        btnDelete.setPreferredSize(new java.awt.Dimension(80, 70));
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);
        jToolBar1.add(jSeparator2);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jComboBox1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ítem", "RUN", "Nombre", "Apellido", "Correo electrónico" }));

        jTextField1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(0, 5, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jToolBar1.add(jPanel1);

        jButton4.setBackground(new java.awt.Color(184, 195, 196));
        jButton4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-search-24.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setIconTextGap(8);
        jButton4.setMaximumSize(new java.awt.Dimension(80, 70));
        jButton4.setMinimumSize(new java.awt.Dimension(80, 70));
        jButton4.setPreferredSize(new java.awt.Dimension(80, 70));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jToolBar2.setBackground(new java.awt.Color(235, 240, 241));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setMargin(new java.awt.Insets(0, 40, 5, 40));
        jToolBar2.setOpaque(false);

        lblCountMobiles.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lblCountMobiles.setText("0 Registered mobiles ");
        jToolBar2.add(lblCountMobiles);

        tblEmployees.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmployees.setRowHeight(25);
        tblEmployees.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEmployees);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            employee = getEmployeeSelected();
            jFrameAddEmployee = new JFrameAddEmployee(employee);
            jFrameAddEmployee.setVisible(true);
        } catch (Exception e) {
            System.out.printf("Exception: %s\n", e.getMessage());
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún registro", "Observación", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        daoMobile = new MobileDaoImpl();
        Mobile mobile;
        int i;
        try {
            employee = getEmployeeSelected();
            i = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el registro seleccionado?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (employee.getMobile() == null) {
                if (i == JOptionPane.YES_OPTION) {
                    daoEmployee.delete(employee.getId());
                    model.updateModel();
                    model.fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "El empleado ha sido eliminado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                mobile = daoMobile.readByImei(employee.getMobile().getImei());
                if (i == JOptionPane.YES_OPTION) {
                    daoEmployee.delete(employee.getId());
                    mobile.setMobileDate(null);
                    mobile.setMobileStatus(false);
                    daoMobile.updateById(mobile);
                    model.updateModel();
                    model.fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "El empleado ha sido eliminado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        try {
            employee = getEmployeeSelected();
            jFrameAddEmployee = new JFrameAddEmployee(employee, Boolean.FALSE);
            jFrameAddEmployee.setVisible(true);
        } catch (Exception e) {
            System.out.printf("Exception: %s\n", e.getMessage());
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún registro", "Observación", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void setProfiles() {
        if (user.getProfile().getProfile().equals("Consultor")) {
            btnDetail.setVisible(true);
            btnEdit.setVisible(false);
            btnDelete.setVisible(false);
        }

        if (user.getProfile().getProfile().equals("Encargado")) {
            btnDetail.setEnabled(true);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new JFrameTableEmployee().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblCountMobiles;
    private javax.swing.JTable tblEmployees;
    // End of variables declaration//GEN-END:variables
}
