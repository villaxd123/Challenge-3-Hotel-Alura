package com.hotelalura.views;

import com.hotelalura.controller.ClienteController;
import com.hotelalura.controller.ReservaController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Busqueda extends JFrame {

    private final JLabel labelBack;
    private final JLabel labelExit;
    int xMouse, yMouse;
    private final ClienteController clienteController;
    private final ReservaController reservaController;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Busqueda frame = new Busqueda();
                frame.setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Busqueda() {
        setIconImage(new ImageIcon("src/main/java/com/hotelalura/assets/lupa2.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);

        clienteController = new ClienteController();
        reservaController = new ReservaController();

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);


        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 300, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);


        JScrollPane scroll_table = getTableReservas();
        panel.addTab("Reservas", new ImageIcon("src/main/java/com/hotelalura/assets/reservado.png"), scroll_table, null);
        scroll_table.setVisible(true);


        JScrollPane scroll_tableHospedados = getTableHospedados();
        panel.addTab("Huéspedes", new ImageIcon("src/main/java/com/hotelalura/assets/personas.png"), scroll_tableHospedados, null);
        scroll_tableHospedados.setVisible(true);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/Ha-100px.png"));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = getHeaderPanel();
        contentPane.add(header);

        JPanel btnBack = new JPanel();
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnBack.setBackground(new Color(12, 138, 199));
                labelBack.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnBack.setBackground(Color.white);
                labelBack.setForeground(Color.black);
            }
        });
        btnBack.setLayout(null);
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(0, 0, 53, 36);
        header.add(btnBack);

        labelBack = new JLabel("<");
        labelBack.setHorizontalAlignment(SwingConstants.CENTER);
        labelBack.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelBack.setBounds(0, 0, 53, 36);
        btnBack.add(labelBack);

        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnExit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnExit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnExit.setLayout(null);
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(857, 0, 53, 36);
        header.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnBuscar = new JPanel();
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Buscar algo...
            }
        });
        btnBuscar.setLayout(null);
        btnBuscar.setBackground(new Color(12, 138, 199));
        btnBuscar.setBounds(748, 125, 122, 35);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnBuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnBuscar.add(lblBuscar);

        JPanel btnEditar = new JPanel();
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Editar datos del Cliente o la Reserva
            }
        });
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        JPanel btnEliminar = new JPanel();
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Eliminar Reserva del Cliente
            }
        });
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);
    }

    private JPanel getHeaderPanel() {
        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        return header;
    }

    private JScrollPane getTableReservas() {
        JTable tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        DefaultTableModel modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");
        this.cargarReservas(modelo);
        System.out.println("Se agregó la lista de Reservas.");
        return new JScrollPane(tbReservas);
    }

    private JScrollPane getTableHospedados() {
        JTable tbHospedados = new JTable();
        tbHospedados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHospedados.setFont(new Font("Roboto", Font.PLAIN, 16));
        DefaultTableModel modeloHospedaje = (DefaultTableModel) tbHospedados.getModel();
        modeloHospedaje.addColumn("Número de Huésped");
        modeloHospedaje.addColumn("Nombre");
        modeloHospedaje.addColumn("Apellido");
        modeloHospedaje.addColumn("Fecha de Nacimiento");
        modeloHospedaje.addColumn("País");
        modeloHospedaje.addColumn("Teléfono");
        modeloHospedaje.addColumn("Número de Reserva");
        this.cargarClientes(modeloHospedaje);
        System.out.println("Se agregó la lista de Clientes.");
        return new JScrollPane(tbHospedados);
    }

    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void cargarClientes(DefaultTableModel tableModel) {
        var clientes = this.clienteController.listar();
        clientes.forEach(cliente -> tableModel.addRow(
                new Object[]{
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getFechaNacimiento(),
                        cliente.getNacionalidad(),
                        cliente.getCelular(),
                        cliente.getReservaId()
                }
        ));
    }

    private void cargarReservas(DefaultTableModel tableModel) {
        var reservas = this.reservaController.listar();
        reservas.forEach(reserva -> tableModel.addRow(
                new Object[]{
                        reserva.getId(),
                        reserva.getFechaEntrada(),
                        reserva.getFechaSalida(),
                        reserva.getValor(),
                        reserva.getFormaPago()
                }
        ));
    }
}