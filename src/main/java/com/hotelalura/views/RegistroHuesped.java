package com.hotelalura.views;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegistroHuesped extends JFrame {

	private final JLabel labelExit;
	private final JLabel labelBack;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                RegistroHuesped frame = new RegistroHuesped();
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
	public RegistroHuesped() {
		
		setIconImage(new ImageIcon("src/main/java/com/hotelalura/assets/lOGO-50PX.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnBack = getBtnBack();
		header.add(btnBack);
		
		labelBack = new JLabel("<");
		labelBack.setHorizontalAlignment(SwingConstants.CENTER);
		labelBack.setForeground(Color.WHITE);
		labelBack.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelBack.setBounds(0, 0, 53, 36);
		btnBack.add(labelBack);


		JTextField txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);

		JTextField txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);

		JDateChooser txtFechaN = new JDateChooser();
		txtFechaN.setBounds(560, 278, 285, 36);
		txtFechaN.getCalendarButton().setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/icon-reservas.png"));
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaN);

		JComboBox<String> txtNacionalidad = getTxtNacionalidad();
		contentPane.add(txtNacionalidad);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(562, 119, 253, 14);
		lblNombre.setForeground(SystemColor.textInactiveText);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(560, 189, 255, 14);
		lblApellido.setForeground(SystemColor.textInactiveText);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblApellido);
		
		JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
		lblFechaN.setBounds(560, 256, 255, 14);
		lblFechaN.setForeground(SystemColor.textInactiveText);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblFechaN);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(560, 326, 255, 14);
		lblNacionalidad.setForeground(SystemColor.textInactiveText);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNacionalidad);
		
		JLabel labelPhone = new JLabel("TELÉFONO");
		labelPhone.setBounds(562, 406, 253, 14);
		labelPhone.setForeground(SystemColor.textInactiveText);
		labelPhone.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(labelPhone);

		JTextField txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);
		
		JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
		lblTitulo.setBounds(606, 55, 234, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblTitulo);
		
		JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
		lblNumeroReserva.setBounds(560, 474, 253, 14);
		lblNumeroReserva.setForeground(SystemColor.textInactiveText);
		lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNumeroReserva);

		JTextField txtNumReserva = new JTextField();
		txtNumReserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNumReserva.setBounds(560, 495, 285, 33);
		txtNumReserva.setColumns(10);
		txtNumReserva.setBackground(Color.WHITE);
		txtNumReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNumReserva);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);
		
		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);
		
		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(12, 138, 199));
		separator_1_2_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_5);
		
		JPanel btnGuardar = new JPanel();
		btnGuardar.setBounds(723, 560, 122, 35);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnGuardar);
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelGuardar = new JLabel("GUARDAR");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnGuardar.add(labelGuardar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		panel.add(imagenFondo);
		imagenFondo.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/registro.png"));
		
		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon("src/main/java/com/hotelalura/assets/Ha-100px.png"));
		
		JPanel btnExit = new JPanel();
		btnExit.setBounds(857, 0, 53, 36);
		contentPane.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
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
		btnExit.setBackground(Color.white);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
	}

	private static JComboBox<String> getTxtNacionalidad() {
		JComboBox<String> txtNacionalidad = new JComboBox<>();
		txtNacionalidad.setBounds(560, 350, 289, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel<>(new String[] {"Afganistán", "Alemania", "Arabia Saudita", "Argentina", "Australia", "Bélgica", "Bolivia", "Brasil", "camboyano-camboyana", "Canadá", "Chile", "China", "Colombia", "Corea del Sur", "Corea del Norte", "Costa Rica", "Cuba", "Dinamarca", "Ecuador", "Egipto", "El Salvador", "Escocia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Francia", "Gales", "Grecia", "Guatemala", "Haití", "Holanda", "Honduras", "India", "Inglaterra", "Irak", "Irán", "Irlanda", "Israel", "Italia", "Japón", "Jordania", "Laos", "Letonia", "Malasia", "Marruecos", "México", "Nicaragua", "Noruega", "Nueva Zelanda", "Panamá", "Paraguay", "Perú", "Polonia", "Portugal", "Puerto Rico", "República Dominicana", "Rumanía", "Rusia", "Suecia", "Suiza", "Tailandia", "Taiwán", "Turquía", "Ucrania", "Uruguay", "Venezuela", "Vietnam"}));
		return txtNacionalidad;
	}

	private JPanel getBtnBack() {
		JPanel btnBack = new JPanel();
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(Color.white);
				labelBack.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnBack.setBackground(new Color(12, 138, 199));
			     labelBack.setForeground(Color.white);
			}
		});
		btnBack.setLayout(null);
		btnBack.setBackground(new Color(12, 138, 199));
		btnBack.setBounds(0, 0, 53, 36);
		return btnBack;
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
											
}
