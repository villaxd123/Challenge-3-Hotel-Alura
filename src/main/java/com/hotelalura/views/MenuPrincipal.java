package com.hotelalura.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MenuPrincipal extends JFrame {

    private final JLabel labelExit;
    int xMouse, yMouse;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        setIconImage(new ImageIcon("src/main/java/com/hotelalura/assets/aH-40px.png").getImage());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 910, 537);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);


        Panel panel = new Panel();
        panel.setBackground(SystemColor.window);
        panel.setBounds(0, 0, 910, 537);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(-50, 0, 732, 501);
        imagenFondo.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/menu-img.png"));
        panel.add(imagenFondo);

        JLabel logo = new JLabel("");
        logo.setBounds(722, 80, 150, 156);
        logo.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/aH-150px.png"));
        panel.add(logo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 500, 910, 37);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblCopyR = new JLabel("Desarrollado por Jorge Villafuerte © 2023");
        lblCopyR.setBounds(315, 11, 334, 19);
        lblCopyR.setForeground(new Color(240, 248, 255));
        lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel_1.add(lblCopyR);

        //Barra para controlar la ventana
        JPanel header = getHeader();
        panel.add(header);

        //Botón salir
        JPanel btnExit = getBtnExit();
        header.add(btnExit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        //Botón Login
        JPanel btnLogin = getBtnLogin();
        panel.add(btnLogin);

        JLabel imagenLogin = new JLabel("");
        imagenLogin.setBounds(0, 0, 80, 70);
        btnLogin.add(imagenLogin);
        imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
        imagenLogin.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/login.png"));

        JLabel lblTitulo = new JLabel("LOGIN");
        lblTitulo.setBounds(754, 265, 83, 24);
        lblTitulo.setBackground(SystemColor.window);
        panel.add(lblTitulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(SystemColor.textHighlight);
        lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
    }

    private JPanel getBtnLogin() {
        JPanel btnLogin = new JPanel();
        btnLogin.setBounds(754, 300, 83, 70);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setBackground(SystemColor.window);
        return btnLogin;
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
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(857, 0, 53, 36);
        return btnExit;
    }

    private JPanel getHeader() {
        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
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
        return header;
    }

    //Código que permite mover la ventana siguiendo la posición de "x" e "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
