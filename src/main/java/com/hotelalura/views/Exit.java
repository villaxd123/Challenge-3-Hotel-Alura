package com.hotelalura.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Exit extends JDialog {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            Exit dialog = new Exit();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Create the dialog.
     */
    public Exit() {
        setIconImage(new ImageIcon("src/main/java/com/hotelalura/assets/aH-40px.png").getImage());
        setBounds(100, 100, 394, 226);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(SystemColor.control);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/Ha-100px.png"));
            lblNewLabel.setBounds(123, 11, 100, 100);
            contentPanel.add(lblNewLabel);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Datos guardados satisfactoriamente");
            lblNewLabel_1.setForeground(new Color(12, 138, 199));
            lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
            lblNewLabel_1.setBounds(27, 122, 322, 21);
            contentPanel.add(lblNewLabel_1);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(e -> {
                    dispose();
                    MenuUsuario usuario = new MenuUsuario();
                    usuario.setVisible(true);
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
//            {
//                // Botón de Cancelar, actualmente sin uso.
//                JButton cancelButton = new JButton("Cancel");
//                cancelButton.setActionCommand("Cancel");
//                buttonPane.add(cancelButton);
//            }
        }
    }

}
