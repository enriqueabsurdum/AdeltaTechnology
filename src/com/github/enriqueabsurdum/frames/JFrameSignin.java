package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.UserDaoImpl;
import com.github.enriqueabsurdum.models.User;
import javax.swing.JOptionPane;

public class JFrameSignin extends javax.swing.JFrame {

    private UserDaoImpl daoUser;
    private User user;
    
    private JFrameMain jFrameMain;

    public JFrameSignin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlMainSignIn = new javax.swing.JPanel();
        lblEmailAddress = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        lblForgotPassword = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblMainTitle = new javax.swing.JLabel();
        lblMainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign in");
        setResizable(false);

        pnlMainSignIn.setBackground(java.awt.Color.white);
        pnlMainSignIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 129, 142)));

        lblEmailAddress.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblEmailAddress.setText("Correo electrónico");

        lblPassword.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblPassword.setText("Contraseña");

        btnSignIn.setBackground(new java.awt.Color(0, 198, 154));
        btnSignIn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnSignIn.setForeground(java.awt.Color.white);
        btnSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-signin-16.png"))); // NOI18N
        btnSignIn.setText("Iniciar sesión");
        btnSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignIn.setFocusPainted(false);
        btnSignIn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSignIn.setIconTextGap(10);
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        lblForgotPassword.setFont(new java.awt.Font("Ubuntu", 0, 13)); // NOI18N
        lblForgotPassword.setForeground(java.awt.Color.blue);
        lblForgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblForgotPassword.setText("¿Olvidaste contraseña?");
        lblForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPasswordMouseClicked(evt);
            }
        });

        txtEmailAddress.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtEmailAddress.setMargin(new java.awt.Insets(0, 4, 0, 0));

        txtPassword.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPassword.setMargin(new java.awt.Insets(0, 5, 0, 0));

        javax.swing.GroupLayout pnlMainSignInLayout = new javax.swing.GroupLayout(pnlMainSignIn);
        pnlMainSignIn.setLayout(pnlMainSignInLayout);
        pnlMainSignInLayout.setHorizontalGroup(
            pnlMainSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainSignInLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlMainSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmailAddress)
                    .addGroup(pnlMainSignInLayout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblForgotPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(txtEmailAddress)
                    .addComponent(txtPassword))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlMainSignInLayout.setVerticalGroup(
            pnlMainSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainSignInLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblEmailAddress)
                .addGap(10, 10, 10)
                .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(pnlMainSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(lblForgotPassword))
                .addGap(10, 10, 10)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        lblMainTitle.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblMainTitle.setForeground(new java.awt.Color(48, 62, 82));
        lblMainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainTitle.setText("Iniciar sesión en Adelta Tecnología");
        lblMainTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblMainImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/image-signin.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(pnlMainSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblMainTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addComponent(lblMainImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblMainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlMainSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPasswordMouseClicked

        JOptionPane.showMessageDialog(null, "Lorem", "Lorem", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblForgotPasswordMouseClicked

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed

        String username, password;
        username = txtEmailAddress.getText();
        password = new String(txtPassword.getPassword());

        if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese correo electrónico", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            daoUser = new UserDaoImpl();
            user = daoUser.getLogin(username, password);
            if (user != null) {
                jFrameMain = new JFrameMain(user);
                jFrameMain.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new JFrameSignin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblMainImage;
    private javax.swing.JLabel lblMainTitle;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel pnlMainSignIn;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
