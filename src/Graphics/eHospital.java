package Graphics;

import Resources.Ambulance;
import Resources.Despach;
import Resources.Emergency;
import Resources.HospitalComplex;
import Resources.Location;
import Resources.Paramedic;
import Resources.Ranking;
import Resources.Route;
import Services.Application;
import Services.ModelService;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.graphstream.algorithm.Dijkstra;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

public class eHospital extends javax.swing.JFrame {

    Application app = new Application();
    ModelService md = new ModelService();
    Graph graph = new MultiGraph("embedded");

    public eHospital() {
        Application readAPP = md.readFiles();
        if (readAPP != null) {
            app = readAPP;
        }
        renderPages();
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon logoImage = new ImageIcon("./src/img/Prince.png");
        Icon logoIcon = new ImageIcon(logoImage.getImage().getScaledInstance(logoSpace.getWidth(), logoSpace.getHeight(), Image.SCALE_DEFAULT));
        logoSpace.setIcon(logoIcon);
        Viewer viewer = graph.display(true);
        View view = viewer.getDefaultView();
        main_body_graph.add((Component) view);
        renderGraph();
        this.repaint();
    }

    public void renderPages() {
        this.setDefaultLookAndFeelDecorated(false);
        this.setResizable(false);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteGlassSkin");
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceMetalWallWatermark");
    }

    public void showDialog(JDialog element) {
        element.pack();
        element.setResizable(false);
        element.setLocationRelativeTo(this);
        element.setModal(true);
        element.setVisible(true);
    }

    public void renderTable(DefaultTableModel tableModel, ArrayList elements) {
        tableModel.setRowCount(0);
        if (elements.size() > 0) {
            if (elements.get(0) instanceof HospitalComplex) {
                for (int i = 0; i < elements.size(); i++) {
                    HospitalComplex hospital = (HospitalComplex) elements.get(i);
                    Object[] columns = {hospital.getName(), hospital.getAddress(), hospital.getAmbulances(), hospital.getParamedics(), hospital.getRanking()};
                    tableModel.addRow(columns);
                }
            } else if (elements.get(0) instanceof Paramedic) {
                for (int i = 0; i < elements.size(); i++) {
                    Paramedic paramedic = (Paramedic) elements.get(i);
                    Object[] columns = {paramedic.getId_number(), paramedic.getName(), paramedic.getAge(), paramedic.getHospital(), paramedic.getRanking()};
                    tableModel.addRow(columns);
                }
            } else if (elements.get(0) instanceof Ambulance) {
                for (int i = 0; i < elements.size(); i++) {
                    Ambulance ambulance = (Ambulance) elements.get(i);
                    Object[] columns = {ambulance.getPlateNumber(), ambulance.getSpeed(), ambulance.getHospital(), ambulance.getYear()};
                    tableModel.addRow(columns);
                }
            }
        }
    }

