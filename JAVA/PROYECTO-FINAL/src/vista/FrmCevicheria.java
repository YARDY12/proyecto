/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.SalaControlador;
import dao.LoginDao;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.SalaDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelo.DetallePedido;
import modelo.Eventos;
import modelo.ExportarExcel;
import modelo.Pedido;
import modelo.Producto;
import modelo.Sala;
import modelo.Tables;
import modelo.login;

public final class FrmCevicheria extends javax.swing.JFrame {

    private SalaControlador controlador;
    Sala sl = new Sala();
    SalaDAO slDao = new SalaDAO();

    Eventos event = new Eventos();

    Producto pla = new Producto();
    ProductoDAO plaDao = new ProductoDAO();

    Pedido ped = new Pedido();
    PedidoDAO pedDao = new PedidoDAO();
    DetallePedido detPedido = new DetallePedido();

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();

    LoginDao lgDao = new LoginDao();
    int item;
    double Totalpagar = 0.00;

    Date fechaActual = new Date();
    String fechaFormato = new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);

    public FrmCevicheria(login priv) {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        Image igmEscalada = img.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH);
        Icon icono = new ImageIcon(igmEscalada);
        labelLogo.setIcon(icono);
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        txtIdHistorialPedido.setVisible(false);

        if (priv.getRol().equals("Administrador")) {

            LabelVendedor.setText(priv.getNombre());
        } else {
            LabelVendedor.setText(priv.getNombre());
        }

        if (priv.getRol().equals("Mesero")) {
            btnExportar.setEnabled(false);
            btnPestañaEstadoPedido.setEnabled(false);
            btnPestañaRegistroPlatos.setEnabled(false);
            btnExportar.setEnabled(false);
            btnUsuarios4.setEnabled(false);
            btnPestañaSalas.setEnabled(false);
            LabelVendedor.setText(priv.getNombre());
        } else {
            LabelVendedor.setText(priv.getNombre());
        }

        /*if (priv.getRol().equals("Cocinero")) {
            jTabbedPane1.setEnabled(false);
            PanelSalas.setEnabled(false);
            btnPestañaSalas.setEnabled(false);
            btnExportar.setEnabled(false);
            btnExportar2.setEnabled(false);
            btnUsuarios4.setEnabled(false);
            btnPestañaHistorialPedidosVentas.setEnabled(false);
            btnPestañaRegistroPlatos.setEnabled(false);
            labelLogo.setEnabled(false);
            LabelVendedor.setText(priv.getNombre());
        } else {
            LabelVendedor.setText(priv.getNombre());
        }*/
        
        if (priv.getRol().equals("Cocinero")) {
            // Deshabilitar la pestaña y otras funcionalidades
            jTabbedPane1.setEnabled(false);
            jPanel9.setEnabled(false);
            PanelSalas.setEnabled(false);
            btnPestañaSalas.setEnabled(false);
            btnExportar.setEnabled(false);
            btnExportar2.setEnabled(false);
            btnUsuarios4.setEnabled(false);
            btnPestañaHistorialPedidosVentas.setEnabled(false);
            btnPestañaRegistroPlatos.setEnabled(false);
            labelLogo.setEnabled(false); // Deshabilita el componente

            LabelVendedor.setText(priv.getNombre());

            // Eliminar el listener de clic del labelLogo
            for (java.awt.event.MouseListener ml : labelLogo.getMouseListeners()) {
                labelLogo.removeMouseListener(ml);
            }

            // Mostrar directamente la pestaña de estado de pedidos (suponiendo que el índice es 6)
            LimpiarTable();
            ListarDetallesPedido();
            jTabbedPane1.setSelectedIndex(6);
            jPanel1.setEnabled(true);

        } else {
            LabelVendedor.setText(priv.getNombre());
        }



        
        txtIdHistorialPedido.setVisible(false);
        txtIdPedido.setVisible(false);
        txtIdPlato.setVisible(false);
        txtIdSala.setVisible(false);
        txtTempIdSala.setVisible(true);
        txtTempNumMesa.setVisible(true);
        jTabbedPane1.setEnabled(false);
        txtIdEmpleado.setVisible(false);
        txtIdDetalle.setVisible(false);
        txtTempIdSala.setVisible(false);
        txtTempNumMesa.setVisible(false);
        panelSalas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        btnPestañaSalas = new javax.swing.JButton();
        btnPestañaHistorialPedidosVentas = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        btnPestañaRegistroPlatos = new javax.swing.JButton();
        btnPestañaEstadoPedido = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        PanelSalas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSala = new javax.swing.JTable();
        btnActualizarSala = new javax.swing.JButton();
        btnEliminarSala = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtNombreSala = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnRegistrarSala = new javax.swing.JButton();
        btnCancelarSala = new javax.swing.JButton();
        txtIdSala = new javax.swing.JTextField();
        txtMesas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtBuscadorSala = new javax.swing.JTextField();
        btnBuscarSala = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        PanelMesas = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidosEmpleado = new javax.swing.JTextField();
        txtCelularEmpleado = new javax.swing.JTextField();
        txtDNIEmpleado = new javax.swing.JTextField();
        cbxGeneroEmpleado = new javax.swing.JComboBox<>();
        txtDireccionEmpleado = new javax.swing.JTextField();
        btnCancelarEmpleado = new javax.swing.JButton();
        txtIdEmpleado = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnBuscarEmpleado = new javax.swing.JButton();
        btnEditarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        txtBuscadorEmpleados = new javax.swing.JTextField();
        btnExportar3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablePlatos = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioPlato = new javax.swing.JTextField();
        txtDescripcionPlato = new javax.swing.JTextField();
        txtNombrePlato = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbxTipoPlato = new javax.swing.JComboBox<>();
        btnGuardarPlato = new javax.swing.JButton();
        btnCancelarPlato = new javax.swing.JButton();
        txtIdPlato = new javax.swing.JTextField();
        btnEliminarPlato = new javax.swing.JButton();
        btnEditarPlato = new javax.swing.JButton();
        txtBuscadorPlato = new javax.swing.JTextField();
        btnBuscarPlato = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableMenu = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextPane();
        totalMenu = new javax.swing.JLabel();
        btnGenerarPedido = new javax.swing.JButton();
        btnAgregarComentario = new javax.swing.JButton();
        btnEliminarTempPlato = new javax.swing.JButton();
        txtTempIdSala = new javax.swing.JTextField();
        txtTempNumMesa = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtBuscarPlato = new javax.swing.JTextField();
        btnAñadirPlato = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblTemPlatos = new javax.swing.JTable();
        Eliminar = new javax.swing.JButton();
        Restar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnCambiarEstadoDetalle = new javax.swing.JButton();
        txtIdDetalle = new javax.swing.JTextField();
        txtBuscadorConfirmacionPedido = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableConfirmacionPedidos = new javax.swing.JTable();
        btnExportar2 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();
        totalFinalizar = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableFinalizar = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtIdPedido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaHora = new javax.swing.JTextField();
        txtSalaFinalizar = new javax.swing.JTextField();
        txtNumMesaFinalizar = new javax.swing.JTextField();
        txtIdHistorialPedido = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablePedidos = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnUsuarios4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Adminstración");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        labelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogoMouseClicked(evt);
            }
        });

        btnPestañaSalas.setBackground(new java.awt.Color(241, 111, 57));
        btnPestañaSalas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnPestañaSalas.setForeground(new java.awt.Color(255, 255, 255));
        btnPestañaSalas.setText("Salas");
        btnPestañaSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPestañaSalas.setFocusable(false);
        btnPestañaSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaSalasActionPerformed(evt);
            }
        });

        btnPestañaHistorialPedidosVentas.setBackground(new java.awt.Color(241, 111, 57));
        btnPestañaHistorialPedidosVentas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnPestañaHistorialPedidosVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnPestañaHistorialPedidosVentas.setText("Historial de Pedidos");
        btnPestañaHistorialPedidosVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPestañaHistorialPedidosVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPestañaHistorialPedidosVentas.setFocusable(false);
        btnPestañaHistorialPedidosVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaHistorialPedidosVentasActionPerformed(evt);
            }
        });

        LabelVendedor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        LabelVendedor.setForeground(new java.awt.Color(255, 255, 255));
        LabelVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelVendedor.setText("SISTEMA DE PEDIDOS");

        tipo.setForeground(new java.awt.Color(255, 255, 255));

        btnPestañaRegistroPlatos.setBackground(new java.awt.Color(241, 111, 57));
        btnPestañaRegistroPlatos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnPestañaRegistroPlatos.setForeground(new java.awt.Color(255, 255, 255));
        btnPestañaRegistroPlatos.setText("Registro de Platos");
        btnPestañaRegistroPlatos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPestañaRegistroPlatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPestañaRegistroPlatos.setFocusable(false);
        btnPestañaRegistroPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaRegistroPlatosActionPerformed(evt);
            }
        });

        btnPestañaEstadoPedido.setBackground(new java.awt.Color(241, 111, 57));
        btnPestañaEstadoPedido.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnPestañaEstadoPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnPestañaEstadoPedido.setText("Estado de Pedidos");
        btnPestañaEstadoPedido.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPestañaEstadoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPestañaEstadoPedido.setFocusable(false);
        btnPestañaEstadoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaEstadoPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPestañaSalas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPestañaRegistroPlatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(LabelVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipo)
                .addContainerGap())
            .addComponent(btnPestañaHistorialPedidosVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPestañaEstadoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(tipo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(labelLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelVendedor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(btnPestañaRegistroPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPestañaSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPestañaHistorialPedidosVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPestañaEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 840));

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 0, 0));
        jLabel38.setText("CEVICHERIA \"DON CANGREJO\"");
        jLabel38.setFocusable(false);
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 660, 50));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        PanelSalas.setBackground(new java.awt.Color(239, 254, 255));
        PanelSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelSalasMouseClicked(evt);
            }
        });
        PanelSalas.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane8.setViewportView(PanelSalas);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1304, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Principal", jPanel9);

        jPanel4.setBackground(new java.awt.Color(239, 254, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "MESAS"
            }
        ));
        tableSala.setRowHeight(23);
        tableSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSalaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSala);
        if (tableSala.getColumnModel().getColumnCount() > 0) {
            tableSala.getColumnModel().getColumn(0).setMinWidth(80);
            tableSala.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableSala.getColumnModel().getColumn(0).setMaxWidth(130);
            tableSala.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableSala.getColumnModel().getColumn(2).setMinWidth(80);
            tableSala.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableSala.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 1260, 430));

        btnActualizarSala.setBackground(new java.awt.Color(241, 111, 57));
        btnActualizarSala.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnActualizarSala.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boligrafo.png"))); // NOI18N
        btnActualizarSala.setText("Editar");
        btnActualizarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarSalaActionPerformed(evt);
            }
        });
        jPanel4.add(btnActualizarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 130, 30));

        btnEliminarSala.setBackground(new java.awt.Color(241, 111, 57));
        btnEliminarSala.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnEliminarSala.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarSala.setText("Eliminar");
        btnEliminarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSalaActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 210, 140, 30));

        jLabel43.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 0, 0));
        jLabel43.setText("Registro de Salas");
        jLabel43.setFocusable(false);
        jLabel43.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 400, 50));

        jPanel7.setBackground(new java.awt.Color(241, 225, 219));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel18.setText("Nombre:");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        txtNombreSala.setBorder(null);
        jPanel7.add(txtNombreSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 190, 30));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel19.setText("Numero de Mesas:");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        btnRegistrarSala.setBackground(new java.awt.Color(241, 111, 57));
        btnRegistrarSala.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnRegistrarSala.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir (2).png"))); // NOI18N
        btnRegistrarSala.setText("Registrar");
        btnRegistrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSalaActionPerformed(evt);
            }
        });
        jPanel7.add(btnRegistrarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 140, -1));

        btnCancelarSala.setBackground(new java.awt.Color(241, 111, 57));
        btnCancelarSala.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnCancelarSala.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarSala.setText("Cancelar");
        btnCancelarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSalaActionPerformed(evt);
            }
        });
        jPanel7.add(btnCancelarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 110, 130, 30));

        txtIdSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdSalaActionPerformed(evt);
            }
        });
        jPanel7.add(txtIdSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 60, 30));

        txtMesas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel7.add(txtMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 190, 30));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1260, 150));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-buscar-30.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        txtBuscadorSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorSalaActionPerformed(evt);
            }
        });
        jPanel4.add(txtBuscadorSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 590, 30));

        btnBuscarSala.setBackground(new java.awt.Color(241, 111, 57));
        btnBuscarSala.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnBuscarSala.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarSala.setText("Buscar");
        btnBuscarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSalaActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 120, 30));

        jTabbedPane1.addTab("Salas", jPanel4);

        PanelMesas.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane9.setViewportView(PanelMesas);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mesas", jPanel22);

        jPanel12.setBackground(new java.awt.Color(239, 254, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Correo", "Contraseña", "Rol", "Celular", "DNI", "Genero", "Direccion"
            }
        ));
        TableUsuarios.setRowHeight(23);
        TableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TableUsuarios);
        if (TableUsuarios.getColumnModel().getColumnCount() > 0) {
            TableUsuarios.getColumnModel().getColumn(0).setMinWidth(50);
            TableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableUsuarios.getColumnModel().getColumn(0).setMaxWidth(80);
            TableUsuarios.getColumnModel().getColumn(3).setMinWidth(150);
            TableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(150);
            TableUsuarios.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 1250, 410));

        jPanel5.setBackground(new java.awt.Color(241, 225, 219));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel35.setText("Contraseña:");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 70, -1));

        txtCorreo.setBorder(null);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel5.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 240, 20));

        txtPass.setBorder(null);
        jPanel5.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 240, 20));

        btnIniciar.setBackground(new java.awt.Color(241, 111, 57));
        btnIniciar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir (2).png"))); // NOI18N
        btnIniciar.setText("Registrar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel5.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 150, 40));

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel36.setText("Correo:");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel37.setText("Rol:");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Mesero", "Cocinero" }));
        cbxRol.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.add(cbxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 160, 20));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel12.setText("Apellidos:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, 20));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel13.setText("Direccion:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel14.setText("Genero:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel15.setText("Celular:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel20.setText("DNI:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel5.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 240, -1));

        txtApellidosEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.add(txtApellidosEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 240, 20));

        txtCelularEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.add(txtCelularEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 240, 20));

        txtDNIEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.add(txtDNIEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 240, 20));

        cbxGeneroEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino" }));
        cbxGeneroEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.add(cbxGeneroEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 160, -1));

        txtDireccionEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.add(txtDireccionEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 240, 20));

        btnCancelarEmpleado.setBackground(new java.awt.Color(241, 111, 57));
        btnCancelarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarEmpleado.setText("Cancelar");
        btnCancelarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEmpleadoActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 120, 30));

        txtIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoActionPerformed(evt);
            }
        });
        jPanel5.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 70, 30));

        jPanel12.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1260, 170));

        jLabel41.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 0, 0));
        jLabel41.setText("Registro de Empleados");
        jLabel41.setFocusable(false);
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 400, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-buscar-30.png"))); // NOI18N
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 30, 30));

        btnBuscarEmpleado.setBackground(new java.awt.Color(241, 111, 57));
        btnBuscarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarEmpleado.setText("Buscar");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });
        jPanel12.add(btnBuscarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 90, 30));

        btnEditarEmpleado.setBackground(new java.awt.Color(241, 111, 57));
        btnEditarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boligrafo.png"))); // NOI18N
        btnEditarEmpleado.setText("Editar");
        btnEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpleadoActionPerformed(evt);
            }
        });
        jPanel12.add(btnEditarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 240, 130, 30));

        btnEliminarEmpleado.setBackground(new java.awt.Color(241, 111, 57));
        btnEliminarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });
        jPanel12.add(btnEliminarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 240, 130, 30));
        jPanel12.add(txtBuscadorEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 650, 30));

        btnExportar3.setBackground(new java.awt.Color(241, 111, 57));
        btnExportar3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnExportar3.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar3.setText("Exportar");
        btnExportar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExportar3.setFocusable(false);
        btnExportar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportar3ActionPerformed(evt);
            }
        });
        jPanel12.add(btnExportar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 120, 30));

        jTabbedPane1.addTab("Usuarios", jPanel12);

        jPanel2.setBackground(new java.awt.Color(239, 254, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablePlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Tipo", "Precio", "Descripcion"
            }
        ));
        TablePlatos.setRowHeight(23);
        TablePlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePlatosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablePlatos);
        if (TablePlatos.getColumnModel().getColumnCount() > 0) {
            TablePlatos.getColumnModel().getColumn(0).setMinWidth(100);
            TablePlatos.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablePlatos.getColumnModel().getColumn(0).setMaxWidth(150);
            TablePlatos.getColumnModel().getColumn(2).setMinWidth(200);
            TablePlatos.getColumnModel().getColumn(2).setPreferredWidth(200);
            TablePlatos.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 1260, 410));

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 0, 0));
        jLabel40.setText("Registro de Platos");
        jLabel40.setFocusable(false);
        jLabel40.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 270, 50));

        jPanel3.setBackground(new java.awt.Color(241, 225, 219));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Tipo:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        txtPrecioPlato.setBorder(null);
        txtPrecioPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioPlatoKeyTyped(evt);
            }
        });
        jPanel3.add(txtPrecioPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 130, 20));

        txtDescripcionPlato.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(txtDescripcionPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 290, 70));

        txtNombrePlato.setBorder(null);
        jPanel3.add(txtNombrePlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 220, 20));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel23.setText("Nombre:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel25.setText("Precio:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        cbxTipoPlato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Personal", "Familiar" }));
        cbxTipoPlato.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbxTipoPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoPlatoActionPerformed(evt);
            }
        });
        jPanel3.add(cbxTipoPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 130, -1));

        btnGuardarPlato.setBackground(new java.awt.Color(241, 111, 57));
        btnGuardarPlato.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnGuardarPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir (2).png"))); // NOI18N
        btnGuardarPlato.setText("Guardar");
        btnGuardarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPlatoActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 170, 40));

        btnCancelarPlato.setBackground(new java.awt.Color(241, 111, 57));
        btnCancelarPlato.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnCancelarPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarPlato.setText("Cancelar");
        btnCancelarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPlatoActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 90, 120, 30));

        txtIdPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPlatoActionPerformed(evt);
            }
        });
        jPanel3.add(txtIdPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 80, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1260, 130));

        btnEliminarPlato.setBackground(new java.awt.Color(241, 111, 57));
        btnEliminarPlato.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnEliminarPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarPlato.setText("Eliminar");
        btnEliminarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPlatoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 210, 120, 30));

        btnEditarPlato.setBackground(new java.awt.Color(241, 111, 57));
        btnEditarPlato.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnEditarPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boligrafo.png"))); // NOI18N
        btnEditarPlato.setText("Editar");
        btnEditarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPlatoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 210, 130, 30));
        jPanel2.add(txtBuscadorPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 640, 30));

        btnBuscarPlato.setBackground(new java.awt.Color(241, 111, 57));
        btnBuscarPlato.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnBuscarPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPlato.setText("Buscar");
        btnBuscarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPlatoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 100, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-buscar-30.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jTabbedPane1.addTab("Platos", jPanel2);

        jPanel23.setBackground(new java.awt.Color(239, 254, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plato", "Tipo", "Cantidad", "Precio", "SubTotal", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenu.setRowHeight(23);
        jScrollPane11.setViewportView(tableMenu);
        if (tableMenu.getColumnModel().getColumnCount() > 0) {
            tableMenu.getColumnModel().getColumn(0).setMinWidth(30);
            tableMenu.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableMenu.getColumnModel().getColumn(0).setMaxWidth(50);
            tableMenu.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableMenu.getColumnModel().getColumn(2).setMinWidth(40);
            tableMenu.getColumnModel().getColumn(2).setPreferredWidth(40);
            tableMenu.getColumnModel().getColumn(2).setMaxWidth(50);
            tableMenu.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableMenu.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        jPanel23.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 700, 250));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Comentario:");
        jPanel23.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 180, -1));

        jScrollPane12.setViewportView(txtComentario);

        jPanel23.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 700, 80));

        totalMenu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        totalMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalMenu.setText("00.00");
        jPanel23.add(totalMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 80, 20));

        btnGenerarPedido.setBackground(new java.awt.Color(241, 111, 57));
        btnGenerarPedido.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnGenerarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPedido.setText("Realizar Pedido");
        btnGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPedidoActionPerformed(evt);
            }
        });
        jPanel23.add(btnGenerarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 580, 280, 50));

        btnAgregarComentario.setBackground(new java.awt.Color(241, 111, 57));
        btnAgregarComentario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnAgregarComentario.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarComentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir (2).png"))); // NOI18N
        btnAgregarComentario.setText("Agregar");
        btnAgregarComentario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregarComentario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComentarioActionPerformed(evt);
            }
        });
        jPanel23.add(btnAgregarComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 150, 30));

        btnEliminarTempPlato.setBackground(new java.awt.Color(241, 111, 57));
        btnEliminarTempPlato.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnEliminarTempPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTempPlato.setText("Cancelar");
        btnEliminarTempPlato.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEliminarTempPlato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarTempPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTempPlatoActionPerformed(evt);
            }
        });
        jPanel23.add(btnEliminarTempPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 490, 140, 30));
        jPanel23.add(txtTempIdSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 70, 30));
        jPanel23.add(txtTempNumMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 70, 30));

        jLabel45.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 0, 0));
        jLabel45.setText("Registro de Pedidos");
        jLabel45.setFocusable(false);
        jLabel45.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel23.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 340, 40));

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 0, 0));
        jLabel46.setText("TOTAL PAGO:");
        jLabel46.setFocusable(false);
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel23.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, -1, 50));

        jPanel8.setBackground(new java.awt.Color(241, 225, 219));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-buscar-30.png"))); // NOI18N
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtBuscarPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPlatoKeyReleased(evt);
            }
        });
        jPanel8.add(txtBuscarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 320, 30));

        btnAñadirPlato.setBackground(new java.awt.Color(241, 111, 57));
        btnAñadirPlato.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnAñadirPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir (2).png"))); // NOI18N
        btnAñadirPlato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadirPlato.setFocusable(false);
        btnAñadirPlato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAñadirPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirPlatoActionPerformed(evt);
            }
        });
        jPanel8.add(btnAñadirPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, 32));

        tblTemPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Tipo", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTemPlatos.setRowHeight(23);
        jScrollPane10.setViewportView(tblTemPlatos);
        if (tblTemPlatos.getColumnModel().getColumnCount() > 0) {
            tblTemPlatos.getColumnModel().getColumn(0).setMinWidth(30);
            tblTemPlatos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblTemPlatos.getColumnModel().getColumn(0).setMaxWidth(50);
            tblTemPlatos.getColumnModel().getColumn(2).setMinWidth(150);
            tblTemPlatos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblTemPlatos.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel8.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 500, 530));

        jPanel23.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 530, 600));

        Eliminar.setBackground(new java.awt.Color(241, 111, 57));
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        Eliminar.setText("Eliminar pedido");
        Eliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel23.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 340, 150, 30));

        Restar.setBackground(new java.awt.Color(241, 111, 57));
        Restar.setForeground(new java.awt.Color(255, 255, 255));
        Restar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-menos.png"))); // NOI18N
        Restar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestarActionPerformed(evt);
            }
        });
        jPanel23.add(Restar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 40, 30));

        jTabbedPane1.addTab("Registro Pedido", jPanel23);

        jPanel11.setBackground(new java.awt.Color(239, 254, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(204, 0, 0));
        jLabel48.setText("Estado de Pedidos");
        jLabel48.setFocusable(false);
        jLabel48.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel11.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 410, 40));

        jPanel13.setBackground(new java.awt.Color(241, 225, 219));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel11.setText("Cambiar estado:");
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 160, -1));

        btnCambiarEstadoDetalle.setBackground(new java.awt.Color(241, 111, 57));
        btnCambiarEstadoDetalle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCambiarEstadoDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarEstadoDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir (2).png"))); // NOI18N
        btnCambiarEstadoDetalle.setText("Marca pedido como realizado");
        btnCambiarEstadoDetalle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCambiarEstadoDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoDetalleActionPerformed(evt);
            }
        });
        jPanel13.add(btnCambiarEstadoDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 260, 30));
        jPanel13.add(txtIdDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 100, -1));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 1250, 80));

        txtBuscadorConfirmacionPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBuscadorConfirmacionPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscadorConfirmacionPedidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorConfirmacionPedidoKeyReleased(evt);
            }
        });
        jPanel11.add(txtBuscadorConfirmacionPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 640, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-buscar-30.png"))); // NOI18N
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        tableConfirmacionPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plato", "Tipo", "Cantidad", "Precio", "Comentario", "ID Pedido", "Estado"
            }
        ));
        tableConfirmacionPedidos.setRowHeight(23);
        tableConfirmacionPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableConfirmacionPedidosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableConfirmacionPedidos);
        if (tableConfirmacionPedidos.getColumnModel().getColumnCount() > 0) {
            tableConfirmacionPedidos.getColumnModel().getColumn(0).setMinWidth(80);
            tableConfirmacionPedidos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableConfirmacionPedidos.getColumnModel().getColumn(0).setMaxWidth(130);
            tableConfirmacionPedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableConfirmacionPedidos.getColumnModel().getColumn(2).setMinWidth(80);
            tableConfirmacionPedidos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableConfirmacionPedidos.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jPanel11.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 1250, 460));

        btnExportar2.setBackground(new java.awt.Color(241, 111, 57));
        btnExportar2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnExportar2.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar2.setText("Exportar");
        btnExportar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExportar2.setFocusable(false);
        btnExportar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportar2ActionPerformed(evt);
            }
        });
        jPanel11.add(btnExportar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 170, 120, 30));

        jTabbedPane1.addTab("Estado de Pedidos", jPanel11);

        jPanel25.setBackground(new java.awt.Color(239, 254, 255));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFinalizar.setBackground(new java.awt.Color(241, 111, 57));
        btnFinalizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        jPanel25.add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, 260, 40));

        totalFinalizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        totalFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalFinalizar.setText("00.00");
        jPanel25.add(totalFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, 120, -1));

        tableFinalizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plato", "Tipo", "Cantidad", "Precio", "SubTotal", "Comentario", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFinalizar.setRowHeight(23);
        jScrollPane13.setViewportView(tableFinalizar);

        jPanel25.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1260, 300));

        jLabel49.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(204, 0, 0));
        jLabel49.setText("TOTAL PAGO:");
        jLabel49.setFocusable(false);
        jLabel49.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel25.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 150, 50));

        jPanel10.setBackground(new java.awt.Color(241, 225, 219));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(txtIdPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 40, 60, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel7.setText("Fecha y Hora:");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 140, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel8.setText("Sala:");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 70, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel9.setText("N° Mesa:");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 100, 30));

        txtFechaHora.setEditable(false);
        txtFechaHora.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaHora.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtFechaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaHoraActionPerformed(evt);
            }
        });
        jPanel10.add(txtFechaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 200, 30));

        txtSalaFinalizar.setEditable(false);
        txtSalaFinalizar.setBackground(new java.awt.Color(255, 255, 255));
        txtSalaFinalizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel10.add(txtSalaFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 130, 30));

        txtNumMesaFinalizar.setEditable(false);
        txtNumMesaFinalizar.setBackground(new java.awt.Color(255, 255, 255));
        txtNumMesaFinalizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel10.add(txtNumMesaFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 110, 30));
        jPanel10.add(txtIdHistorialPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 40, 60, 30));

        jPanel25.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 1260, 110));

        jLabel50.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(204, 0, 0));
        jLabel50.setText("Finalizar pedido");
        jLabel50.setFocusable(false);
        jLabel50.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel25.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 400, 50));

        jTabbedPane1.addTab("Finalizar Pedido", jPanel25);

        jPanel6.setBackground(new java.awt.Color(239, 254, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sala", "Atendido", "N° Mesa", "Fecha", "Total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TablePedidos.setRowHeight(23);
        TablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePedidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablePedidosMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(TablePedidos);
        if (TablePedidos.getColumnModel().getColumnCount() > 0) {
            TablePedidos.getColumnModel().getColumn(0).setMinWidth(80);
            TablePedidos.getColumnModel().getColumn(0).setPreferredWidth(80);
            TablePedidos.getColumnModel().getColumn(0).setMaxWidth(120);
            TablePedidos.getColumnModel().getColumn(2).setPreferredWidth(60);
            TablePedidos.getColumnModel().getColumn(3).setMinWidth(100);
            TablePedidos.getColumnModel().getColumn(3).setPreferredWidth(100);
            TablePedidos.getColumnModel().getColumn(3).setMaxWidth(150);
            TablePedidos.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1250, 600));

        jLabel42.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 0, 0));
        jLabel42.setText("Historial de Pedidos");
        jLabel42.setFocusable(false);
        jLabel42.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 310, 50));

        btnExportar.setBackground(new java.awt.Color(241, 111, 57));
        btnExportar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setText("Exportar");
        btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExportar.setFocusable(false);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jPanel6.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 40, 120, 30));

        jTabbedPane1.addTab("Historial Pedidos", jPanel6);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 1310, 740));

        btnSalir.setBackground(new java.awt.Color(241, 111, 57));
        btnSalir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir_1.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 20, 140, 50));

        btnUsuarios4.setBackground(new java.awt.Color(241, 111, 57));
        btnUsuarios4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnUsuarios4.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarios.png"))); // NOI18N
        btnUsuarios4.setText("Usuarios");
        btnUsuarios4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuarios4.setFocusable(false);
        btnUsuarios4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarios4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 20, 150, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPestañaSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaSalasActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarSalas();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnPestañaSalasActionPerformed

    private void btnPestañaHistorialPedidosVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaHistorialPedidosVentasActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarPedidos();
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnPestañaHistorialPedidosVentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        // Mostrar un cuadro de confirmación preguntando si desea salir
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí" (JOptionPane.YES_OPTION), salir del programa
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void labelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogoMouseClicked
        jTabbedPane1.setSelectedIndex(0);
        PanelSalas.removeAll();
        panelSalas();
    }//GEN-LAST:event_labelLogoMouseClicked

    private void btnPestañaRegistroPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaRegistroPlatosActionPerformed
        LimpiarTable();
        ListarPlatos(TablePlatos);
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnPestañaRegistroPlatosActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(TablePedidos);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnAñadirPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirPlatoActionPerformed
        // Verificar si se ha seleccionado una fila en la tabla de platos
        if (tblTemPlatos.getSelectedRow() >= 0) {
            int id = Integer.parseInt(tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 0).toString());
            String nom_producto = tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 1).toString();
            String tipoPlato = tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 2).toString();
            //double precio = Double.parseDouble(tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 3).toString());
            double precio = Double.parseDouble(tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 3).toString());
            int cantidadInicial = 1; // Cantidad inicial
            double subtotal = cantidadInicial * precio;

            item = item + 1; // Incrementa el contador de ítems

            tmp = (DefaultTableModel) tableMenu.getModel();

            // Comprobar si el plato ya existe
            for (int i = 0; i < tableMenu.getRowCount(); i++) {
                if (tableMenu.getValueAt(i, 0).equals(id)) {
                    int cantActual = Integer.parseInt(tableMenu.getValueAt(i, 3).toString());
                    int nuevoCantidad = cantActual + 1;
                    double nuevoSub = precio * nuevoCantidad;
                    tmp.setValueAt(nuevoCantidad, i, 3); // Actualiza cantidad
                    tmp.setValueAt(nuevoSub, i, 5);     // Actualiza subtotal (columna 5)
                    TotalPagar(tableMenu, totalMenu);   // Actualiza el total
                    return;
                }
            }

            // Si no existe, añadir el plato
            Object[] fila = {
                id, // ID del plato
                nom_producto, // Nombre del plato
                tipoPlato, // Tipo de plato
                cantidadInicial, // Cantidad inicial
                precio, // Precio unitario
                subtotal // Subtotal (columna 5)
            };

            tmp.addRow(fila); // Añade la fila
            tableMenu.setModel(tmp); // Refresca el modelo de la tabla

            TotalPagar(tableMenu, totalMenu); // Calcula el total después de añadir
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA UNA FILA");
        }
    }//GEN-LAST:event_btnAñadirPlatoActionPerformed

    private void txtBuscarPlatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPlatoKeyReleased
        //Para buscar
        LimpiarTable();
        ListarPlatos(tblTemPlatos);
    }//GEN-LAST:event_txtBuscarPlatoKeyReleased

    private void btnEliminarTempPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTempPlatoActionPerformed
        txtComentario.setText("");
    }//GEN-LAST:event_btnEliminarTempPlatoActionPerformed

    private void btnAgregarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComentarioActionPerformed
        // Verificar que se haya ingresado un comentario
        if (txtComentario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un comentario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si no se ingresa un comentario
        }

        // Verificar si se ha seleccionado una fila en la tabla
        int selectedRow = tableMenu.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si no hay fila seleccionada
        }

        try {
            // Obtener el ID de la fila seleccionada
            int id = Integer.parseInt(tableMenu.getValueAt(selectedRow, 0).toString());

            // Recorrer la tabla para buscar la fila con el ID correspondiente
            for (int i = 0; i < tableMenu.getRowCount(); i++) {
                if (Integer.parseInt(tableMenu.getValueAt(i, 0).toString()) == id) {
                    // Actualizar el comentario en la columna correspondiente
                    tableMenu.setValueAt(txtComentario.getText().trim(), i, 6);

                    // Limpiar el campo de texto y la selección de la tabla
                    txtComentario.setText("");
                    tableMenu.clearSelection();

                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(null, "Comentario agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    return; // Salir del método después de actualizar
                }
            }

            // Mostrar mensaje si no se encuentra el ID en la tabla
            JOptionPane.showMessageDialog(null, "El ID seleccionado no coincide con ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException e) {
            // Manejar errores al convertir valores a enteros
            JOptionPane.showMessageDialog(null, "Error al procesar el ID de la fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Manejar cualquier otro error inesperado
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarComentarioActionPerformed

    private void btnGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPedidoActionPerformed
        // No pasa nada
        if (tableMenu.getRowCount() > 0) {
            RegistrarPedido();
            detallePedido();
            LimpiarTableMenu();
            JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO");
            jTabbedPane1.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY PRODUCTO EN LA PEDIDO");
        }
    }//GEN-LAST:event_btnGenerarPedidoActionPerformed

    private void cbxTipoPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoPlatoActionPerformed

    private void txtPrecioPlatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPlatoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioPlatoKeyTyped

    private void TablePlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePlatosMouseClicked
        // TODO add your handling code here:
        int fila = TablePlatos.rowAtPoint(evt.getPoint());

        // Establece los valores de los otros campos de texto
        txtIdPlato.setText(TablePlatos.getValueAt(fila, 0).toString());
        txtNombrePlato.setText(TablePlatos.getValueAt(fila, 1).toString());

        // Establece el valor seleccionado del ComboBox
        String tipoPlato = TablePlatos.getValueAt(fila, 2).toString(); // Obtén el valor de la columna del tipo de plato
        cbxTipoPlato.setSelectedItem(tipoPlato); // Establece el valor en el ComboBox

        txtPrecioPlato.setText(TablePlatos.getValueAt(fila, 3).toString());
        txtDescripcionPlato.setText(TablePlatos.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_TablePlatosMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        // Validar que los campos obligatorios no estén vacíos
        if (txtNombre.getText().equals("") || txtApellidosEmpleado.getText().equals("")
                || txtCorreo.getText().equals("") || txtCelularEmpleado.getText().equals("")
                || txtDNIEmpleado.getText().equals("") || txtDireccionEmpleado.getText().equals("")
                || txtPass.getPassword().length == 0) {

            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
        } else {
            // Crear una instancia del modelo `login`
            login lg = new login();

            // Asignar los valores de los TextField y ComboBox a los atributos del objeto
            lg.setNombre(txtNombre.getText());
            lg.setApellido(txtApellidosEmpleado.getText());
            lg.setCorreo(txtCorreo.getText());
            lg.setCelular(Integer.parseInt(txtCelularEmpleado.getText()));
            lg.setDni(Integer.parseInt(txtDNIEmpleado.getText()));
            lg.setGenero(cbxGeneroEmpleado.getSelectedItem().toString());
            lg.setDireccion(txtDireccionEmpleado.getText());
            lg.setPass(String.valueOf(txtPass.getPassword()));
            lg.setRol(cbxRol.getSelectedItem().toString());

            // Llamar al método `Registrar` de la clase DAO
            boolean registrado = lgDao.Registrar(lg);

            // Validar si el registro fue exitoso
            if (registrado) {
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                LimpiarUsuario();
                LimpiarTable();
                ListarUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario");
            }
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void TablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePedidosMouseClicked
        // TODO add your handling code here:
        int fila = TablePedidos.rowAtPoint(evt.getPoint());
        int id_pedido = Integer.parseInt(TablePedidos.getValueAt(fila, 0).toString());
        LimpiarTable();
        verPedido(id_pedido);
        verPedidoDetalle(id_pedido);
        jTabbedPane1.setSelectedIndex(7);
        btnFinalizar.setEnabled(false);
        txtIdHistorialPedido.setText("" + id_pedido);
    }//GEN-LAST:event_TablePedidosMouseClicked

    private void txtBuscadorSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorSalaActionPerformed

    private void btnCancelarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSalaActionPerformed
        // TODO add your handling code here:
        LimpiarSala();

    }//GEN-LAST:event_btnCancelarSalaActionPerformed

    private void btnRegistrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSalaActionPerformed
        // TODO add your handling code here:
        if (txtNombreSala.getText().equals("") || txtMesas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Los campos esta vacios");
        } else {
            sl.setNombre(txtNombreSala.getText());
            sl.setMesa(Integer.parseInt(txtMesas.getText()));
            slDao.registrarSala(sl);
            JOptionPane.showMessageDialog(null, "Sala Registrado");
            LimpiarSala();
            LimpiarTable();
            ListarSalas();
        }

    }//GEN-LAST:event_btnRegistrarSalaActionPerformed

    private void btnEliminarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSalaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (!"".equals(txtIdSala.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdSala.getText());
                slDao.eliminarSala(id);
                LimpiarSala();
                LimpiarTable();
                ListarSalas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnEliminarSalaActionPerformed

    private void btnActualizarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarSalaActionPerformed
        // TODO add your handling code here:
        // Validar si se seleccionó una fila
        if ("".equals(txtIdSala.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            // Validar si el nombre de la sala no está vacío
            if (!"".equals(txtNombreSala.getText()) && !"".equals(txtMesas.getText())) {
                // Mostrar ventana de confirmación
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea actualizar esta sala?",
                        "Confirmación de Actualización",
                        JOptionPane.YES_NO_OPTION);

                // Si el usuario selecciona 'Sí'
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        // Asignar valores al objeto Sala
                        sl.setId_sala(Integer.parseInt(txtIdSala.getText()));
                        sl.setNombre(txtNombreSala.getText());
                        sl.setMesa(Integer.parseInt(txtMesas.getText())); // Asegúrate de convertir el texto a un entero

                        // Llamar al DAO para actualizar la sala
                        if (slDao.modificarSala(sl)) {
                            JOptionPane.showMessageDialog(null, "Sala modificada correctamente");
                            LimpiarSala();
                            LimpiarTable();
                            ListarSalas();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al modificar la sala");
                        }
                    } catch (NumberFormatException e) {
                        // Capturar posibles errores de conversión de texto a entero
                        JOptionPane.showMessageDialog(null, "El campo 'Mesas' debe ser un número válido");
                    }
                } else {
                    // Si el usuario selecciona 'No', no se hace nada
                    JOptionPane.showMessageDialog(null, "Actualización cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
        }
    }//GEN-LAST:event_btnActualizarSalaActionPerformed

    private void tableSalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSalaMouseClicked
        int fila = tableSala.rowAtPoint(evt.getPoint());
        txtIdSala.setText(tableSala.getValueAt(fila, 0).toString());
        txtNombreSala.setText(tableSala.getValueAt(fila, 1).toString());
        txtMesas.setText(tableSala.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_tableSalaMouseClicked

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        // Obtiene el ID del pedido desde el campo de texto
        int idPedido = Integer.parseInt(txtIdPedido.getText().trim());

        // Crea una instancia de tu DAO para poder llamar a los métodos
        //PedidoDAO pedDao = new PedidoDAO();
        // Verifica si todos los detalles del pedido están en "REALIZADO"
        if (pedDao.verificarDetallesRealizados(idPedido)) {
            // Si todos los detalles están realizados, pregunta si se desea finalizar
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de finalizar el pedido?");
            if (pregunta == 0) {
                // Si la respuesta es afirmativa, actualiza el estado del pedido
                if (pedDao.actualizarEstado(idPedido)) {
                    // Si el estado se actualizó correctamente, genera el PDF

                    JOptionPane.showMessageDialog(null, "Pedido finalizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al finalizar el pedido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Si no todos los detalles están en "REALIZADO", muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "No se puede finalizar el pedido. Todos los detalles deben estar en estado 'REALIZADO'", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtIdPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPlatoActionPerformed

    private void btnGuardarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPlatoActionPerformed
        // TODO add your handling code here:
        // Validar que los campos no estén vacíos
        if (!"".equals(txtNombrePlato.getText()) && !"".equals(txtPrecioPlato.getText()) && !"".equals(txtDescripcionPlato.getText())) {
            try {
                Producto producto = new Producto();
                producto.setNom_producto(txtNombrePlato.getText());
                producto.setPrecio(Double.parseDouble(txtPrecioPlato.getText()));
                producto.setDescripcion(txtDescripcionPlato.getText());
                producto.setTipoPlato(cbxTipoPlato.getSelectedItem().toString());

                ProductoDAO productoDAO = new ProductoDAO();
                if (productoDAO.registrar(producto)) {
                    JOptionPane.showMessageDialog(null, "Plato registrado correctamente");
                    LimpiarTable();
                    ListarPlatos(TablePlatos); // Método para actualizar la tabla de platos
                    LimpiarPlatos(); // Método para limpiar los campos del formulario
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el plato");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
        }
    }//GEN-LAST:event_btnGuardarPlatoActionPerformed

    private void btnEditarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPlatoActionPerformed
        // Verificar si el ID está vacío
        if ("".equals(txtIdPlato.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para editar");
        } else {
            // Validar que los campos obligatorios no estén vacíos
            if (!"".equals(txtNombrePlato.getText()) && !"".equals(txtPrecioPlato.getText()) && !"".equals(txtDescripcionPlato.getText())) {

                // Mostrar ventana de confirmación
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea editar este plato?",
                        "Confirmación de Edición",
                        JOptionPane.YES_NO_OPTION);

                // Si el usuario selecciona 'Sí'
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        Producto producto = new Producto();
                        producto.setId_producto(Integer.parseInt(txtIdPlato.getText()));
                        producto.setNom_producto(txtNombrePlato.getText());
                        producto.setPrecio(Double.parseDouble(txtPrecioPlato.getText()));
                        producto.setDescripcion(txtDescripcionPlato.getText());
                        producto.setTipoPlato(cbxTipoPlato.getSelectedItem().toString());

                        ProductoDAO productoDAO = new ProductoDAO();
                        if (productoDAO.modificar(producto)) {
                            JOptionPane.showMessageDialog(null, "Plato modificado correctamente");
                            LimpiarTable();
                            ListarPlatos(TablePlatos); // Método para actualizar la tabla
                            LimpiarPlatos(); // Método para limpiar los campos del formulario
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al modificar el plato");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El precio debe ser un número válido");
                    }
                } else {
                    // Si el usuario selecciona 'No', no se hace nada
                    JOptionPane.showMessageDialog(null, "Edición cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
            }
        }
    }//GEN-LAST:event_btnEditarPlatoActionPerformed

    private void btnEliminarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPlatoActionPerformed
        // TODO add your handling code here:
        // Verificar si el ID está vacío
        if (!"".equals(txtIdPlato.getText())) {
            // Confirmar si el usuario desea eliminar el registro
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este plato?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(txtIdPlato.getText()); // Convertir el ID a entero
                    ProductoDAO productoDAO = new ProductoDAO();
                    if (productoDAO.eliminar(id)) {
                        JOptionPane.showMessageDialog(null, "Plato eliminado correctamente");
                        LimpiarPlatos(); // Método para limpiar los campos del formulario
                        LimpiarTable(); // Método para limpiar la tabla
                        ListarPlatos(TablePlatos); // Método para actualizar la tabla con los datos actuales
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el plato");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número válido");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarPlatoActionPerformed

    private void txtIdSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdSalaActionPerformed

    private void btnBuscarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSalaActionPerformed
        // TODO add your handling code here:
        // Obtener el texto del campo de búsqueda
        String busqueda = txtBuscadorSala.getText().trim();

        // Verificar si el campo está vacío
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la sala que desea buscar");
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tableSala.getModel();
        // Limpiar la tabla antes de mostrar resultados
        modelo.setRowCount(0);

        // Consultar la base de datos para buscar las salas
        List<Sala> salas = slDao.listarSalas(); // Recuperar todas las salas
        boolean encontrado = false;

        for (Sala sala : salas) {
            if (sala.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                // Agregar la sala encontrada a la tabla
                modelo.addRow(new Object[]{
                    sala.getId_sala(),
                    sala.getNombre(),
                    sala.getMesa()
                });
                encontrado = true;
            }
        }

        // Mostrar mensaje si no se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron salas que coincidan con la búsqueda");
        }
    }//GEN-LAST:event_btnBuscarSalaActionPerformed

    private void btnPestañaEstadoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaEstadoPedidoActionPerformed
        // TODO add your handling code here:

        LimpiarTable();
        ListarDetallesPedido();
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnPestañaEstadoPedidoActionPerformed

    private void tableConfirmacionPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableConfirmacionPedidosMouseClicked
        // TODO add your handling code here:

        int fila = tableConfirmacionPedidos.rowAtPoint(evt.getPoint());
        int id_detalle = Integer.parseInt(tableConfirmacionPedidos.getValueAt(fila, 0).toString());

        jTabbedPane1.setSelectedIndex(6);
        txtIdDetalle.setText("" + id_detalle);
    }//GEN-LAST:event_tableConfirmacionPedidosMouseClicked

    private void btnCancelarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPlatoActionPerformed
        // TODO add your handling code here:
        LimpiarPlatos();
    }//GEN-LAST:event_btnCancelarPlatoActionPerformed

    private void btnBuscarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPlatoActionPerformed
        // TODO add your handling code here:
        // Obtener el texto del campo de búsqueda
        String busqueda = txtBuscadorPlato.getText().trim();

        // Verificar si el campo está vacío
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del plato que desea buscar");
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) TablePlatos.getModel();
        // Limpiar la tabla antes de mostrar resultados
        modelo.setRowCount(0);

        // Consultar la base de datos para buscar los platos
        ProductoDAO productoDAO = new ProductoDAO(); // Crear una instancia de ProductoDAO
        List<Producto> platos = productoDAO.listar(busqueda); // Buscar platos con el nombre que contiene la búsqueda
        boolean encontrado = false;

        // Recorrer la lista de platos para agregar aquellos que coinciden con la búsqueda
        for (Producto plato : platos) {
            modelo.addRow(new Object[]{
                plato.getId_producto(),
                plato.getNom_producto(),
                plato.getTipoPlato(),
                plato.getPrecio(),
                plato.getDescripcion()
            });
            encontrado = true;
        }

        // Mostrar mensaje si no se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron platos que coincidan con la búsqueda");
        }
    }//GEN-LAST:event_btnBuscarPlatoActionPerformed

    private void TableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuariosMouseClicked
        // TODO add your handling code here:
        // Obtener la fila seleccionada en la tabla
        int fila = TableUsuarios.rowAtPoint(evt.getPoint());

        // Establecer los valores en los campos de texto correspondientes   
        txtIdEmpleado.setText(TableUsuarios.getValueAt(fila, 0).toString());
        txtNombre.setText(TableUsuarios.getValueAt(fila, 1).toString());
        txtApellidosEmpleado.setText(TableUsuarios.getValueAt(fila, 2).toString());
        txtCorreo.setText(TableUsuarios.getValueAt(fila, 3).toString());
        txtCelularEmpleado.setText(TableUsuarios.getValueAt(fila, 6).toString());
        txtDNIEmpleado.setText(TableUsuarios.getValueAt(fila, 7).toString());
        txtDireccionEmpleado.setText(TableUsuarios.getValueAt(fila, 9).toString());

        // Establecer el valor seleccionado en el ComboBox de género
        String genero = TableUsuarios.getValueAt(fila, 8).toString();
        cbxGeneroEmpleado.setSelectedItem(genero);

        // Establecer el valor en el campo de contraseña (opcional, depende de los requisitos de seguridad)
        txtPass.setText(TableUsuarios.getValueAt(fila, 4).toString());

        // Establecer el valor seleccionado en el ComboBox de rol
        String rol = TableUsuarios.getValueAt(fila, 5).toString();
        cbxRol.setSelectedItem(rol);
    }//GEN-LAST:event_TableUsuariosMouseClicked

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoActionPerformed

    private void btnCancelarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEmpleadoActionPerformed
        // TODO add your handling code here:
        LimpiarUsuario();
    }//GEN-LAST:event_btnCancelarEmpleadoActionPerformed

    private void btnEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoActionPerformed
        // TODO add your handling code here:
        // Verificar si el campo de ID está vacío
        if ("".equals(txtIdEmpleado.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para editar");
        } else {
            // Validar que los campos obligatorios no estén vacíos
            if (!"".equals(txtNombre.getText()) && !"".equals(txtApellidosEmpleado.getText())
                    && !"".equals(txtCorreo.getText()) && !"".equals(txtCelularEmpleado.getText())
                    && !"".equals(txtDNIEmpleado.getText()) && !"".equals(txtDireccionEmpleado.getText())) {

                // Mostrar ventana de confirmación
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea editar este registro?",
                        "Confirmación de Edición",
                        JOptionPane.YES_NO_OPTION);

                // Si el usuario selecciona 'Sí'
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        // Crear una nueva instancia de login (usuario)
                        login usuario = new login();
                        usuario.setId(Integer.parseInt(txtIdEmpleado.getText()));  // Establecer el ID del usuario
                        usuario.setNombre(txtNombre.getText());
                        usuario.setApellido(txtApellidosEmpleado.getText());
                        usuario.setCorreo(txtCorreo.getText());
                        usuario.setPass(txtPass.getText());  // Se asume que el campo de contraseña es opcional
                        usuario.setRol(cbxRol.getSelectedItem().toString());
                        usuario.setCelular(Integer.parseInt(txtCelularEmpleado.getText()));
                        usuario.setDni(Integer.parseInt(txtDNIEmpleado.getText()));
                        usuario.setGenero(cbxGeneroEmpleado.getSelectedItem().toString());
                        usuario.setDireccion(txtDireccionEmpleado.getText());

                        // Instanciar el DAO para editar el usuario
                        LoginDao loginDAO = new LoginDao();
                        if (loginDAO.EditarUsuario(usuario)) {
                            JOptionPane.showMessageDialog(null, "Empleado editado correctamente");
                            LimpiarTable();  // Método para limpiar la tabla y actualizarla
                            ListarUsuarios(TableUsuarios);  // Método para actualizar la tabla con la lista de usuarios
                            LimpiarUsuario();  // Método para limpiar los campos del formulario
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al editar el empleado");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Verifique que los campos numéricos sean correctos");
                    }
                } else {
                    // Si el usuario selecciona 'No', no se hace nada
                    JOptionPane.showMessageDialog(null, "Edición cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
            }
        }
    }//GEN-LAST:event_btnEditarEmpleadoActionPerformed

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        // Verificar si el ID está vacío
        if (!"".equals(txtIdEmpleado.getText())) {  // Asegúrate de que txtIdEmpleado sea el campo donde se ingresa el ID del usuario
            // Confirmar si el usuario desea eliminar el registro
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este empleado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(txtIdEmpleado.getText()); // Convertir el ID a entero
                    LoginDao loginDao = new LoginDao(); // Usar el DAO para eliminar el usuario
                    if (loginDao.EliminarUsuario(id)) {
                        JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
                        LimpiarUsuario(); // Método para limpiar los campos del formulario
                        LimpiarTable(); // Método para limpiar la tabla
                        ListarUsuarios(TableUsuarios); // Método para actualizar la tabla con los datos actuales
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el empleado");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número válido");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
        // Obtener el texto del campo de búsqueda
        String busqueda = txtBuscadorEmpleados.getText().trim(); // Obtener texto del campo de búsqueda

        // Verificar si el campo está vacío
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor para buscar"); // Mostrar mensaje si está vacío
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) TableUsuarios.getModel();
        // Limpiar la tabla antes de mostrar resultados
        modelo.setRowCount(0);

        // Consultar la base de datos para buscar usuarios
        LoginDao loginDAO = new LoginDao(); // Crear una instancia de LoginDAO
        List<login> usuarios = loginDAO.listar(busqueda); // Buscar usuarios con el valor de búsqueda
        boolean encontrado = false;

        // Recorrer la lista de usuarios para agregar aquellos que coinciden con la búsqueda
        for (login usuario : usuarios) {
            modelo.addRow(new Object[]{
                usuario.getId(), // ID del usuario
                usuario.getNombre(), // Nombre del usuario
                usuario.getApellido(), // Apellido del usuario
                usuario.getCorreo(), // Correo del usuario
                usuario.getPass(), //Pass del usuario
                usuario.getRol(), // Rol del usuario
                usuario.getCelular(), // Celular del usuario
                usuario.getDni(), // DNI del usuario
                usuario.getGenero(), // Género del usuario
                usuario.getDireccion() // Dirección del usuario
            });
            encontrado = true; // Indicar que se encontró al menos un usuario
        }

        // Mostrar mensaje si no se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron usuarios que coincidan con la búsqueda");
        }
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // Obtiene el modelo de la tabla
        modelo = (DefaultTableModel) tableMenu.getModel();

        // Verifica si se ha seleccionado alguna fila
        int selectedRow = tableMenu.getSelectedRow();

        if (selectedRow != -1) { // Si se ha seleccionado una fila
            // Obtiene la cantidad actual del plato seleccionado
            int cantidad = Integer.parseInt(tableMenu.getValueAt(selectedRow, 3).toString());

            // Muestra un cuadro de diálogo preguntando si desea eliminar la fila seleccionada
            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Deseas eliminar esta cantidad de este plato? (Cantidad: " + cantidad + ")",
                    "Eliminar Plato",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                // Si selecciona "Sí", elimina la fila seleccionada
                modelo.removeRow(selectedRow);
                // Actualiza el total después de la eliminación
                TotalPagar(tableMenu, totalMenu);
            }
            // Si selecciona "No", no se hace nada y la fila no se elimina
        } else {
            // Si no se ha seleccionado ninguna fila, muestra un mensaje de advertencia
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void RestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestarActionPerformed
        // TODO add your handling code here:
        // Verificar si se ha seleccionado una fila en la tabla de platos
        int selectedRow = tableMenu.getSelectedRow();

        if (selectedRow >= 0) {  // Si se ha seleccionado una fila
            int id = Integer.parseInt(tableMenu.getValueAt(selectedRow, 0).toString());
            double precio = Double.parseDouble(tableMenu.getValueAt(selectedRow, 4).toString()); // Precio unitario
            int cantidadActual = Integer.parseInt(tableMenu.getValueAt(selectedRow, 3).toString()); // Cantidad actual

            // Si la cantidad es mayor a 1, reducir la cantidad en 1
            if (cantidadActual > 1) {
                int nuevaCantidad = cantidadActual - 1; // Nueva cantidad después de restar 1
                double nuevoSubtotal = nuevaCantidad * precio; // Nuevo subtotal

                // Actualiza la cantidad y el subtotal en la tabla
                tableMenu.setValueAt(nuevaCantidad, selectedRow, 3); // Actualiza cantidad (columna 3)
                tableMenu.setValueAt(nuevoSubtotal, selectedRow, 5);  // Actualiza subtotal (columna 5)

                // Actualiza el total a pagar después de modificar
                TotalPagar(tableMenu, totalMenu);
            } else {
                // Si la cantidad es 1, no puedes reducirla más
                JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor a 1.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si no se ha seleccionado ninguna fila, mostrar un mensaje
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un registro para restar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_RestarActionPerformed

    private void TablePedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePedidosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePedidosMouseEntered

    private void btnCambiarEstadoDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoDetalleActionPerformed
        // TODO add your handling code here:
        // Verifica si se seleccionó una fila
        int filaSeleccionada = tableConfirmacionPedidos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro de la tabla.");
            return;
        }

        // Obtén el ID del detalle desde la columna correspondiente
        int idDetalle = Integer.parseInt(tableConfirmacionPedidos.getValueAt(filaSeleccionada, 0).toString());

        // Cambiar el estado del detalle
        boolean resultado = pedDao.cambiarEstadoDetalle(idDetalle, "REALIZADO");
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Estado cambiado a 'REALIZADO'");
            actualizarTablaDetalles(); // Método opcional para refrescar la tabla

        } else {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado");
        }
    }//GEN-LAST:event_btnCambiarEstadoDetalleActionPerformed

    private void txtBuscadorConfirmacionPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorConfirmacionPedidoKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscadorConfirmacionPedidoKeyPressed

    private void txtBuscadorConfirmacionPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorConfirmacionPedidoKeyReleased
        // TODO add your handling code here:
        LimpiarTable();
        ListarEstados(tableConfirmacionPedidos);
    }//GEN-LAST:event_txtBuscadorConfirmacionPedidoKeyReleased

    private void btnExportar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportar2ActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(tableConfirmacionPedidos);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnExportar2ActionPerformed

    private void btnExportar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportar3ActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(TableUsuarios);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnExportar3ActionPerformed

    private void btnUsuarios4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarios4ActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarUsuarios();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnUsuarios4ActionPerformed

    private void PanelSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSalasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelSalasMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void txtFechaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaHoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel LabelVendedor;
    private javax.swing.JPanel PanelMesas;
    private javax.swing.JPanel PanelSalas;
    private javax.swing.JButton Restar;
    private javax.swing.JTable TablePedidos;
    private javax.swing.JTable TablePlatos;
    public javax.swing.JTable TableUsuarios;
    private javax.swing.JButton btnActualizarSala;
    private javax.swing.JButton btnAgregarComentario;
    private javax.swing.JButton btnAñadirPlato;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarPlato;
    private javax.swing.JButton btnBuscarSala;
    private javax.swing.JButton btnCambiarEstadoDetalle;
    private javax.swing.JButton btnCancelarEmpleado;
    private javax.swing.JButton btnCancelarPlato;
    private javax.swing.JButton btnCancelarSala;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnEditarPlato;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarPlato;
    private javax.swing.JButton btnEliminarSala;
    private javax.swing.JButton btnEliminarTempPlato;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnExportar2;
    private javax.swing.JButton btnExportar3;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnGuardarPlato;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPestañaEstadoPedido;
    private javax.swing.JButton btnPestañaHistorialPedidosVentas;
    private javax.swing.JButton btnPestañaRegistroPlatos;
    private javax.swing.JButton btnPestañaSalas;
    private javax.swing.JButton btnRegistrarSala;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios4;
    private javax.swing.JComboBox<String> cbxGeneroEmpleado;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JComboBox<String> cbxTipoPlato;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JTable tableConfirmacionPedidos;
    private javax.swing.JTable tableFinalizar;
    private javax.swing.JTable tableMenu;
    private javax.swing.JTable tableSala;
    private javax.swing.JTable tblTemPlatos;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel totalFinalizar;
    private javax.swing.JLabel totalMenu;
    private javax.swing.JTextField txtApellidosEmpleado;
    private javax.swing.JTextField txtBuscadorConfirmacionPedido;
    private javax.swing.JTextField txtBuscadorEmpleados;
    private javax.swing.JTextField txtBuscadorPlato;
    private javax.swing.JTextField txtBuscadorSala;
    private javax.swing.JTextField txtBuscarPlato;
    private javax.swing.JTextField txtCelularEmpleado;
    private javax.swing.JTextPane txtComentario;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNIEmpleado;
    private javax.swing.JTextField txtDescripcionPlato;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtFechaHora;
    private javax.swing.JTextField txtIdDetalle;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdHistorialPedido;
    private javax.swing.JTextField txtIdPedido;
    private javax.swing.JTextField txtIdPlato;
    private javax.swing.JTextField txtIdSala;
    private javax.swing.JTextField txtMesas;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrePlato;
    private javax.swing.JTextField txtNombreSala;
    private javax.swing.JTextField txtNumMesaFinalizar;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPrecioPlato;
    private javax.swing.JTextField txtSalaFinalizar;
    private javax.swing.JTextField txtTempIdSala;
    private javax.swing.JTextField txtTempNumMesa;
    // End of variables declaration//GEN-END:variables

    //Metodo creado por el controlador, ejemplo del ing
    public void setControlador(SalaControlador controlador) {
        this.controlador = controlador;
    }

    private void ListarUsuarios() {
        List<login> Listar = lgDao.ListarUsuarios();
        modelo = (DefaultTableModel) TableUsuarios.getModel();
        Object[] ob = new Object[10];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getApellido();
            ob[3] = Listar.get(i).getCorreo();
            ob[4] = Listar.get(i).getPass();
            ob[5] = Listar.get(i).getRol();
            ob[6] = Listar.get(i).getCelular();
            ob[7] = Listar.get(i).getDni();
            ob[8] = Listar.get(i).getGenero();
            ob[9] = Listar.get(i).getDireccion();

            modelo.addRow(ob);
        }
        colorHeader(TableUsuarios);
    }

    private void ListarUsuarios(JTable tabla) {
        // Listar los usuarios utilizando el DAO correspondiente
        List<login> listaUsuarios = lgDao.ListarUsuarios(); // Obtiene la lista de usuarios desde el DAO
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); // Obtiene el modelo de la tabla
        modelo.setRowCount(0); // Limpia la tabla antes de agregar los nuevos datos

        // Definir el arreglo de objetos para agregar cada fila
        Object[] ob = new Object[10]; // Ajusta el tamaño según la cantidad de columnas en tu tabla

        // Recorre la lista de usuarios y agrega cada uno a la tabla
        for (login usuario : listaUsuarios) {
            ob[0] = usuario.getId(); // ID del usuario
            ob[1] = usuario.getNombre(); // Nombre del usuario
            ob[2] = usuario.getApellido(); // Apellido del usuario
            ob[3] = usuario.getCorreo(); // Correo del usuario
            ob[4] = usuario.getPass(); // Contraseña del usuario (puedes omitirla si no la necesitas mostrar)
            ob[5] = usuario.getRol(); // Rol del usuario
            ob[6] = usuario.getCelular(); // Celular del usuario
            ob[7] = usuario.getDni(); // DNI del usuario
            ob[8] = usuario.getGenero(); // Género del usuario
            ob[9] = usuario.getDireccion(); // Dirección del usuario

            modelo.addRow(ob); // Agrega la fila a la tabla
        }
        colorHeader(tabla); // Método para cambiar el color del encabezado de la tabla (si es necesario)
    }

    private void LimpiarTableMenu() {
        tmp = (DefaultTableModel) tableMenu.getModel();
        int fila = tableMenu.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }

    private void editarSala() {
        int filaSeleccionada = tableSala.getSelectedRow(); // Obtén la fila seleccionada
        if (filaSeleccionada >= 0) {
            // Actualiza los valores de la fila con los datos de los campos de texto
            tableSala.setValueAt(txtIdSala.getText(), filaSeleccionada, 0); // Columna ID
            tableSala.setValueAt(txtNombreSala.getText(), filaSeleccionada, 1); // Columna Nombre
            tableSala.setValueAt(txtMesas.getText(), filaSeleccionada, 2); // Columna Mesas

            // Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Sala editada correctamente.");
        } else {
            // Mensaje de error si no se seleccionó ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una sala para editar.");
        }
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void ListarSalas() {
        List<Sala> Listar = slDao.listarSalas();
        modelo = (DefaultTableModel) tableSala.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId_sala();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getMesa();
            modelo.addRow(ob);
        }
        colorHeader(tableSala);

    }

    private void colorHeader(JTable tabla) {
        tabla.setModel(modelo);
        JTableHeader header = tabla.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(0, 110, 255));
        header.setForeground(Color.white);
    }

    private void LimpiarSala() {
        txtIdSala.setText("");
        txtNombreSala.setText("");
        txtMesas.setText("");
    }

    private void LimpiarPlatos() {
        txtIdPlato.setText("");
        txtNombrePlato.setText("");
        txtPrecioPlato.setText("");
        txtDescripcionPlato.setText("");
    }

    private void LimpiarUsuario() {
        txtNombre.setText("");
        txtApellidosEmpleado.setText("");
        txtCorreo.setText("");
        txtCelularEmpleado.setText("");
        txtDNIEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        txtPass.setText("");
    }

    private void panelSalas() {
        List<Sala> Listar = slDao.listarSalas();
        for (int i = 0; i < Listar.size(); i++) {
            int id = Listar.get(i).getId_sala();
            int cantidad = Listar.get(i).getMesa();
            JButton boton = new JButton(Listar.get(i).getNombre(), new ImageIcon(getClass().getResource("/img/salas.png")));
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.setHorizontalTextPosition(JButton.CENTER);
            boton.setVerticalTextPosition(JButton.BOTTOM);
            boton.setBackground(new Color(204, 204, 204));
            PanelSalas.add(boton);
            boton.addActionListener((ActionEvent e) -> {
                LimpiarTable();
                PanelMesas.removeAll();
                panelMesas(id, cantidad);
                jTabbedPane1.setSelectedIndex(2);
            });
        }
    }

    //crear mesas
    private void panelMesas(int id_sala, int cant) {
        for (int i = 1; i <= cant; i++) {
            int num_mesa = i;
            //verificar estado
            JButton boton = new JButton("MESA N°: " + i, new ImageIcon(getClass().getResource("/img/mesa.png")));
            boton.setHorizontalTextPosition(JButton.CENTER);
            boton.setVerticalTextPosition(JButton.BOTTOM);
            int verificar = pedDao.verificarEstadoPedido(num_mesa, id_sala);
            if (verificar > 0) {
                boton.setBackground(new Color(255, 51, 51));
            } else {
                boton.setBackground(new Color(0, 102, 102));
            }
            boton.setForeground(Color.WHITE);
            boton.setFocusable(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            PanelMesas.add(boton);
            boton.addActionListener((ActionEvent e) -> {
                if (verificar > 0) {
                    LimpiarTable();
                    verPedido(verificar);
                    verPedidoDetalle(verificar);
                    btnFinalizar.setEnabled(true);

                    jTabbedPane1.setSelectedIndex(7);
                } else {
                    LimpiarTable();
                    ListarPlatos(tblTemPlatos);
                    jTabbedPane1.setSelectedIndex(5);
                    txtTempIdSala.setText("" + id_sala);
                    txtTempNumMesa.setText("" + num_mesa);
                }
            });
        }
    }

    // productos
    private void TotalPagar(JTable tabla, JLabel label) {
        Totalpagar = 0.00; // Reinicia el total a 0
        int numFila = tabla.getRowCount(); // Obtiene el número de filas en la tabla

        // Recorre cada fila de la tabla
        for (int i = 0; i < numFila; i++) {
            // Accede al subtotal (columna correcta)
            double subtotal = Double.parseDouble(tabla.getValueAt(i, 5).toString());
            Totalpagar += subtotal; // Suma el subtotal al total general
        }

        // Muestra el total en el JLabel formateado con 2 decimales
        label.setText(String.format("%.2f", Totalpagar));
    }

    public void verPedido(int id_pedido) {
        ped = pedDao.obtenerPedido(id_pedido);
        totalFinalizar.setText("" + ped.getTotal());
        txtFechaHora.setText("" + ped.getFecha());
        txtSalaFinalizar.setText("" + ped.getId_sala());
        txtNumMesaFinalizar.setText("" + ped.getNum_mesa());
        txtIdPedido.setText("" + ped.getId());
        ped.getId_sala();
        ped.getNum_mesa();
    }

    //registrar pedido
    private void RegistrarPedido() {
        int id_sala = Integer.parseInt(txtTempIdSala.getText());
        int num_mesa = Integer.parseInt(txtTempNumMesa.getText());
        double monto = Totalpagar;
        ped.setId_sala(id_sala);
        ped.setNum_mesa(num_mesa);
        ped.setTotal(monto);
        ped.setUsuario(LabelVendedor.getText());
        pedDao.registrarPedido(ped);
    }

    public void verPedidoDetalle(int id_pedido) {
        List<DetallePedido> Listar = pedDao.obtenerDetallesPedido(id_pedido);
        modelo = (DefaultTableModel) tableFinalizar.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId_detallepedido();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getTipoPlato();
            ob[3] = Listar.get(i).getCantidad();
            ob[4] = Listar.get(i).getPrecio();
            ob[5] = Listar.get(i).getCantidad() * Listar.get(i).getPrecio();
            ob[6] = Listar.get(i).getComentario();
            ob[7] = Listar.get(i).getEstado();
            modelo.addRow(ob);
        }
        colorHeader(tableFinalizar);
    }

    private void detallePedido() {
        int id = pedDao.obtenerUltimoIdPedido();
        for (int i = 0; i < tableMenu.getRowCount(); i++) {
            String nombre = tableMenu.getValueAt(i, 1).toString();
            String tipoPlato = tableMenu.getValueAt(i, 2).toString();
            int cant = Integer.parseInt(tableMenu.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(tableMenu.getValueAt(i, 4).toString());

            // Manejo de posibles valores nulos en la columna 6
            Object comentarioObj = tableMenu.getValueAt(i, 6);
            String comentario = (comentarioObj != null) ? comentarioObj.toString() : "";

            detPedido.setNombre(nombre);
            detPedido.setTipoPlato(tipoPlato);
            detPedido.setPrecio(precio);
            detPedido.setCantidad(cant);
            detPedido.setComentario(comentario);
            detPedido.setId_pedido(id);
            //detPedido.setEstado(estado);

            pedDao.registrarDetallePedido(detPedido);
        }
    }

    private void ListarPedidos() {
        Tables color = new Tables();
        List<Pedido> Listar = pedDao.listarPedidos();
        modelo = (DefaultTableModel) TablePedidos.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId();         // ID Pedido
            ob[1] = Listar.get(i).getSala();       // Sala (nombre)
            ob[2] = Listar.get(i).getUsuario();    // Usuario
            ob[3] = Listar.get(i).getNum_mesa();   // Número de Mesa
            ob[4] = Listar.get(i).getFecha();      // Fecha
            ob[5] = Listar.get(i).getTotal();      // Total
            ob[6] = Listar.get(i).getEstado();     // Estado
            modelo.addRow(ob);
        }
        colorHeader(TablePedidos);
        TablePedidos.setDefaultRenderer(Object.class, color);
    }

    private void ListarPlatos(JTable tabla) {
        // Cambia el nombre del método y la variable de acuerdo a la nueva clase
        List<Producto> listar = plaDao.listar(txtBuscarPlato.getText()); // Asegúrate de que txtBuscarProducto sea el campo correcto
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        Object[] ob = new Object[5]; // Cambia el tamaño del arreglo a 4 para incluir todos los campos de Producto

        for (Producto producto : listar) {
            ob[0] = producto.getId_producto(); // Asegúrate de usar getId_producto()
            ob[1] = producto.getNom_producto(); // Asegúrate de usar getNom_producto()
            ob[2] = producto.getTipoPlato(); // Incluye el tipo de plato si es necesario
            ob[3] = producto.getPrecio();// Asegúrate de usar getPrecio()
            ob[4] = producto.getDescripcion(); //Se incluye la descripcion
            modelo.addRow(ob);
        }
        colorHeader(tabla);
    }

    private void ListarEstados(JTable tabla) {
        // Obtiene el texto ingresado en el campo de búsqueda
        String textoBusqueda = txtBuscadorConfirmacionPedido.getText().trim(); // Elimina espacios extra al inicio y al final

        // Verifica que el campo de búsqueda no esté vacío
        if (!textoBusqueda.isEmpty()) {
            // Convertir el texto de búsqueda a un entero si es un ID de pedido
            try {
                int idPedido = Integer.parseInt(textoBusqueda); // Intenta convertir el texto a un entero
                // Llama al método del DAO para obtener los detalles del pedido con el ID buscado
                List<DetallePedido> listar = pedDao.obtenerDetallesPedido(idPedido);
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

                Object[] ob = new Object[8]; // Cambia el tamaño del arreglo según la cantidad de columnas necesarias

                for (DetallePedido detalle : listar) {
                    ob[0] = detalle.getId_detallepedido(); // ID del detalle del pedido
                    ob[1] = detalle.getNombre(); // Nombre del producto
                    ob[2] = detalle.getTipoPlato(); // Tipo de plato
                    ob[3] = detalle.getCantidad(); // Cantidad del producto
                    ob[4] = detalle.getPrecio(); // Precio del producto
                    ob[5] = detalle.getComentario(); // Comentarios o notas del detalle
                    ob[6] = detalle.getId_pedido();
                    ob[7] = detalle.getEstado(); // Estado del detalle
                    modelo.addRow(ob); // Añadir la fila a la tabla
                }
                colorHeader(tabla); // Si tienes un método para personalizar la cabecera, úsalo aquí
            } catch (NumberFormatException e) {
                // Si no se puede convertir el texto a número, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID de pedido válido", "Error de búsqueda", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si el campo de búsqueda está vacío, no muestra nada
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0); // Limpiar la tabla
        }
    }

    private void ListarDetallesPedido() {
        Tables color = new Tables(); // Clase para personalizar la tabla, como en el ejemplo.
        List<DetallePedido> listarDetalles = pedDao.listarDetallesPedido(); // Llama al DAO para obtener los detalles.
        modelo = (DefaultTableModel) tableConfirmacionPedidos.getModel();
        //modelo.setRowCount(0); // Limpia la tabla antes de llenarla.
        Object[] ob = new Object[8]; // Ajusta el tamaño del arreglo al número de columnas en la tabla.
        for (int i = 0; i < listarDetalles.size(); i++) {
            ob[0] = listarDetalles.get(i).getId_detallepedido();          // ID Detalle
            ob[1] = listarDetalles.get(i).getNombre();      // Nombre del Producto
            ob[2] = listarDetalles.get(i).getTipoPlato();   // Tipo de Plato
            ob[3] = listarDetalles.get(i).getCantidad();    // Cantidad
            ob[4] = listarDetalles.get(i).getPrecio();      // Precio Unitario
            ob[5] = listarDetalles.get(i).getComentario();  // Comentario
            ob[6] = listarDetalles.get(i).getId_pedido();
            ob[7] = listarDetalles.get(i).getEstado();
            modelo.addRow(ob); // Añade la fila al modelo de la tabla.
        }
        colorHeader(tableConfirmacionPedidos); // Aplica el estilo al encabezado.
        tableConfirmacionPedidos.setDefaultRenderer(Object.class, color); // Aplica el estilo a las celdas.
    }

    private void actualizarTablaDetalles() {
        DefaultTableModel modelo = (DefaultTableModel) tableConfirmacionPedidos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        List<DetallePedido> lista = pedDao.listarDetallesPedido(); // Supongamos que tienes este método
        for (DetallePedido detalle : lista) {
            modelo.addRow(new Object[]{
                detalle.getId_detallepedido(),
                detalle.getNombre(),
                detalle.getTipoPlato(),
                detalle.getPrecio(),
                detalle.getCantidad(),
                detalle.getComentario(),
                detalle.getId_pedido(),
                detalle.getEstado()
            });
        }
    }

}
