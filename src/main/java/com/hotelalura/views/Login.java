package com.hotelalura.views;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

public class Login extends JFrame {

    /**
     * Set the variables or components of the login frame.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextField txtUsuario;
    private final JPasswordField txtPass;
    int xMouse, yMouse;
    private final JLabel labelExit;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 788, 527);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 788, 527);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(12, 138, 199));
        panel_1.setBounds(484, 0, 304, 527);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel imgHotel = new JLabel("");
        imgHotel.setBounds(0, 0, 304, 538);
        panel_1.add(imgHotel);
        System.out.println();
        imgHotel.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/img-hotel-login-.png"));

        JPanel btnExit = new JPanel();
        btnExit.setBounds(251, 0, 53, 36);
        panel_1.add(btnExit);
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
                btnExit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnExit.setBackground(new Color(12, 138, 199));
        btnExit.setLayout(null);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnExit.add(labelExit);
        labelExit.setForeground(SystemColor.text);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);

        txtUsuario = new JTextField();
        txtUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent event) {
                if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
                    txtUsuario.setText("");
                    txtUsuario.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (txtUsuario.getText().isEmpty()) {
                    txtUsuario.setText("Ingrese su nombre de usuario");
                    txtUsuario.setForeground(Color.gray);
                }
            }
        });
        txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtUsuario.setForeground(SystemColor.activeCaptionBorder);
        txtUsuario.setBounds(65, 256, 324, 32);
        panel.add(txtUsuario);
        txtUsuario.setColumns(10);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 120, 215));
        separator.setBounds(65, 292, 324, 2);
        panel.add(separator);

        JLabel labelTitulo = new JLabel("INICIAR SESIÓN");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
        labelTitulo.setBounds(65, 149, 202, 26);
        panel.add(labelTitulo);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(SystemColor.textHighlight);
        separator_1.setBounds(65, 393, 324, 2);
        panel.add(separator_1);

        txtPass = new JPasswordField();
        txtPass.setText("********");
        txtPass.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent event) {
                if (String.valueOf(txtPass.getPassword()).equals("********")) {
                    txtPass.setText("");
                    txtPass.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (String.valueOf(txtPass.getPassword()).isEmpty()) {
                    txtPass.setText("********");
                    txtPass.setForeground(Color.gray);
                }
            }
        });
        txtPass.setForeground(SystemColor.activeCaptionBorder);
        txtPass.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtPass.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtPass.setBounds(65, 353, 324, 32);
        panel.add(txtPass);

        JLabel LabelUsuario = new JLabel("USUARIO");
        LabelUsuario.setForeground(SystemColor.textInactiveText);
        LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        LabelUsuario.setBounds(65, 219, 107, 26);
        panel.add(LabelUsuario);

        JLabel labelPassword = new JLabel("CONTRASEÑA");
        labelPassword.setForeground(SystemColor.textInactiveText);
        labelPassword.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        labelPassword.setBounds(65, 316, 140, 26);
        panel.add(labelPassword);

        JPanel btnLogin = new JPanel();
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(0, 156, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(SystemColor.textHighlight);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                doLogin();
            }
        });
        btnLogin.setBackground(SystemColor.textHighlight);
        btnLogin.setBounds(65, 431, 122, 44);
        panel.add(btnLogin);
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel lblNewLabel = new JLabel("ENTRAR");
        lblNewLabel.setBounds(0, 0, 122, 44);
        btnLogin.add(lblNewLabel);
        lblNewLabel.setForeground(SystemColor.controlLtHighlight);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/lOGO-50PX.png"));
        lblNewLabel_1.setBounds(65, 65, 48, 59);
        panel.add(lblNewLabel_1);

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
        header.setBackground(SystemColor.window);
        header.setBounds(0, 0, 784, 36);
        panel.add(header);
        header.setLayout(null);
    }

    private void doLogin() {
        String Usuario = "admin";
        String Password = "admin";

        String insertedPassword = new String(txtPass.getPassword());

        if (txtUsuario.getText().equals(Usuario) && insertedPassword.equals(Password)) {
            MenuUsuario menu = new MenuUsuario();
            menu.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
        }
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