    public void renderList(JComboBox CModel, ArrayList elements) {
        CModel.setModel(new DefaultComboBoxModel());
        DefaultComboBoxModel model = (DefaultComboBoxModel) CModel.getModel();
        for (int i = 0; i < elements.size(); i++) {
            model.addElement(elements.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        window_admin_ambulance = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        create_plact_ambulance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        create_center_ambulance = new javax.swing.JComboBox<>();
        create_date_ambulance = new javax.swing.JSpinner();
        create_speed_ambulance = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        create_ambulance_acept = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ambulance = new javax.swing.JTable();
        delete_table_ambulance = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        reassing_ambulance_ambulance = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        reassing_center_ambulance = new javax.swing.JComboBox<>();
        reassing_ambulance_acept = new javax.swing.JButton();
        window_admin_paramedics = new javax.swing.JDialog();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        create_id_paramedics = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        create_ranking_paramedics = new javax.swing.JComboBox<>();
        create_age_paramedics = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        create_paramedics_acept = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        create_name_paramedics = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        create_center_paramedics = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_paramedics = new javax.swing.JTable();
        delete_table_paramedics = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        reassing_paramedic_paramedic = new javax.swing.JComboBox<>();
        reassing_center_paramedics = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        reassing_paramedics_acept = new javax.swing.JButton();
        window_admin_complex = new javax.swing.JDialog();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        create_direction_complex = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        create_complex_combobox = new javax.swing.JComboBox<>();
        create_paramedics_complex = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        create_complex_acept = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        create_name_complex = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        create_ambulance_complex = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_complex = new javax.swing.JTable();
        delete_table_complex = new javax.swing.JButton();
        window_map_graph = new javax.swing.JDialog();
        main_body_graph = new javax.swing.JPanel();
        body_menu_graph1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        center_list_graph = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        localization_name_map = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        node_init_end = new javax.swing.JComboBox<>();
        emergency_rank_element = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        node_init_graph = new javax.swing.JComboBox<>();
        emergency_center_list = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        emergency_depach_list = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        distance_km_map = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        show_admin_ambulance = new javax.swing.JButton();
        show_admin_hospital = new javax.swing.JButton();
        show_admin_paramedics = new javax.swing.JButton();
        show_admin_maps = new javax.swing.JButton();
        logoSpace = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Número de Placa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Centro Hospitalario");

        create_date_ambulance.setModel(new javax.swing.SpinnerNumberModel(1800, 1800, 2050, 20));

        create_speed_ambulance.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Año de fabricación");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Velocidad Máxima");

        create_ambulance_acept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        create_ambulance_acept.setText("  Aceptar");
        create_ambulance_acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_ambulance_aceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(create_date_ambulance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(create_speed_ambulance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(create_plact_ambulance)
                            .addComponent(create_center_ambulance, 0, 341, Short.MAX_VALUE))))
                .addGap(161, 161, 161))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(create_ambulance_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_plact_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_center_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_date_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_speed_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(create_ambulance_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Creación", jPanel1);

        table_ambulance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Velocidad", "Centro Hospitalario", "Año de fabricación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_ambulance);

        delete_table_ambulance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        delete_table_ambulance.setText("Eliminar");
        delete_table_ambulance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_table_ambulanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete_table_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(delete_table_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Administración", jPanel2);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Ambulancia");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Centro Hospitalario");

        reassing_ambulance_acept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        reassing_ambulance_acept.setText("  Aceptar");
        reassing_ambulance_acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reassing_ambulance_aceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reassing_center_ambulance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reassing_ambulance_ambulance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(reassing_ambulance_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reassing_ambulance_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reassing_center_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(161, 161, 161)
                .addComponent(reassing_ambulance_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab("Reasignación", jPanel7);

        javax.swing.GroupLayout window_admin_ambulanceLayout = new javax.swing.GroupLayout(window_admin_ambulance.getContentPane());
        window_admin_ambulance.getContentPane().setLayout(window_admin_ambulanceLayout);
        window_admin_ambulanceLayout.setHorizontalGroup(
            window_admin_ambulanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(window_admin_ambulanceLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        window_admin_ambulanceLayout.setVerticalGroup(
            window_admin_ambulanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(window_admin_ambulanceLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ranking");

        create_ranking_paramedics.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        create_age_paramedics.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Edad");

        create_paramedics_acept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        create_paramedics_acept.setText("  Aceptar");
        create_paramedics_acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_paramedics_aceptActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Identidad");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Centro Hospitalario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(create_paramedics_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(create_center_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(100, 100, 100)
                                    .addComponent(create_id_paramedics))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(create_age_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(create_ranking_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(429, 429, 429)))
                        .addGap(161, 161, 161))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(252, 252, 252)
                    .addComponent(create_name_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(63, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(create_ranking_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(create_id_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_center_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_age_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addComponent(create_paramedics_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(create_name_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(428, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Creación", jPanel3);

        table_paramedics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identidad", "Nombre", "Edad", "Centro Hospitalario", "Ranking"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_paramedics);

        delete_table_paramedics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        delete_table_paramedics.setText("Eliminar");
        delete_table_paramedics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_table_paramedicsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(delete_table_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(delete_table_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane2.addTab("Administración", jPanel4);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Paramédico");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Centro Hospitalario");

        reassing_paramedics_acept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        reassing_paramedics_acept.setText("  Aceptar");
        reassing_paramedics_acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reassing_paramedics_aceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reassing_center_paramedics, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reassing_paramedic_paramedic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(reassing_paramedics_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reassing_paramedic_paramedic, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reassing_center_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(161, 161, 161)
                .addComponent(reassing_paramedics_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane2.addTab("Reasignación", jPanel8);

        javax.swing.GroupLayout window_admin_paramedicsLayout = new javax.swing.GroupLayout(window_admin_paramedics.getContentPane());
        window_admin_paramedics.getContentPane().setLayout(window_admin_paramedicsLayout);
        window_admin_paramedicsLayout.setHorizontalGroup(
            window_admin_paramedicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(window_admin_paramedicsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        window_admin_paramedicsLayout.setVerticalGroup(
            window_admin_paramedicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(window_admin_paramedicsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nombre");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Ranking");

        create_complex_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        create_paramedics_complex.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Cantidad de Paramédicos");

        create_complex_acept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        create_complex_acept.setText("  Aceptar");
        create_complex_acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_complex_aceptActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Dirección");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Cantidad de Ambulancias");

        create_ambulance_complex.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(create_ambulance_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(create_direction_complex))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(create_paramedics_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(create_name_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(create_complex_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(create_complex_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(161, 161, 161))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(63, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(create_name_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(create_complex_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(create_direction_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_paramedics_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_ambulance_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(create_complex_acept, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane3.addTab("Creación", jPanel5);

        table_complex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dirección", "Cantidad de Ambulancias", "Cantidad de Paramédicos", "Ranking"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table_complex);

        delete_table_complex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        delete_table_complex.setText("Eliminar");
        delete_table_complex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_table_complexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(delete_table_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(delete_table_complex, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane3.addTab("Administración", jPanel6);

        javax.swing.GroupLayout window_admin_complexLayout = new javax.swing.GroupLayout(window_admin_complex.getContentPane());
        window_admin_complex.getContentPane().setLayout(window_admin_complexLayout);
        window_admin_complexLayout.setHorizontalGroup(
            window_admin_complexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(window_admin_complexLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        window_admin_complexLayout.setVerticalGroup(
            window_admin_complexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(window_admin_complexLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout main_body_graphLayout = new javax.swing.GroupLayout(main_body_graph);
        main_body_graph.setLayout(main_body_graphLayout);
        main_body_graphLayout.setHorizontalGroup(
            main_body_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 894, Short.MAX_VALUE)
        );
        main_body_graphLayout.setVerticalGroup(
            main_body_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Ubicaciones");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Centros Hospitalarios");

        center_list_graph.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Localizaciones");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Emergencias");

        node_init_end.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        emergency_rank_element.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emergency_rank_element.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        jButton7.setText("Agregar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Conexiones");

        node_init_graph.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        emergency_center_list.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton8.setText("Agregar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Despacho de Emergencias");

        emergency_depach_list.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton9.setText("Ejecutar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton11.setText("Agregar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout body_menu_graph1Layout = new javax.swing.GroupLayout(body_menu_graph1);
        body_menu_graph1.setLayout(body_menu_graph1Layout);
        body_menu_graph1Layout.setHorizontalGroup(
            body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_menu_graph1Layout.createSequentialGroup()
                .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, body_menu_graph1Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addGroup(body_menu_graph1Layout.createSequentialGroup()
                                .addComponent(center_list_graph, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(body_menu_graph1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_menu_graph1Layout.createSequentialGroup()
                                    .addComponent(node_init_graph, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(node_init_end, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(body_menu_graph1Layout.createSequentialGroup()
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(173, 173, 173)))
                            .addGroup(body_menu_graph1Layout.createSequentialGroup()
                                .addComponent(localization_name_map, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(body_menu_graph1Layout.createSequentialGroup()
                                    .addComponent(emergency_center_list, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(emergency_rank_element, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_menu_graph1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(73, 73, 73)))
                            .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, body_menu_graph1Layout.createSequentialGroup()
                                    .addComponent(emergency_depach_list, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(body_menu_graph1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(distance_km_map)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        body_menu_graph1Layout.setVerticalGroup(
            body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_menu_graph1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(center_list_graph, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localization_name_map, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(node_init_end, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(node_init_graph, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distance_km_map, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergency_rank_element, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergency_center_list, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(body_menu_graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emergency_depach_list, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout window_map_graphLayout = new javax.swing.GroupLayout(window_map_graph.getContentPane());
        window_map_graph.getContentPane().setLayout(window_map_graphLayout);
        window_map_graphLayout.setHorizontalGroup(
            window_map_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(window_map_graphLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_body_graph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body_menu_graph1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        window_map_graphLayout.setVerticalGroup(
            window_map_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, window_map_graphLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(window_map_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(body_menu_graph1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(main_body_graph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Escuela Universitario");

        show_admin_ambulance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ambulance.png"))); // NOI18N
        show_admin_ambulance.setText("   Ambulancias");
        show_admin_ambulance.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        show_admin_ambulance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_admin_ambulanceActionPerformed(evt);
            }
        });

        show_admin_hospital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2000px-Hospital_font_awesome.svg.png"))); // NOI18N
        show_admin_hospital.setText("Hospitales");
        show_admin_hospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_admin_hospitalActionPerformed(evt);
            }
        });

        show_admin_paramedics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paramedico.png"))); // NOI18N
        show_admin_paramedics.setText("  Paramédicos");
        show_admin_paramedics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_admin_paramedicsActionPerformed(evt);
            }
        });

        show_admin_maps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OpenStreetMap-Logo.png"))); // NOI18N
        show_admin_maps.setText("  Mapa");
        show_admin_maps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_admin_mapsActionPerformed(evt);
            }
        });

        logoSpace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Prince.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(show_admin_hospital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(show_admin_paramedics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(show_admin_ambulance, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(show_admin_maps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(logoSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(407, Short.MAX_VALUE)
                        .addComponent(show_admin_hospital)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_admin_paramedics, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_admin_ambulance, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_admin_maps, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(logoSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void show_admin_ambulanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_admin_ambulanceActionPerformed
        if (app.getHospitals().size() > 0) {
            renderList(create_center_ambulance, app.getHospitals());
            renderList(reassing_ambulance_ambulance, app.getAllAmbulances());
            renderList(reassing_center_ambulance, app.getHospitals());
            renderList(reassing_ambulance_ambulance, app.getAllAmbulances());
            renderList(reassing_center_paramedics, app.getHospitals());
            DefaultTableModel tableModel = (DefaultTableModel) table_ambulance.getModel();
            ArrayList ambulances = app.getAllAmbulances();
            renderTable(tableModel, ambulances);
            showDialog(window_admin_ambulance);
        } else {
            JOptionPane.showMessageDialog(null, "No hay centros hospitalarios disponibles.");
        }
    }//GEN-LAST:event_show_admin_ambulanceActionPerformed

    private void show_admin_paramedicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_admin_paramedicsActionPerformed
        if (app.getHospitals().size() > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) table_paramedics.getModel();
            ArrayList paramedics = app.getAllParamedics();
            renderTable(tableModel, paramedics);
            renderList(create_center_paramedics, app.getHospitals());
            renderList(reassing_paramedic_paramedic, app.getAllParamedics());
            renderList(reassing_center_paramedics, app.getHospitals());
            showDialog(window_admin_paramedics);
        } else {
            JOptionPane.showMessageDialog(null, "No hay centros hospitalarios disponibles.");
        }
    }//GEN-LAST:event_show_admin_paramedicsActionPerformed

    private void show_admin_hospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_admin_hospitalActionPerformed
        DefaultTableModel model = (DefaultTableModel) table_complex.getModel();
        renderTable(model, app.getHospitals());
        showDialog(window_admin_complex);
    }//GEN-LAST:event_show_admin_hospitalActionPerformed

    private void create_complex_aceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_complex_aceptActionPerformed
        String name = create_name_complex.getText();
        Ranking ranking = new Ranking();
        String adress = create_direction_complex.getText();
        int ambulances = Integer.parseInt(create_ambulance_complex.getValue().toString());
        int paramedics = Integer.parseInt(create_paramedics_complex.getValue().toString());
        String value = create_complex_combobox.getModel().getSelectedItem().toString();
        if (null != value) {
            switch (value) {
                case "A":
                    ranking = new Ranking("A", 4);
                    break;
                case "B":
                    ranking = new Ranking("B", 3);
                    break;
                case "C":
                    ranking = new Ranking("C", 2);
                    break;
                case "D":
                    ranking = new Ranking("D", 1);
                    break;
                default:
                    break;
            }
        }

        if (app.isValidHospital(name) && !name.isEmpty()) {
            HospitalComplex hospital = new HospitalComplex(name, adress, paramedics, ambulances, ranking);
            app.addHospital(hospital);
            create_name_complex.setText("");
            create_direction_complex.setText("");
            JOptionPane.showMessageDialog(null, "Acción realizada con éxito.");
            renderList(reassing_paramedic_paramedic, app.getAllParamedics());
            renderList(reassing_center_paramedics, app.getHospitals());
            renderList(reassing_ambulance_ambulance, app.getAllAmbulances());
            renderList(reassing_center_paramedics, app.getHospitals());
            md.writeFiles(app);
            DefaultTableModel model = (DefaultTableModel) table_complex.getModel();
            renderTable(model, app.getHospitals());
        } else {
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
        }
    }//GEN-LAST:event_create_complex_aceptActionPerformed

    private void create_ambulance_aceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_ambulance_aceptActionPerformed
        String plate = create_plact_ambulance.getText();
        int year = Integer.parseInt(create_date_ambulance.getValue().toString());
        double speed = Double.parseDouble(create_speed_ambulance.getValue().toString());
        HospitalComplex hospital = (HospitalComplex) create_center_ambulance.getModel().getSelectedItem();
        if (hospital != null && !plate.isEmpty() && app.isValidAmbulance(plate)) {
            Ambulance ambulance = new Ambulance(plate, year, speed);
            if (hospital.getAmbulances() > hospital.getAmbulancesObjects().size()) {
                app.addAmbulance(hospital, ambulance);
                md.writeFiles(app);
                DefaultTableModel tableModel = (DefaultTableModel) table_ambulance.getModel();
                ArrayList ambulances = app.getAllAmbulances();
                renderTable(tableModel, ambulances);
                renderList(reassing_ambulance_ambulance, app.getAllAmbulances());
                renderList(reassing_center_ambulance, app.getHospitals());
                create_plact_ambulance.setText("");
                JOptionPane.showMessageDialog(null, "Acción realizada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento, el numero de ambulancias permitidas, esta excedido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
        }
    }//GEN-LAST:event_create_ambulance_aceptActionPerformed

    private void reassing_ambulance_aceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reassing_ambulance_aceptActionPerformed
        if (app.getAllAmbulances().size() > 0 && app.getHospitals().size() > 0) {
            Ambulance ambulance = (Ambulance) reassing_ambulance_ambulance.getModel().getSelectedItem();
            HospitalComplex newHospitalComplex = (HospitalComplex) reassing_center_ambulance.getModel().getSelectedItem();
            app.moveAmbulance(newHospitalComplex, ambulance);
            DefaultTableModel tableModel = (DefaultTableModel) table_ambulance.getModel();
            ArrayList ambulances = app.getAllAmbulances();
            renderTable(tableModel, ambulances);
            md.writeFiles(app);
            JOptionPane.showMessageDialog(null, "Acción realizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No hay ambulancias o centros hospitalarios.");
        }
    }//GEN-LAST:event_reassing_ambulance_aceptActionPerformed

    private void reassing_paramedics_aceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reassing_paramedics_aceptActionPerformed
        if (app.getAllParamedics().size() > 0 && app.getHospitals().size() > 0) {
            Paramedic paramedic = (Paramedic) reassing_paramedic_paramedic.getModel().getSelectedItem();
            HospitalComplex newHospitalComplex = (HospitalComplex) reassing_center_paramedics.getModel().getSelectedItem();
            app.moveParamedics(newHospitalComplex, paramedic);
            DefaultTableModel tableModel = (DefaultTableModel) table_paramedics.getModel();
            ArrayList paramedics = app.getAllParamedics();
            renderTable(tableModel, paramedics);
            md.writeFiles(app);
            JOptionPane.showMessageDialog(null, "Acción realizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No hay paramédicos o centros hospitalarios.");
        }
    }//GEN-LAST:event_reassing_paramedics_aceptActionPerformed

    private void create_paramedics_aceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_paramedics_aceptActionPerformed
        String name = create_name_paramedics.getText();
        int age = Integer.parseInt(create_age_paramedics.getValue().toString());
        String id = create_id_paramedics.getText();
        Ranking ranking = new Ranking();
        HospitalComplex hospital = (HospitalComplex) create_center_paramedics.getModel().getSelectedItem();
        String value = create_ranking_paramedics.getModel().getSelectedItem().toString();
        if (null != value) {
            switch (value) {
                case "A":
                    ranking = new Ranking("A", 4);
                    break;
                case "B":
                    ranking = new Ranking("B", 3);
                    break;
                case "C":
                    ranking = new Ranking("C", 2);
                    break;
                case "D":
                    ranking = new Ranking("D", 1);
                    break;
                default:
                    break;
            }
        }
        if (hospital != null && !id.isEmpty() && app.isValidParamedic(id)) {
            if (hospital.getParamedics() > hospital.getMedics().size()) {
                Paramedic param = new Paramedic(name, age, id, ranking);
                create_name_paramedics.setText("");
                create_id_paramedics.setText("");
                app.addParamedic(hospital, param);
                DefaultTableModel tableModel = (DefaultTableModel) table_paramedics.getModel();
                ArrayList paramedics = app.getAllParamedics();
                renderTable(tableModel, paramedics);
                renderList(reassing_paramedic_paramedic, app.getAllParamedics());
                renderList(reassing_center_paramedics, app.getHospitals());
                md.writeFiles(app);
                JOptionPane.showMessageDialog(null, "Acción realizada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento, el numero maximo de medicos ha sido excedido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
        }
    }//GEN-LAST:event_create_paramedics_aceptActionPerformed

    private void delete_table_ambulanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_table_ambulanceActionPerformed
        if (table_ambulance.getSelectedRow() >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) table_ambulance.getModel();
            String name = modelo.getValueAt(table_ambulance.getSelectedRow(), 0).toString();
            String hospital = modelo.getValueAt(table_ambulance.getSelectedRow(), 2).toString();
            app.deleteAmbulance(hospital, name);
            renderList(reassing_ambulance_ambulance, app.getAllAmbulances());
            renderList(reassing_center_paramedics, app.getHospitals());
            modelo.removeRow(table_ambulance.getSelectedRow());
            table_ambulance.setModel(modelo);
            md.writeFiles(app);
        } else {
            JOptionPane.showMessageDialog(null, "No hay nada seleccionado.");
        }
    }//GEN-LAST:event_delete_table_ambulanceActionPerformed

    private void delete_table_paramedicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_table_paramedicsActionPerformed
        if (table_paramedics.getSelectedRow() >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) table_paramedics.getModel();
            String id = modelo.getValueAt(table_paramedics.getSelectedRow(), 0).toString();
            String hospital = modelo.getValueAt(table_paramedics.getSelectedRow(), 3).toString();
            app.deleteParamedics(hospital, id);
            renderList(reassing_paramedic_paramedic, app.getAllParamedics());
            renderList(reassing_center_paramedics, app.getHospitals());
            modelo.removeRow(table_paramedics.getSelectedRow());
            table_paramedics.setModel(modelo);
            md.writeFiles(app);
        } else {
            JOptionPane.showMessageDialog(null, "No hay nada seleccionado.");
        }
    }//GEN-LAST:event_delete_table_paramedicsActionPerformed

    private void delete_table_complexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_table_complexActionPerformed
        if (table_complex.getSelectedRow() >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) table_complex.getModel();
            String id = modelo.getValueAt(table_complex.getSelectedRow(), 0).toString();
            app.deleteHospital(id);
            modelo.removeRow(table_complex.getSelectedRow());
            renderList(reassing_paramedic_paramedic, app.getAllParamedics());
            renderList(reassing_center_paramedics, app.getHospitals());
            renderList(reassing_ambulance_ambulance, app.getAllAmbulances());
            renderList(reassing_center_paramedics, app.getHospitals());
            table_complex.setModel(modelo);
            md.writeFiles(app);
        } else {
            JOptionPane.showMessageDialog(null, "No hay nada seleccionado.");
        }
    }//GEN-LAST:event_delete_table_complexActionPerformed

    private void show_admin_mapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_admin_mapsActionPerformed
        if (app.getHospitals().size() > 0) {
            renderList(center_list_graph, app.getHospitals());
            renderList(emergency_center_list, app.getCenters());
            renderList(emergency_depach_list, app.getCenters());
            renderList(node_init_graph, app.getPoints());
            renderList(node_init_end, app.getPoints());
            renderList(emergency_center_list, app.getCenters());
            renderList(emergency_depach_list, app.getCenters());
            showDialog(window_map_graph);
        } else {
            JOptionPane.showMessageDialog(null, "No hay centros hospitalarios disponibles.");
        }
    }//GEN-LAST:event_show_admin_mapsActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultComboBoxModel cbmodel = (DefaultComboBoxModel) center_list_graph.getModel();
        HospitalComplex element = (HospitalComplex) cbmodel.getSelectedItem();
        if (app.getPoints().indexOf(element) == -1) {
            Node n = graph.addNode(element.toString());
            n.addAttribute("ui.label", element.toString());
            app.getPoints().add(element);
            renderList(node_init_graph, app.getPoints());
            renderList(node_init_end, app.getPoints());
            md.writeFiles(app);
        } else {
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String element = localization_name_map.getText();
        if (app.getPointsNames().indexOf(element) == -1 && !element.isEmpty()) {
            Location local = new Location(element);
            Node n2 = graph.addNode(local.toString());
            n2.addAttribute("ui.label", local.toString());
            app.getPoints().add(local);
            app.getPointsNames().add(element);
            localization_name_map.setText("");
            renderList(node_init_graph, app.getPoints());
            renderList(node_init_end, app.getPoints());
            renderList(emergency_center_list, app.getCenters());
            renderList(emergency_depach_list, app.getCenters());
            md.writeFiles(app);
        } else {
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultComboBoxModel cbmodel = (DefaultComboBoxModel) node_init_graph.getModel();
        DefaultComboBoxModel cbmodel2 = (DefaultComboBoxModel) node_init_end.getModel();
        Object init = cbmodel.getSelectedItem();
        Object end = cbmodel2.getSelectedItem();
        try {
            String distance = distance_km_map.getText();
            double db = Double.parseDouble(distance);
            if (!distance.isEmpty()) {
                if (!init.equals(end) && app.getEdgesNames().indexOf(init.toString() + "-" + end.toString()) == -1 && app.getEdgesNames().indexOf(end.toString() + "-" + init.toString()) == -1) {
                    Edge edge = graph.addEdge(init.toString() + "-" + end.toString(), init.toString(), end.toString());
                    edge.addAttribute("ui.label", distance + " km");
                    edge.setAttribute("length", Integer.parseInt(distance));
                    app.getEdgesNames().add(init.toString() + "-" + end.toString());
                    app.getRoutes().add(new Route(init, end, Double.parseDouble(distance)));
                    distance_km_map.setText("");
                    md.writeFiles(app);
                } else {
                    JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultComboBoxModel cbmodel = (DefaultComboBoxModel) emergency_center_list.getModel();
        String rank = emergency_rank_element.getModel().toString();
        Location element = (Location) cbmodel.getSelectedItem();
        Ranking ranking = new Ranking();
        switch (rank) {
            case "A":
                ranking = new Ranking("A", 4);
                break;
            case "B":
                ranking = new Ranking("B", 3);
                break;
            case "C":
                ranking = new Ranking("C", 2);
                break;
            case "D":
                ranking = new Ranking("D", 1);
                break;
            default:
                break;
        }
        element.getEmergencys().addLast(new Emergency(ranking));
        md.writeFiles(app);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Location location = (Location) emergency_depach_list.getModel().getSelectedItem();
        boolean end = false;
        if (location.getEmergencys().size() > 0) {
            ArrayList routes = getRoutes();
            while (!end || routes.isEmpty()) {
                int index = calculateIndexPath(getRoutes());
                int distance = this.calculateDistancePath((ArrayList) routes.get(index));
                String hospital = ((ArrayList) routes.get(index)).get(0).toString();
                HospitalComplex hc = (HospitalComplex) app.getHospitalsPoints().get(findHospitalByName(hospital));
                if (hc.getMedics().size() >= 1 && hc.getMedics().size() >= 3 && hc.getRanking().getValue() >= ((Emergency) location.getEmergencys().peekFirst()).getRanking().getValue()) {
                    JOptionPane.showMessageDialog(null, "La ruta a seguir es: " + routes.get(index));
                    Thread center = new Despach(location, hc, distance);
                    center.run();
                    end = true;
                } else {
                    routes.remove(index);
                }
            }
            if (!end) {
                JOptionPane.showMessageDialog(null, "No hay ningun centro que pueda atender su solicitud.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La localización no tiene ninguna emergencia.");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private int findHospitalByName(String name) {
        ArrayList<HospitalComplex> ap = app.getHospitalsPoints();
        for (int i = 0; i < ap.size(); i++) {
            if (ap.get(i).toString().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int calculateIndexPath(ArrayList nodes) {
        int result = 0;
        int distanceMin = calculateDistancePath((ArrayList) nodes.get(0));
        for (int i = 0; i < nodes.size(); i++) {
            ArrayList ab = (ArrayList) nodes.get(i);
            int distance = calculateDistancePath(ab);
            if (distanceMin > distance) {
                result = 1;
            }
        }
        return result;
    }

    private int calculateDistancePath(ArrayList nodes) {
        int result = 0;
        for (int i = 0; i < nodes.size() - 1; i++) {
            String path = nodes.get(i).toString() + "-" + nodes.get(i + 1).toString();
            if (app.getEdgesNames().indexOf(path) == -1) {
                path = nodes.get(i + 1).toString() + "-" + nodes.get(i).toString();
            }
            Edge ed = graph.getEdge(path);
            int distance = ed.getAttribute("length");
            result += distance;
        }
        return result;
    }

    public ArrayList getRoutes() {
        ArrayList routes = new ArrayList();
        ArrayList initPoints = app.getHospitalsPoints();
        for (Object initPoint : initPoints) {
            Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
            dijkstra.init(graph);
            dijkstra.setSource(graph.getNode(initPoint.toString()));
            dijkstra.compute();
            ArrayList result = new ArrayList();
            for (Node node : dijkstra.getPathNodes(graph.getNode(emergency_depach_list.getModel().getSelectedItem().toString()))) {
                result.add(0, node);
            }
            routes.add(result);
            dijkstra.clear();
        }
        return routes;
    }

    public void renderGraph() {
        ArrayList points = app.getPoints();
        ArrayList<Route> ed = app.getRoutes();
        for (int i = 0; i < points.size(); i++) {
            Node a = graph.addNode(points.get(i).toString());
            a.addAttribute("ui.label", points.get(i).toString());
        }

        for (int i = 0; i < ed.size(); i++) {
            Route act = ed.get(i);
            Edge e = graph.addEdge(act.getInit().toString() + "-" + act.getEnd().toString(), act.getInit().toString(), act.getEnd().toString());
            e.addAttribute("ui.label", act.getDistance() + " km");
            e.setAttribute("length", (int) act.getDistance());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eHospital().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body_menu_graph1;
    private javax.swing.JComboBox<String> center_list_graph;
    private javax.swing.JSpinner create_age_paramedics;
    private javax.swing.JButton create_ambulance_acept;
    private javax.swing.JSpinner create_ambulance_complex;
    private javax.swing.JComboBox<String> create_center_ambulance;
    private javax.swing.JComboBox<String> create_center_paramedics;
    private javax.swing.JButton create_complex_acept;
    private javax.swing.JComboBox<String> create_complex_combobox;
    private javax.swing.JSpinner create_date_ambulance;
    private javax.swing.JTextField create_direction_complex;
    private javax.swing.JTextField create_id_paramedics;
    private javax.swing.JTextField create_name_complex;
    private javax.swing.JTextField create_name_paramedics;
    private javax.swing.JButton create_paramedics_acept;
    private javax.swing.JSpinner create_paramedics_complex;
    private javax.swing.JTextField create_plact_ambulance;
    private javax.swing.JComboBox<String> create_ranking_paramedics;
    private javax.swing.JSpinner create_speed_ambulance;
    private javax.swing.JButton delete_table_ambulance;
    private javax.swing.JButton delete_table_complex;
    private javax.swing.JButton delete_table_paramedics;
    private javax.swing.JTextField distance_km_map;
    private javax.swing.JComboBox<String> emergency_center_list;
    private javax.swing.JComboBox<String> emergency_depach_list;
    private javax.swing.JComboBox<String> emergency_rank_element;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField localization_name_map;
    private javax.swing.JLabel logoSpace;
    private javax.swing.JPanel main_body_graph;
    private javax.swing.JComboBox<String> node_init_end;
    private javax.swing.JComboBox<String> node_init_graph;
    private javax.swing.JButton reassing_ambulance_acept;
    private javax.swing.JComboBox<String> reassing_ambulance_ambulance;
    private javax.swing.JComboBox<String> reassing_center_ambulance;
    private javax.swing.JComboBox<String> reassing_center_paramedics;
    private javax.swing.JComboBox<String> reassing_paramedic_paramedic;
    private javax.swing.JButton reassing_paramedics_acept;
    private javax.swing.JButton show_admin_ambulance;
    private javax.swing.JButton show_admin_hospital;
    private javax.swing.JButton show_admin_maps;
    private javax.swing.JButton show_admin_paramedics;
    private javax.swing.JTable table_ambulance;
    private javax.swing.JTable table_complex;
    private javax.swing.JTable table_paramedics;
    private javax.swing.JDialog window_admin_ambulance;
    private javax.swing.JDialog window_admin_complex;
    private javax.swing.JDialog window_admin_paramedics;
    private javax.swing.JDialog window_map_graph;
    // End of variables declaration//GEN-END:variables
}
