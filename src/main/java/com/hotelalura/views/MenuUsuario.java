package com.hotelalura.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class MenuUsuario extends JFrame {

    int xMouse, yMouse;
    private final JLabel labelExit;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuUsuario frame = new MenuUsuario();
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
    public MenuUsuario() {
        setIconImage(new ImageIcon("src/main/java/com/hotelalura/assets/aH-40px.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 609);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

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

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(12, 138, 199));
        panelMenu.setBounds(0, 0, 257, 609);
        contentPane.add(panelMenu);
        panelMenu.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(50, 58, 150, 150);
        panelMenu.add(lblNewLabel_2);
        lblNewLabel_2.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/aH-150px.png"));

        JPanel btnRegistro = new JPanel();
        btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistro.setBackground(new Color(118, 187, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistro.setBackground(new Color(12, 138, 199));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                ReservasView reservas = new ReservasView();
                reservas.setVisible(true);
                dispose();
            }
        });
        btnRegistro.setBounds(0, 255, 257, 56);
        btnRegistro.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnRegistro);
        btnRegistro.setLayout(null);

        JLabel labelRegistro = new JLabel("Registro de reservas");
        labelRegistro.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/reservado.png"));
        labelRegistro.setForeground(SystemColor.text);
        labelRegistro.setBounds(25, 11, 205, 34);
        labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
        btnRegistro.add(labelRegistro);

        JPanel btnSearch = new JPanel();
        btnSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSearch.setBackground(new Color(118, 187, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSearch.setBackground(new Color(12, 138, 199));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Busqueda busqueda = new Busqueda();
                busqueda.setVisible(true);
                dispose();
            }
        });
        btnSearch.setBounds(0, 312, 257, 56);
        btnSearch.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnSearch);
        btnSearch.setLayout(null);

        JLabel labelSearchReservas = new JLabel("Búsqueda");
        labelSearchReservas.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/personas.png"));
        labelSearchReservas.setBounds(27, 11, 200, 34);
        labelSearchReservas.setHorizontalAlignment(SwingConstants.LEFT);
        labelSearchReservas.setForeground(Color.WHITE);
        labelSearchReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnSearch.add(labelSearchReservas);

        JSeparator separator = new JSeparator();
        separator.setBounds(26, 219, 201, 2);
        panelMenu.add(separator);
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 944, 36);
        contentPane.add(header);

        JPanel btnExit = getBtnExit();
        header.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel panelFecha = new JPanel();
        panelFecha.setBackground(new Color(118, 187, 223));
        panelFecha.setBounds(256, 84, 688, 121);
        contentPane.add(panelFecha);
        panelFecha.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Sistema de reservas Hotel Alura");
        lblNewLabel_1.setBounds(180, 11, 356, 42);
        panelFecha.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 24));

        JLabel labelFecha = new JLabel("New label");
        labelFecha.setBounds(35, 64, 294, 36);
        panelFecha.add(labelFecha);
        labelFecha.setForeground(Color.WHITE);
        labelFecha.setFont(new Font("Roboto", Font.PLAIN, 33));
        Date fechaActual = new Date(); //fecha y hora actual
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formatear la fecha en una cadena
        labelFecha.setText("Hoy es " + fecha); //establecer la representación en cadena de la fecha

        JLabel lblNewLabel = new JLabel("Bienvenido");
        lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        lblNewLabel.setBounds(302, 234, 147, 46);
        contentPane.add(lblNewLabel);

        String textDescription = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huéspedes del hotel   </body></html>";
        JLabel labelDescription = new JLabel(textDescription);
        labelDescription.setFont(new Font("Roboto", Font.PLAIN, 17));

        labelDescription.setBounds(312, 291, 598, 66);
        contentPane.add(labelDescription);

        String textDescription1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a herramientas especiales para tareas específicas como lo son:</body></html>";
        JLabel labelDescription_1 = new JLabel(textDescription1);
        labelDescription_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescription_1.setBounds(311, 345, 569, 88);
        contentPane.add(labelDescription_1);

        JLabel lblNewLabel_3 = new JLabel("- Registro de Reservas y Huéspedes");
        lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(312, 444, 295, 27);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("- Edición de Reservas y Huéspedes existentes");
        lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3_1.setBounds(312, 482, 355, 27);
        contentPane.add(lblNewLabel_3_1);

        JLabel lblNewLabel_3_2 = new JLabel("- Eliminar todo tipo de registros");
        lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNewLabel_3_2.setBounds(312, 520, 295, 27);
        contentPane.add(lblNewLabel_3_2);
    }

    private JPanel getBtnExit() {
        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });

        btnExit.setLayout(null);
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(891, 0, 53, 36);
        return btnExit;
    }

    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
