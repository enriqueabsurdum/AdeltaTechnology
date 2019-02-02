package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.ProfileDaoImpl;
import com.github.enriqueabsurdum.dao.UserDaoImpl;
import com.github.enriqueabsurdum.models.Profile;
import com.github.enriqueabsurdum.models.User;
import java.util.List;
import javax.swing.JOptionPane;

public class JFrameAddUser extends javax.swing.JFrame {

    private UserDaoImpl daoUser;
    private ProfileDaoImpl daoProfile;
    private User user;
    private List<Profile> profiles;

    private JFrameTableUser jFrameTableUser;

    public JFrameAddUser() {
        initComponents();
        getProfiles();
        btnEdit.setVisible(false);
    }

    public JFrameAddUser(User user) {
        initComponents();
        getProfiles();
        btnSave.setVisible(false);
        this.user = user;
        txtRun.setText(user.getRun());
        cmbProfile.setSelectedItem(user.getProfile().getProfile());
        txtName.setText(user.getName());
        txtLastName.setText(user.getLastName());
        txtEmail.setText(user.getEmail());
        txtPassword.setText(user.getPassword());
    }

    JFrameAddUser(User user, String label) {
        initComponents();
        this.user = user;
        lblTitle.setText(label);
        btnCancel.setVisible(true);
        btnEdit.setVisible(false);
        btnSave.setVisible(false);
        txtRun.setText(user.getRun());
        txtName.setText(user.getName());
        txtLastName.setText(user.getLastName());
        txtEmail.setText(user.getEmail());
        txtPassword.setText(user.getPassword());
        
        cmbProfile.removeAllItems();
        cmbProfile.addItem(user.getProfile().getProfile());
        cmbProfile.setSelectedIndex(0);
        
        txtRun.setEditable(false);
        txtName.setEditable(false);
        txtLastName.setEditable(false);
        txtEmail.setEditable(false);
        txtPassword.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblOperatingSystem = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cmbProfile = new javax.swing.JComboBox<>();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");
        setResizable(false);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 198, 154)));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setText("RUN");

        txtRun.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtRun.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Correo electrónico");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setText("Perfil");

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
        lblOperatingSystem.setText("Contraseña");

        txtPassword.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPassword.setMargin(new java.awt.Insets(0, 5, 0, 0));

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

        txtEmail.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtEmail.setMargin(new java.awt.Insets(0, 5, 0, 0));

        cmbProfile.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtName)
                        .addGap(18, 18, 18)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(284, 284, 284)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEmail)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOperatingSystem)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtRun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblOperatingSystem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtEmail))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/black-user-20.png"))); // NOI18N
        lblTitle.setText("Registro usuarios");
        lblTitle.setIconTextGap(10);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        daoUser = new UserDaoImpl();
        String run, sProfile, name, lastName, email, password;
        if (!txtRun.getText().equals("") && cmbProfile.getSelectedIndex() != 0
                && !txtName.getText().equals("") && !txtLastName.getText().equals("")
                && !txtEmail.getText().equals("") && !txtPassword.getText().equals("")) {
            run = txtRun.getText();
            sProfile = cmbProfile.getSelectedItem().toString();
            name = txtName.getText();
            lastName = txtLastName.getText();
            email = txtEmail.getText();
            password = txtPassword.getText();
            user = new User(0, run, name, lastName, daoProfile.getByProfile(sProfile), email, password);
            daoUser.create(user);
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            jFrameTableUser = new JFrameTableUser();
            jFrameTableUser.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos para guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        daoUser = new UserDaoImpl();
        String run, sProfile, name, lastName, email, password;
        if (!txtRun.getText().equals("") && cmbProfile.getSelectedIndex() != 0
                && !txtName.getText().equals("") && !txtLastName.getText().equals("")
                && !txtEmail.getText().equals("") && !txtPassword.getText().equals("")) {
            run = txtRun.getText();
            sProfile = cmbProfile.getSelectedItem().toString();
            name = txtName.getText();
            lastName = txtLastName.getText();
            email = txtEmail.getText();
            password = txtPassword.getText();
            user = new User(this.user.getId(), run, name, lastName, daoProfile.getByProfile(sProfile), email, password);
            daoUser.update(user);
            JOptionPane.showMessageDialog(null, "Usuario editado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos para editar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void getProfiles() {
        daoProfile = new ProfileDaoImpl();
        profiles = daoProfile.findAll();
        profiles.forEach((profile) -> {
            cmbProfile.addItem(profile.getProfile());
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblOperatingSystem;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables
}
