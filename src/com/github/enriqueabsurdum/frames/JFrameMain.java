package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.AuditDaoImpl;
import com.github.enriqueabsurdum.dao.EmployeeDaoImpl;
import com.github.enriqueabsurdum.dao.MobileDaoImpl;
import com.github.enriqueabsurdum.models.Employee;
import com.github.enriqueabsurdum.models.Mobile;
import com.github.enriqueabsurdum.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class JFrameMain extends javax.swing.JFrame {

    private User user;
    private List<Mobile> mobiles;
    private List<Employee> employees;

    private JFrameTableMobile jFrameTableMobile;
    private JFrameTableEmployee jFrameTableEmployee;
    private JFrameTableUser jFrameTableUser;
    private JFrameAddUser jFrameAddUser;
    private JFrameAddEmployee jFrameAddEmployee;
    private JFrameAudit jFrameAudit;

    public JFrameMain() {
        initComponents();
        getRowCountMobiles();
        getRowCountEmployees();
    }

    public JFrameMain(User user) {
        initComponents();
        getRowCountMobiles();
        getRowCountEmployees();
        this.user = user;
        getUserLogin();
        setProfiles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUserLogin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddMobile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCountMobiles = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAddEmployee = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblCountEmployees = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnTableMobile = new javax.swing.JButton();
        btnTableEmployee = new javax.swing.JButton();
        btnTableUser = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnUpdatePlan = new javax.swing.JButton();
        btnAddMobileEmployee = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        lblShowPerfil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Adelta Tecnología");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        jLabel1.setForeground(java.awt.Color.darkGray);
        jLabel1.setText("Adelta Tecnología");
        jLabel1.setIconTextGap(8);

        lblUserLogin.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblUserLogin.setForeground(new java.awt.Color(0, 198, 154));
        lblUserLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserLogin.setText("Profile, Name Surname");
        lblUserLogin.setToolTipText("");
        lblUserLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 198, 154)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 129, 142)));

        btnAddMobile.setBackground(new java.awt.Color(0, 198, 154));
        btnAddMobile.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnAddMobile.setForeground(java.awt.Color.white);
        btnAddMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-plus-20.png"))); // NOI18N
        btnAddMobile.setText("Agregar nuevo dispositivo");
        btnAddMobile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddMobile.setFocusPainted(false);
        btnAddMobile.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAddMobile.setIconTextGap(10);
        btnAddMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMobileActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/black-mobile-64.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.darkGray);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Teléfonos móviles registrados");

        lblCountMobiles.setFont(new java.awt.Font("Ubuntu", 1, 38)); // NOI18N
        lblCountMobiles.setForeground(java.awt.Color.darkGray);
        lblCountMobiles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCountMobiles.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCountMobiles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCountMobiles, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnAddMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 129, 142)));

        btnAddEmployee.setBackground(new java.awt.Color(0, 198, 154));
        btnAddEmployee.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnAddEmployee.setForeground(java.awt.Color.white);
        btnAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-plus-20.png"))); // NOI18N
        btnAddEmployee.setText("Agregar nuevo empleado");
        btnAddEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddEmployee.setFocusPainted(false);
        btnAddEmployee.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAddEmployee.setIconTextGap(10);
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/black-employee-64.png"))); // NOI18N

        lblCountEmployees.setFont(new java.awt.Font("Ubuntu", 1, 38)); // NOI18N
        lblCountEmployees.setForeground(java.awt.Color.darkGray);
        lblCountEmployees.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCountEmployees.setText("0");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.darkGray);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Empleados registrados");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCountEmployees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCountEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 129, 142)));

        btnTableMobile.setBackground(new java.awt.Color(120, 129, 142));
        btnTableMobile.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnTableMobile.setForeground(java.awt.Color.white);
        btnTableMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-mobile-20.png"))); // NOI18N
        btnTableMobile.setText("Listar teléfonos móviles");
        btnTableMobile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTableMobile.setFocusPainted(false);
        btnTableMobile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTableMobile.setIconTextGap(25);
        btnTableMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableMobileActionPerformed(evt);
            }
        });

        btnTableEmployee.setBackground(new java.awt.Color(120, 129, 142));
        btnTableEmployee.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnTableEmployee.setForeground(java.awt.Color.white);
        btnTableEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-employee-20.png"))); // NOI18N
        btnTableEmployee.setText("Listar empleados");
        btnTableEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTableEmployee.setFocusPainted(false);
        btnTableEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTableEmployee.setIconTextGap(25);
        btnTableEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableEmployeeActionPerformed(evt);
            }
        });

        btnTableUser.setBackground(new java.awt.Color(120, 129, 142));
        btnTableUser.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnTableUser.setForeground(java.awt.Color.white);
        btnTableUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-user-20.png"))); // NOI18N
        btnTableUser.setText("Listar usuarios del sistema");
        btnTableUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTableUser.setFocusPainted(false);
        btnTableUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTableUser.setIconTextGap(25);
        btnTableUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTableUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTableMobile, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(btnTableEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(btnTableMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnTableEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnTableUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 129, 142)));

        btnUpdatePlan.setBackground(new java.awt.Color(120, 129, 142));
        btnUpdatePlan.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnUpdatePlan.setForeground(java.awt.Color.white);
        btnUpdatePlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-tachometer-20.png"))); // NOI18N
        btnUpdatePlan.setText("Carga de consumo del periodo");
        btnUpdatePlan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdatePlan.setFocusPainted(false);
        btnUpdatePlan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdatePlan.setIconTextGap(25);
        btnUpdatePlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePlanActionPerformed(evt);
            }
        });

        btnAddMobileEmployee.setBackground(new java.awt.Color(120, 129, 142));
        btnAddMobileEmployee.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnAddMobileEmployee.setForeground(java.awt.Color.white);
        btnAddMobileEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-addmobile-20.png"))); // NOI18N
        btnAddMobileEmployee.setText("Asignar equipo a empleado");
        btnAddMobileEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddMobileEmployee.setFocusPainted(false);
        btnAddMobileEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddMobileEmployee.setIconTextGap(25);
        btnAddMobileEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMobileEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddMobileEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdatePlan, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAddMobileEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdatePlan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnSignOut.setBackground(new java.awt.Color(120, 129, 142));
        btnSignOut.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnSignOut.setForeground(java.awt.Color.white);
        btnSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-signout-16.png"))); // NOI18N
        btnSignOut.setText("Cerrar sesión");
        btnSignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignOut.setFocusPainted(false);
        btnSignOut.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSignOut.setIconTextGap(8);
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        lblShowPerfil.setFont(new java.awt.Font("Ubuntu", 2, 13)); // NOI18N
        lblShowPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/black-unlock-16.png"))); // NOI18N
        lblShowPerfil.setText("Ver perfil");
        lblShowPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblShowPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowPerfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUserLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblShowPerfil)
                        .addGap(18, 18, 18)
                        .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        JFrameSignin jFrameSignin = new JFrameSignin();
        dispose();
        jFrameSignin.setVisible(true);
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnAddMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMobileActionPerformed
        JFrameAddMobile jFrameAddMobile = new JFrameAddMobile();
        jFrameAddMobile.setVisible(true);
    }//GEN-LAST:event_btnAddMobileActionPerformed

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
        jFrameAddEmployee = new JFrameAddEmployee();
        jFrameAddEmployee.setVisible(true);
    }//GEN-LAST:event_btnAddEmployeeActionPerformed

    private void btnTableMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableMobileActionPerformed
        jFrameTableMobile = new JFrameTableMobile(user);
        jFrameTableMobile.setVisible(true);
    }//GEN-LAST:event_btnTableMobileActionPerformed

    private void btnTableUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableUserActionPerformed
        jFrameTableUser = new JFrameTableUser();
        jFrameTableUser.setVisible(true);

    }//GEN-LAST:event_btnTableUserActionPerformed

    private void btnTableEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableEmployeeActionPerformed
        jFrameTableEmployee = new JFrameTableEmployee(user);
        jFrameTableEmployee.setVisible(true);
    }//GEN-LAST:event_btnTableEmployeeActionPerformed

    private void btnUpdatePlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePlanActionPerformed
        MobileDaoImpl daoMobile = new MobileDaoImpl();

        String imei = JOptionPane.showInputDialog(null, "Ingrese IMEI del teléfono móvil", "Cargar consumo período", JOptionPane.QUESTION_MESSAGE);
        if (imei != null) {
            if (daoMobile.readByImei(imei) == null) {
                JOptionPane.showMessageDialog(null, "La búsqueda no ha arrojado resultados\nAsegúrese que el empleado existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Mobile mobile = daoMobile.readByImei(imei);
                jFrameAudit = new JFrameAudit(mobile);
                jFrameAudit.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnUpdatePlanActionPerformed

    private void btnAddMobileEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMobileEmployeeActionPerformed

        EmployeeDaoImpl daoEmployee = new EmployeeDaoImpl();

        String run = JOptionPane.showInputDialog(null, "Ingrese RUN del empleado (Ejemplo: 16909497-7)", "Asignar teléfono móvil", JOptionPane.QUESTION_MESSAGE);

        if (run != null) {
            if (daoEmployee.getByRun(run) == null) {
                JOptionPane.showMessageDialog(null, "La búsqueda no ha arrojado resultados\nAsegúrese que el empleado existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Employee employee = daoEmployee.getByRun(run);
                if (employee.getMobile() == null) {
                    jFrameAddEmployee = new JFrameAddEmployee(employee);
                    jFrameAddEmployee.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "El empleado ya cuenta con un teléfono móvil", "Observación", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAddMobileEmployeeActionPerformed

    private void lblShowPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowPerfilMouseClicked
        String label = "Perfil usuario";
        jFrameAddUser = new JFrameAddUser(this.user, label);
        jFrameAddUser.setVisible(true);

    }//GEN-LAST:event_lblShowPerfilMouseClicked

    private void getRowCountMobiles() {
        mobiles = new ArrayList<>();
        MobileDaoImpl daoMobile = new MobileDaoImpl();
        mobiles = daoMobile.findAll();
        lblCountMobiles.setText(String.valueOf(mobiles.size()));
    }

    private void getRowCountEmployees() {
        employees = new ArrayList<>();
        EmployeeDaoImpl daoEmployee = new EmployeeDaoImpl();
        employees = daoEmployee.findAll();
        lblCountEmployees.setText(String.valueOf(employees.size()));
    }

    private void getUserLogin() {
        String userLogin = String.format("%s, %s %s", user.getProfile().getProfile(), user.getName(), user.getLastName());
        lblUserLogin.setText(userLogin);
    }

    private void setProfiles() {
        if (user.getProfile().getProfile().equals("Consultor")) {
            btnAddMobile.setEnabled(false);
            btnAddEmployee.setEnabled(false);
            btnTableUser.setEnabled(false);
            btnAddMobileEmployee.setEnabled(false);
            btnUpdatePlan.setEnabled(false);
        }

        if (user.getProfile().getProfile().equals("Encargado")) {
            btnAddMobile.setEnabled(true);
            btnAddEmployee.setEnabled(true);
            btnTableUser.setEnabled(false);
            btnAddMobileEmployee.setEnabled(true);
            btnUpdatePlan.setEnabled(true);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmployee;
    private javax.swing.JButton btnAddMobile;
    private javax.swing.JButton btnAddMobileEmployee;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnTableEmployee;
    private javax.swing.JButton btnTableMobile;
    private javax.swing.JButton btnTableUser;
    private javax.swing.JButton btnUpdatePlan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblCountEmployees;
    private javax.swing.JLabel lblCountMobiles;
    private javax.swing.JLabel lblShowPerfil;
    private javax.swing.JLabel lblUserLogin;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
