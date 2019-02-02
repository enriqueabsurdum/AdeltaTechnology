package com.github.enriqueabsurdum.frames;

import com.github.enriqueabsurdum.dao.BrandDaoImpl;
import com.github.enriqueabsurdum.dao.MobileDaoImpl;
import com.github.enriqueabsurdum.dao.MobilePlanDaoImpl;
import com.github.enriqueabsurdum.dao.PlanDaoImpl;
import com.github.enriqueabsurdum.enums.OperatingSystem;
import com.github.enriqueabsurdum.models.Brand;
import com.github.enriqueabsurdum.models.Mobile;
import com.github.enriqueabsurdum.models.MobilePlan;
import com.github.enriqueabsurdum.models.Plan;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JFrameAddMobile extends javax.swing.JFrame {

    private PlanDaoImpl daoPlan;
    private MobileDaoImpl daoMobile;
    private MobilePlanDaoImpl daoMobilePlan;
    private List<MobilePlan> mobilePlans;
    private BrandDaoImpl daoBrand;
    private List<Brand> brands;
    private List<Plan> plans;
    private Mobile mobile;

    public JFrameAddMobile() {
        initComponents();
        getBrands();
        getOperatingSystem();
        getPlans();
        setInitComponents();

        jDateChooserCalendar.setEnabled(false);
        lblPlansTalkInfo.setEnabled(false);
        lblPlansDataInfo.setEnabled(false);
        lblPlansSmsInfo.setEnabled(false);

        cmbMobileStatus.removeAllItems();
        cmbMobileStatus.addItem("Disponible");
    }

    public JFrameAddMobile(Mobile mobile) {
        initComponents();
        getBrands();
        getOperatingSystem();
        getPlans();

        this.mobile = mobile;

        txtImei.setText(mobile.getImei());
        txtModel.setText(mobile.getModel());
        txtStorageCapacity.setText(mobile.getStorageCapacity());
        txtFrontCamera.setText(mobile.getFrontCamera());
        txtBackCamera.setText(mobile.getBackCamera());
        txtInternalStorage.setText(mobile.getInternalStorage());
        txtPhoneNumber.setText(mobile.getMobileNumber());

        try {
            if (mobile.getMobileDate() != null) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(mobile.getMobileDate());
                jDateChooserCalendar.setDate(date);
            }
        } catch (ParseException pe) {
            System.out.printf("Calendar exception: %s\n", pe.getMessage());
        }

        cmbBrand.setSelectedItem(mobile.getBrand());
        cmbOperatingSystem.setSelectedItem(mobile.getOperatingSystem());
        if (mobile.isAntivirus() == true) {
            cmbAntivirus.setSelectedItem("Sí");
        } else if (mobile.isAntivirus() == false) {
            cmbAntivirus.setSelectedItem("No");
        }

        if (mobile.isMobileStatus() == true) {
            cmbMobileStatus.setSelectedItem("Asignado");
        } else if (mobile.isMobileStatus() == false) {
            cmbMobileStatus.setSelectedItem("Disponible");
        }

        daoMobilePlan = new MobilePlanDaoImpl();
        daoPlan = new PlanDaoImpl();
        mobilePlans = daoMobilePlan.findByMobile(mobile.getId());
        for (MobilePlan mobilePlan : mobilePlans) {
            Plan plan = daoPlan.read(mobilePlan.getIdPlan());
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de datos")) {
                cmbDataPlan.setSelectedItem(plan.getPlan());
            }
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de voz")) {
                cmbTalkPlan.setSelectedItem(plan.getPlan());
            }
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de SMS")) {
                cmbSmsPlan.setSelectedItem(plan.getPlan());
            }
        }

        if (cmbDataPlan.getSelectedIndex() != 0) {
            lblPlansDataInfo.setEnabled(true);
        } else {
            lblPlansDataInfo.setEnabled(false);
        }
        if (cmbTalkPlan.getSelectedIndex() != 0) {
            lblPlansTalkInfo.setEnabled(true);
        } else {
            lblPlansTalkInfo.setEnabled(false);
        }
        if (cmbSmsPlan.getSelectedIndex() != 0) {
            lblPlansSmsInfo.setEnabled(true);
        } else {
            lblPlansSmsInfo.setEnabled(false);
        }

        btnSave.setVisible(false);
        btnEdit.setVisible(true);
        lblTitle.setText("Editar teléfono móvil");
    }

    public JFrameAddMobile(Mobile mobile, boolean value) {
        initComponents();
        getBrands();
        getOperatingSystem();
        getPlans();

        this.mobile = mobile;

        txtImei.setText(mobile.getImei());
        txtModel.setText(mobile.getModel());
        txtStorageCapacity.setText(mobile.getStorageCapacity());
        txtFrontCamera.setText(mobile.getFrontCamera());
        txtBackCamera.setText(mobile.getBackCamera());
        txtInternalStorage.setText(mobile.getInternalStorage());
        txtPhoneNumber.setText(mobile.getMobileNumber());

        try {
            if (mobile.getMobileDate() != null) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(mobile.getMobileDate());
                jDateChooserCalendar.setDate(date);
            }
        } catch (ParseException pe) {
            System.out.printf("Calendar exception: %s\n", pe.getMessage());
        }

        cmbBrand.removeAllItems();
        cmbBrand.addItem(mobile.getBrand());

        cmbOperatingSystem.removeAllItems();
        cmbOperatingSystem.addItem(mobile.getOperatingSystem());

        cmbAntivirus.removeAllItems();
        if (mobile.isAntivirus() == true) {
            cmbAntivirus.addItem("Sí");
        } else if (mobile.isAntivirus() == false) {
            cmbAntivirus.addItem("No");
        }

        cmbMobileStatus.removeAllItems();
        if (mobile.isMobileStatus() == true) {
            cmbMobileStatus.addItem("Asignado");
        } else if (mobile.isMobileStatus() == false) {
            cmbMobileStatus.addItem("Disponible");
        }

        daoMobilePlan = new MobilePlanDaoImpl();
        daoPlan = new PlanDaoImpl();
        mobilePlans = daoMobilePlan.findByMobile(mobile.getId());
        cmbDataPlan.removeAllItems();
        cmbTalkPlan.removeAllItems();
        cmbSmsPlan.removeAllItems();
        for (MobilePlan mobilePlan : mobilePlans) {
            Plan plan = daoPlan.read(mobilePlan.getIdPlan());
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de datos")) {
                cmbDataPlan.addItem(plan.getPlan());
                lblPlansDataInfo.setEnabled(true);
            }
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de voz")) {
                cmbTalkPlan.addItem(plan.getPlan());
                lblPlansTalkInfo.setEnabled(true);
            }
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de SMS")) {
                cmbSmsPlan.addItem(plan.getPlan());
                lblPlansSmsInfo.setEnabled(true);
            }
        }

        setEditableComponents(value);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtImei = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        txtStorageCapacity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFrontCamera = new javax.swing.JTextField();
        txtBackCamera = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        cmbAntivirus = new javax.swing.JComboBox<>();
        cmbBrand = new javax.swing.JComboBox<>();
        lblOperatingSystem = new javax.swing.JLabel();
        txtInternalStorage = new javax.swing.JTextField();
        jDateChooserCalendar = new com.toedter.calendar.JDateChooser();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbMobileStatus = new javax.swing.JComboBox<>();
        cmbOperatingSystem = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        lblPlansDataInfo = new javax.swing.JLabel();
        cmbSmsPlan = new javax.swing.JComboBox<>();
        lblPlansTalkInfo = new javax.swing.JLabel();
        cmbTalkPlan = new javax.swing.JComboBox<>();
        lblPlansSmsInfo = new javax.swing.JLabel();
        cmbDataPlan = new javax.swing.JComboBox<>();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teléfono móvil");
        setResizable(false);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 198, 154)));
        jPanel2.setForeground(java.awt.Color.darkGray);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.darkGray);
        jLabel1.setText("IMEI");

        txtImei.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtImei.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.darkGray);
        jLabel2.setText("Marca");

        txtModel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtModel.setMargin(new java.awt.Insets(0, 5, 0, 0));

        txtStorageCapacity.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtStorageCapacity.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.darkGray);
        jLabel3.setText("Capacidad almacenamiento");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.darkGray);
        jLabel4.setText("Modelo");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.darkGray);
        jLabel5.setText("Zoom cámara trasera");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.darkGray);
        jLabel6.setText("Zoom cámara frontal");

        txtFrontCamera.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtFrontCamera.setMargin(new java.awt.Insets(0, 5, 0, 0));

        txtBackCamera.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtBackCamera.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.darkGray);
        jLabel7.setText("Almacenamiento interno");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.darkGray);
        jLabel8.setText("Antivirus");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.darkGray);
        jLabel9.setText("Fecha entrega");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.darkGray);
        jLabel10.setText("Número telefónico");

        txtPhoneNumber.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPhoneNumber.setMargin(new java.awt.Insets(0, 5, 0, 0));

        btnCancel.setBackground(java.awt.Color.lightGray);
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

        cmbAntivirus.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbAntivirus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Sí", "No" }));

        cmbBrand.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una marca" }));

        lblOperatingSystem.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblOperatingSystem.setForeground(java.awt.Color.darkGray);
        lblOperatingSystem.setText("Sistema operativo");

        txtInternalStorage.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtInternalStorage.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jDateChooserCalendar.setDateFormatString("yyyy-MM-dd");

        btnSave.setBackground(new java.awt.Color(0, 198, 154));
        btnSave.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnSave.setForeground(java.awt.Color.white);
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/white-save-16.png"))); // NOI18N
        btnSave.setText("Guardar");
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
        btnEdit.setFocusPainted(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnEdit.setIconTextGap(10);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.darkGray);
        jLabel11.setText("Estado");

        cmbMobileStatus.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbMobileStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Disponible", "Asignado" }));

        cmbOperatingSystem.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbOperatingSystem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un OS" }));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.darkGray);
        jLabel12.setText("Planes");

        lblPlansDataInfo.setFont(new java.awt.Font("Ubuntu", 2, 11)); // NOI18N
        lblPlansDataInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/image-info.png"))); // NOI18N
        lblPlansDataInfo.setText("Ver detalles");
        lblPlansDataInfo.setToolTipText("Más información");
        lblPlansDataInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPlansDataInfo.setDisabledIcon(null);
        lblPlansDataInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlansDataInfoMouseClicked(evt);
            }
        });

        cmbSmsPlan.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbSmsPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin plan de SMS" }));
        cmbSmsPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSmsPlanActionPerformed(evt);
            }
        });

        lblPlansTalkInfo.setFont(new java.awt.Font("Ubuntu", 2, 11)); // NOI18N
        lblPlansTalkInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/image-info.png"))); // NOI18N
        lblPlansTalkInfo.setText("Ver detalles");
        lblPlansTalkInfo.setToolTipText("Más información");
        lblPlansTalkInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPlansTalkInfo.setDisabledIcon(null);
        lblPlansTalkInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlansTalkInfoMouseClicked(evt);
            }
        });

        cmbTalkPlan.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbTalkPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin plan de voz" }));
        cmbTalkPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTalkPlanActionPerformed(evt);
            }
        });

        lblPlansSmsInfo.setFont(new java.awt.Font("Ubuntu", 2, 11)); // NOI18N
        lblPlansSmsInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/image-info.png"))); // NOI18N
        lblPlansSmsInfo.setText("Ver detalles");
        lblPlansSmsInfo.setToolTipText("Más información");
        lblPlansSmsInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPlansSmsInfo.setDisabledIcon(null);
        lblPlansSmsInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlansSmsInfoMouseClicked(evt);
            }
        });

        cmbDataPlan.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbDataPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin plan de datos" }));
        cmbDataPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDataPlanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cmbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblOperatingSystem)
                                        .addGap(126, 126, 126))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(cmbOperatingSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtStorageCapacity)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jDateChooserCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFrontCamera))
                                    .addComponent(jLabel6))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10)
                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(txtBackCamera))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAntivirus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtInternalStorage)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(cmbMobileStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(104, 104, 104)
                                .addComponent(lblPlansDataInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPlansTalkInfo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbDataPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTalkPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSmsPlan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlansSmsInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblOperatingSystem)
                        .addComponent(jLabel8))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbOperatingSystem, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbAntivirus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtStorageCapacity, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBackCamera, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtInternalStorage)
                    .addComponent(txtFrontCamera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMobileStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlansDataInfo)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(lblPlansSmsInfo)
                        .addComponent(lblPlansTalkInfo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSmsPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTalkPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbDataPlan))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblTitle.setForeground(java.awt.Color.darkGray);
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/enriqueabsurdum/images/black-mobile-20.png"))); // NOI18N
        lblTitle.setText("Teléfonos móviles");
        lblTitle.setIconTextGap(10);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void lblPlansDataInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlansDataInfoMouseClicked
        daoPlan = new PlanDaoImpl();
        Plan plan = daoPlan.readByPlan(cmbDataPlan.getSelectedItem().toString());
        String label = String.format("<html>%s<br>Descripción: %s<br><br>", plan.getPlan(), plan.getDescription());
        JLabel detailDataPlan = new JLabel(label);
        detailDataPlan.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        JOptionPane.showMessageDialog(null, detailDataPlan, "Detalle plan de datos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblPlansDataInfoMouseClicked

    private void lblPlansTalkInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlansTalkInfoMouseClicked
        daoPlan = new PlanDaoImpl();
        Plan plan = daoPlan.readByPlan(cmbTalkPlan.getSelectedItem().toString());
        String label = String.format("<html>%s<br>Descripción: %s<br><br>", plan.getPlan(), plan.getDescription());
        JLabel detailDataPlan = new JLabel(label);
        detailDataPlan.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        JOptionPane.showMessageDialog(null, detailDataPlan, "Detalle plan de voz", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblPlansTalkInfoMouseClicked

    private void lblPlansSmsInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlansSmsInfoMouseClicked
        daoPlan = new PlanDaoImpl();
        Plan plan = daoPlan.readByPlan(cmbSmsPlan.getSelectedItem().toString());
        String label = String.format("<html>%s<br>Descripción: %s<br><br>", plan.getPlan(), plan.getDescription());
        JLabel detailDataPlan = new JLabel(label);
        detailDataPlan.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        JOptionPane.showMessageDialog(null, detailDataPlan, "Detalle plan de SMS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblPlansSmsInfoMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        daoMobile = new MobileDaoImpl();
        daoPlan = new PlanDaoImpl();
        daoMobilePlan = new MobilePlanDaoImpl();
        MobilePlan mobilePlan;

        String imei, brand, model, operatingSystems, storageCapacity, frontCamera,
                backCamera, internalStorage, phoneNumber, mobileDate = null;
        boolean antivirus = true, mobileStatus = false;

        if (!txtImei.getText().equals("") && cmbBrand.getSelectedIndex() != 0
                && !txtModel.getText().equals("") && cmbOperatingSystem.getSelectedIndex() != 0
                && !txtStorageCapacity.getText().equals("") && cmbAntivirus.getSelectedIndex() != 0
                && !txtFrontCamera.getText().equals("") && !txtBackCamera.getText().equals("")
                && !txtInternalStorage.getText().equals("") && !txtPhoneNumber.getText().equals("")) {

            imei = txtImei.getText();
            model = txtModel.getText();
            storageCapacity = txtStorageCapacity.getText();
            frontCamera = txtFrontCamera.getText();
            backCamera = txtBackCamera.getText();
            internalStorage = txtInternalStorage.getText();
            phoneNumber = txtPhoneNumber.getText();

            brand = cmbBrand.getSelectedItem().toString();
            operatingSystems = cmbOperatingSystem.getSelectedItem().toString();
            antivirus = cmbAntivirus.getSelectedIndex() == 1 ? antivirus : false;

            mobile = new Mobile(0, imei, brand, model, storageCapacity,
                    frontCamera, backCamera, internalStorage, operatingSystems,
                    antivirus, mobileDate, phoneNumber, mobileStatus);
            daoMobile.create(mobile);

            int idMobile = daoMobile.readByImei(imei).getId();
            if (cmbDataPlan.getSelectedIndex() != 0) {
                Plan planData = daoPlan.readByPlan(cmbDataPlan.getSelectedItem().toString());
                mobilePlan = new MobilePlan(0, idMobile, planData.getId());
                daoMobilePlan.create(mobilePlan);
            }

            if (cmbTalkPlan.getSelectedIndex() != 0) {
                Plan planTalk = daoPlan.readByPlan(cmbTalkPlan.getSelectedItem().toString());
                mobilePlan = new MobilePlan(0, idMobile, planTalk.getId());
                daoMobilePlan.create(mobilePlan);
            }

            if (cmbSmsPlan.getSelectedIndex() != 0) {
                Plan planSms = daoPlan.readByPlan(cmbSmsPlan.getSelectedItem().toString());
                mobilePlan = new MobilePlan(0, idMobile, planSms.getId());
                daoMobilePlan.create(mobilePlan);
            }

            JOptionPane.showMessageDialog(null, "Teléfono móvil registrado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos para guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        daoMobile = new MobileDaoImpl();
        daoPlan = new PlanDaoImpl();
        daoMobilePlan = new MobilePlanDaoImpl();

        String imei, brand, model, operatingSystems, storageCapacity, frontCamera,
                backCamera, internalStorage, phoneNumber, mobileDate = null;
        boolean antivirus = true, mobileStatus;

        if (!txtImei.getText().equals("") && cmbBrand.getSelectedIndex() != 0
                && !txtModel.getText().equals("") && cmbOperatingSystem.getSelectedIndex() != 0
                && !txtStorageCapacity.getText().equals("") && cmbAntivirus.getSelectedIndex() != 0
                && !txtFrontCamera.getText().equals("") && !txtBackCamera.getText().equals("")
                && !txtInternalStorage.getText().equals("") && !txtPhoneNumber.getText().equals("")) {

            try {
                Date date = jDateChooserCalendar.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                mobileDate = sdf.format(date);
            } catch (Exception e) {
            }

            imei = txtImei.getText();
            model = txtModel.getText();
            storageCapacity = txtStorageCapacity.getText();
            frontCamera = txtFrontCamera.getText();
            backCamera = txtBackCamera.getText();
            internalStorage = txtInternalStorage.getText();
            phoneNumber = txtPhoneNumber.getText();

            brand = cmbBrand.getSelectedItem().toString();
            operatingSystems = cmbOperatingSystem.getSelectedItem().toString();
            antivirus = cmbAntivirus.getSelectedIndex() == 1 ? antivirus : false;

            if (cmbMobileStatus.getSelectedItem().toString().equalsIgnoreCase("Asignado")) {
                mobileStatus = true;
            } else {
                mobileStatus = false;
            }

            mobile = new Mobile(this.mobile.getId(), imei, brand, model, storageCapacity,
                    frontCamera, backCamera, internalStorage, operatingSystems,
                    antivirus, mobileDate, phoneNumber, mobileStatus);
            daoMobile.update(mobile);

            int idMobile = daoMobile.readByImei(imei).getId();

            boolean data = false, talk = false, sms = false;
            mobilePlans = daoMobilePlan.findByMobile(mobile.getId());
            for (MobilePlan mobilePlan : mobilePlans) {
                Plan plan = daoPlan.read(mobilePlan.getIdPlan());
                if (plan.getPlanType().getType().equalsIgnoreCase("Plan de datos")) {
                    try {
                        mobilePlan = new MobilePlan(mobilePlan.getId(), idMobile, daoPlan.readByPlan(cmbDataPlan.getSelectedItem().toString()).getId());
                        daoMobilePlan.update(mobilePlan);
                        data = true;
                    } catch (Exception e) {
                        daoMobilePlan.delete(mobilePlan.getId());
                    }
                }
                if (plan.getPlanType().getType().equalsIgnoreCase("Plan de voz")) {
                    try {
                        mobilePlan = new MobilePlan(mobilePlan.getId(), idMobile, daoPlan.readByPlan(cmbTalkPlan.getSelectedItem().toString()).getId());
                        daoMobilePlan.update(mobilePlan);
                        talk = true;
                    } catch (Exception e) {
                        daoMobilePlan.delete(mobilePlan.getId());
                    }
                }
                if (plan.getPlanType().getType().equalsIgnoreCase("Plan de SMS")) {
                    try {
                        mobilePlan = new MobilePlan(mobilePlan.getId(), idMobile, daoPlan.readByPlan(cmbSmsPlan.getSelectedItem().toString()).getId());
                        daoMobilePlan.update(mobilePlan);
                        sms = true;
                    } catch (Exception e) {
                        daoMobilePlan.delete(mobilePlan.getId());
                    }
                }
            }

            MobilePlan mobilePlanData, mobilePlanTalk, mobilePlanSms;
            if (data == false && cmbDataPlan.getSelectedIndex() != 0) {
                mobilePlanData = new MobilePlan(0, idMobile, daoPlan.readByPlan(cmbDataPlan.getSelectedItem().toString()).getId());
                daoMobilePlan.create(mobilePlanData);
            }
            if (talk == false && cmbSmsPlan.getSelectedIndex() != 0) {
                mobilePlanTalk = new MobilePlan(0, idMobile, daoPlan.readByPlan(cmbTalkPlan.getSelectedItem().toString()).getId());
                daoMobilePlan.create(mobilePlanTalk);
            }
            if (sms == false && cmbSmsPlan.getSelectedIndex() != 0) {
                mobilePlanSms = new MobilePlan(0, idMobile, daoPlan.readByPlan(cmbSmsPlan.getSelectedItem().toString()).getId());
                daoMobilePlan.create(mobilePlanSms);
            }

            JOptionPane.showMessageDialog(null, "Teléfono móvil editado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos para editar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void cmbDataPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDataPlanActionPerformed

        if (cmbDataPlan.getSelectedIndex() == 0) {
            lblPlansDataInfo.setEnabled(false);
        } else {
            lblPlansDataInfo.setEnabled(true);
        }
    }//GEN-LAST:event_cmbDataPlanActionPerformed

    private void cmbTalkPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTalkPlanActionPerformed

        if (cmbTalkPlan.getSelectedIndex() == 0) {
            lblPlansTalkInfo.setEnabled(false);
        } else {
            lblPlansTalkInfo.setEnabled(true);
        }

    }//GEN-LAST:event_cmbTalkPlanActionPerformed

    private void cmbSmsPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSmsPlanActionPerformed
        if (cmbSmsPlan.getSelectedIndex() == 0) {
            lblPlansSmsInfo.setEnabled(false);
        } else {
            lblPlansSmsInfo.setEnabled(true);
        }
    }//GEN-LAST:event_cmbSmsPlanActionPerformed

    private void getBrands() {
        daoBrand = new BrandDaoImpl();
        brands = daoBrand.findAll();
        brands.forEach((brand) -> {
            cmbBrand.addItem(brand.getBrand());
        });
    }

    private void getOperatingSystem() {
        for (OperatingSystem os : OperatingSystem.values()) {
            cmbOperatingSystem.addItem(os.getOperatingSystem());
        }
    }

    private void getPlans() {
        daoPlan = new PlanDaoImpl();
        plans = daoPlan.findAll();
        for (Plan plan : plans) {
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de datos")) {
                cmbDataPlan.addItem(plan.getPlan());
            }
            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de voz")) {
                cmbTalkPlan.addItem(plan.getPlan());
            }

            if (plan.getPlanType().getType().equalsIgnoreCase("Plan de SMS")) {
                cmbSmsPlan.addItem(plan.getPlan());
            }
        }
    }

    private void setEditableComponents(boolean value) {
        if (value) {
            txtImei.setEditable(false);
            txtModel.setEditable(false);
            txtStorageCapacity.setEditable(false);
            txtFrontCamera.setEditable(false);
            txtBackCamera.setEditable(false);
            txtInternalStorage.setEditable(false);
            jDateChooserCalendar.setEnabled(false);
            txtPhoneNumber.setEditable(false);

            btnSave.setVisible(false);
            btnEdit.setVisible(false);
            lblTitle.setText("Detalle teléfono móvil");
        }

        if (cmbDataPlan.getSelectedIndex() == -1) {
            cmbDataPlan.addItem("Sin plan de datos");
        }
        if (cmbTalkPlan.getSelectedIndex() == -1) {
            cmbTalkPlan.addItem("Sin plan de voz");
        }
        if (cmbSmsPlan.getSelectedIndex() == -1) {
            cmbSmsPlan.addItem("Sin plan de SMS");
        }
    }

    private void setInitComponents() {
        txtImei.setEditable(true);
        cmbBrand.setEnabled(true);
        txtModel.setEditable(true);
        cmbDataPlan.setEnabled(true);
        txtStorageCapacity.setEditable(true);
        txtFrontCamera.setEditable(true);
        txtBackCamera.setEditable(true);
        cmbAntivirus.setEnabled(true);
        txtInternalStorage.setEditable(true);
        jDateChooserCalendar.setEnabled(true);
        txtPhoneNumber.setEditable(true);

        btnSave.setVisible(true);
        btnEdit.setVisible(false);
        lblTitle.setText("Registro teléfono móvil");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAddMobile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbAntivirus;
    private javax.swing.JComboBox<String> cmbBrand;
    private javax.swing.JComboBox<String> cmbDataPlan;
    private javax.swing.JComboBox<String> cmbMobileStatus;
    private javax.swing.JComboBox<String> cmbOperatingSystem;
    private javax.swing.JComboBox<String> cmbSmsPlan;
    private javax.swing.JComboBox<String> cmbTalkPlan;
    private com.toedter.calendar.JDateChooser jDateChooserCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblOperatingSystem;
    private javax.swing.JLabel lblPlansDataInfo;
    private javax.swing.JLabel lblPlansSmsInfo;
    private javax.swing.JLabel lblPlansTalkInfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtBackCamera;
    private javax.swing.JTextField txtFrontCamera;
    private javax.swing.JTextField txtImei;
    private javax.swing.JTextField txtInternalStorage;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtStorageCapacity;
    // End of variables declaration//GEN-END:variables
}
