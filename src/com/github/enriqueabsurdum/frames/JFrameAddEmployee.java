package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.CityDaoImpl;
import com.github.enriqueabsurdum.dao.DepartmentDaoImpl;
import com.github.enriqueabsurdum.dao.EmployeeDaoImpl;
import com.github.enriqueabsurdum.dao.MobileDaoImpl;
import com.github.enriqueabsurdum.models.City;
import com.github.enriqueabsurdum.models.Department;
import com.github.enriqueabsurdum.models.Employee;
import com.github.enriqueabsurdum.models.Mobile;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JFrameAddEmployee extends javax.swing.JFrame {

    private EmployeeDaoImpl daoEmployee;
    private DepartmentDaoImpl daoDepartment;
    private CityDaoImpl daoCity;
    private MobileDaoImpl daoMobile;

    private List<Department> departments;
    private List<City> cities;
    private List<Mobile> mobiles;

    private Employee employee;

    public JFrameAddEmployee() {
        initComponents();
        getDepartments();
        getCities();
        getMobiles();
        lblDetailMobile.setEnabled(false);
        btnEdit.setVisible(false);
    }

    public JFrameAddEmployee(Employee employee) {
        initComponents();
        getDepartments();
        getCities();
        getMobiles();

        this.employee = employee;

        txtRun.setText(employee.getRun());
        txtName.setText(employee.getName());
        txtLastName.setText(employee.getLastName());
        txtPosition.setText(employee.getPosition());
        txtAddress.setText(employee.getAddress());
        txtEmail.setText(employee.getEmail());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(employee.getIncorporation());
            jDateChooserCalendar.setDate(date);
        } catch (ParseException pe) {
            System.out.printf("Calendar exception: %s\n", pe.getMessage());
        }

        cmbDepartment.setSelectedItem(employee.getDepartment());
        cmbCity.setSelectedItem(employee.getCity());

        if (this.employee.getMobile() != null) {
            cmbMobile.addItem(employee.getMobile().getImei());
            cmbMobile.setSelectedItem(employee.getMobile().getImei());
            lblDetailMobile.setEnabled(true);
        } else {
            cmbMobile.setSelectedItem("Sin asignar");
            lblDetailMobile.setEnabled(false);
        }

        lblTitle.setText("Editar empleado");
        btnSave.setVisible(false);
    }

    public JFrameAddEmployee(Employee employee, boolean value) {
        initComponents();
        getMobiles();

        this.employee = employee;

        txtRun.setText(employee.getRun());
        txtName.setText(employee.getName());
        txtLastName.setText(employee.getLastName());
        txtPosition.setText(employee.getPosition());
        txtAddress.setText(employee.getAddress());
        txtEmail.setText(employee.getEmail());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(employee.getIncorporation());
            jDateChooserCalendar.setDate(date);
        } catch (ParseException pe) {
            System.out.printf("Calendar exception: %s\n", pe.getMessage());
        }

        cmbDepartment.removeAllItems();
        cmbDepartment.addItem(employee.getDepartment());

        cmbCity.removeAllItems();
        cmbCity.addItem(employee.getCity());

        lblTitle.setText("Detalle empleado");
        btnEdit.setVisible(value);
        btnSave.setVisible(value);

        txtRun.setEditable(false);
        txtEmail.setEditable(false);
        txtName.setEditable(false);
        txtLastName.setEditable(false);
        txtPosition.setEditable(false);
        txtAddress.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblOperatingSystem = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        cmbDepartment = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jDateChooserCalendar = new com.toedter.calendar.JDateChooser();
        cmbCity = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        cmbMobile = new javax.swing.JComboBox<>();
        lblDetailMobile = new javax.swing.JLabel();
        lblMobileInformation = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empleado");
        setResizable(false);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 198, 154)));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setText("RUN");

        txtRun.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtRun.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setText("Fecha de ingreso");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Cargo");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setText("Correo electrónico");

        txtEmail.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtEmail.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setText("Dirección");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setText("Ciudad");

        btnCancel.setBackground(new java.awt.Color(184, 195, 196));
        btnCancel.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnCancel.setForeground(java.awt.Color.white);
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-cancel-16.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setFocusPainted(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCancel.setIconTextGap(10);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblOperatingSystem.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblOperatingSystem.setText("Departamento");

        txtAddress.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtAddress.setMargin(new java.awt.Insets(0, 5, 0, 0));

        cmbDepartment.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno" }));

        btnSave.setBackground(new java.awt.Color(0, 198, 154));
        btnSave.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnSave.setForeground(java.awt.Color.white);
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-save-16.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setFocusPainted(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSave.setIconTextGap(10);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(249, 192, 89));
        btnEdit.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnEdit.setForeground(java.awt.Color.white);
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-edit-16.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusPainted(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnEdit.setIconTextGap(10);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setText("Nombre");

        txtName.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtName.setMargin(new java.awt.Insets(0, 5, 0, 0));

        txtLastName.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtLastName.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jDateChooserCalendar.setDateFormatString("yyyy-MM-dd");

        cmbCity.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ciudad" }));

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel13.setText("Teléfono asignado");

        txtPosition.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPosition.setMargin(new java.awt.Insets(0, 5, 0, 0));

        cmbMobile.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbMobile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin asignar" }));
        cmbMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMobileActionPerformed(evt);
            }
        });

        lblDetailMobile.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        lblDetailMobile.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDetailMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/image-info.png"))); // NOI18N
        lblDetailMobile.setText("Ver más detalles");
        lblDetailMobile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDetailMobile.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblDetailMobile.setIconTextGap(5);
        lblDetailMobile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetailMobileMouseClicked(evt);
            }
        });

        lblMobileInformation.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lblMobileInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMobileInformation.setText("Marca, Modelo, Número teléfono");
        lblMobileInformation.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cmbCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel11)
                                .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooserCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(jLabel2))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(278, 278, 278))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtName)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOperatingSystem)
                                .addComponent(txtLastName)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(cmbDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(cmbMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                            .addComponent(lblMobileInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(84, 84, 84)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblDetailMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblOperatingSystem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblDetailMobile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMobileInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/black-employee-20.png"))); // NOI18N
        lblTitle.setText("Registro empleado");
        lblTitle.setIconTextGap(10);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        daoEmployee = new EmployeeDaoImpl();
        daoMobile = new MobileDaoImpl();
        String run, email, name, lastName, position, department, address, city, incorporationDate, sMobile;
        if (!txtRun.getText().equals("") && !txtEmail.getText().equals("")
                && !txtName.getText().equals("") && !txtLastName.getText().equals("")
                && !txtPosition.getText().equals("") && cmbDepartment.getSelectedIndex() != 0
                && !txtAddress.getText().equals("") && cmbCity.getSelectedIndex() != 0
                && jDateChooserCalendar.getDate() != null) {

            Date date = jDateChooserCalendar.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            incorporationDate = sdf.format(date);

            run = txtRun.getText();
            email = txtEmail.getText();
            name = txtName.getText();
            lastName = txtLastName.getText();
            position = txtPosition.getText();
            department = cmbDepartment.getSelectedItem().toString();
            address = txtAddress.getText();
            city = cmbCity.getSelectedItem().toString();

            Mobile mobile = null;
            if (cmbMobile.getSelectedIndex() != 0) {
                sMobile = cmbMobile.getSelectedItem().toString();
                mobile = daoMobile.readByImei(sMobile);
                String dateNow = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                mobile.setMobileDate(dateNow);
                mobile.setMobileStatus(true);
                daoMobile.updateById(mobile);
            }

            employee = new Employee(0, run, name, lastName, department, position,
                    email, address, city, incorporationDate, mobile);
            daoEmployee.create(employee);
            JOptionPane.showMessageDialog(null, "Empleado registrado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos para guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        daoEmployee = new EmployeeDaoImpl();
        daoMobile = new MobileDaoImpl();
        String run, email, name, lastName, position, department, address, city, incorporationDate, sMobile;

        if (!txtRun.getText().equals("") && !txtEmail.getText().equals("")
                && !txtName.getText().equals("") && !txtLastName.getText().equals("")
                && !txtPosition.getText().equals("") && cmbDepartment.getSelectedIndex() != 0
                && !txtAddress.getText().equals("") && cmbCity.getSelectedIndex() != 0) {

            Date date = jDateChooserCalendar.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            incorporationDate = sdf.format(date);

            run = txtRun.getText();
            email = txtEmail.getText();
            name = txtName.getText();
            lastName = txtLastName.getText();
            position = txtPosition.getText();
            department = cmbDepartment.getSelectedItem().toString();
            address = txtAddress.getText();
            sMobile = cmbMobile.getSelectedItem().toString();

            city = cmbCity.getSelectedItem().toString();

            Mobile mobile;
            if (cmbMobile.getSelectedIndex() == 0) {
                mobile = new Mobile(employee.getMobile().getId(), false);
                mobile.setMobileDate(null);
                daoMobile.updateById(mobile);
            } else {
                mobile = daoMobile.readByImei(sMobile);
                String dateNow = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                mobile.setMobileDate(dateNow);
                mobile.setMobileStatus(true);
                daoMobile.updateById(mobile);
            }

            employee = new Employee(this.employee.getId(), run, name, lastName, department, position,
                    email, address, city, incorporationDate, daoMobile.readByImei(sMobile));
            daoEmployee.update(employee);
            JOptionPane.showMessageDialog(null, "Empleado editado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos para editar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void lblDetailMobileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailMobileMouseClicked

        Mobile mobile = daoMobile.readByImei(cmbMobile.getSelectedItem().toString());
        String label = String.format(
                "<html>IMEI: %s<br>"
                + "Marca: %s<br>"
                + "Modelo: %s<br>"
                + "Capacidad almacenamiento: %s<br>"
                + "Cámara frontal: %s<br>"
                + "Cámara trasera: %s<br>"
                + "Almacenamiento interno: %s<br>"
                + "Sistema operativo: %s<br>"
                + "Antivirus: %s<br>"
                + "Fecha entrega: %s<br>"
                + "Número telefónico: +56 9%s"
                + "<br><br></html>",
                mobile.getImei(), mobile.getBrand(),
                mobile.getModel(), mobile.getStorageCapacity(),
                mobile.getFrontCamera(), mobile.getBackCamera(),
                mobile.getInternalStorage(), mobile.getOperatingSystem(),
                mobile.isAntivirus(), mobile.getMobileDate(),
                mobile.getMobileNumber());

        JLabel detailMobile = new JLabel(label);
        detailMobile.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        JOptionPane.showMessageDialog(null,
                detailMobile,
                "Detalle teléfono móvil",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblDetailMobileMouseClicked

    private void cmbMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMobileActionPerformed

        String selected = cmbMobile.getSelectedItem().toString();
        Mobile mobile = daoMobile.readByImei(selected);
        if (mobile == null) {
            lblMobileInformation.setText("No ha seleccionado ningún teléfono móvil");
            lblDetailMobile.setEnabled(false);
        } else {
            lblMobileInformation.setText(String.format("%s, %s: %s", mobile.getBrand(), mobile.getModel(), mobile.getMobileNumber()));
            lblDetailMobile.setEnabled(true);
        }
    }//GEN-LAST:event_cmbMobileActionPerformed

    private void getDepartments() {
        daoDepartment = new DepartmentDaoImpl();
        departments = daoDepartment.findAll();
        departments.forEach((department) -> {
            cmbDepartment.addItem(department.getDepartment());
        });
    }

    private void getCities() {
        daoCity = new CityDaoImpl();
        cities = daoCity.findAll();
        cities.forEach((city) -> {
            cmbCity.addItem(city.getCity());
        });
    }

    private void getMobiles() {
        daoMobile = new MobileDaoImpl();
        mobiles = daoMobile.findAll();
        for (Mobile mobile : mobiles) {
            if (mobile.isMobileStatus() == false) {
                cmbMobile.addItem(String.format("%s", mobile.getImei()));
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCity;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JComboBox<String> cmbMobile;
    private com.toedter.calendar.JDateChooser jDateChooserCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDetailMobile;
    private javax.swing.JLabel lblMobileInformation;
    private javax.swing.JLabel lblOperatingSystem;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables
}
