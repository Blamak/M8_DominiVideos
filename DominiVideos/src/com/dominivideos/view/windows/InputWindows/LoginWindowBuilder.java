package com.dominivideos.view.windows.InputWindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.dominivideos.domain.User;
import com.dominivideos.view.windows.Login;
import com.dominivideos.view.windows.WelcomeWindow;

/**
 * Clase de la capa view.windows.InputWindows
 * 
 * Clase para construir una ventana específica de logueo de usuario.
 * 
 * Hereda de WindowBuilder, de la que sobreescribe los métodos de construcción
 * de las distintas partes de la ventana.
 */

public class LoginWindowBuilder extends WindowBuilder {

	private static final long serialVersionUID = 1L;

	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JButton btnLogin;
	private JButton btnCancel;

	private List<User> usersList;

	/**
	 * Constructor.
	 * 
	 * @param usersList, lista de todos los usuarios.
	 */
	public LoginWindowBuilder(List<User> usersList) {
		this.usersList = usersList;
	}

	/**
	 * Anulación de método que implementa la creación de las etiquetas y campos de
	 * texto correspondientes a esta ventana.
	 * 
	 * "panel" y "constraints" son atributos declarados en la superclase
	 * WindowBuilder.
	 */
	@Override
	public void buildLabels() {

		constraints.fill = GridBagConstraints.HORIZONTAL;
		lbUsername = new JLabel("Username: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		panel.add(lbUsername, constraints);

		tfUsername = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		panel.add(tfUsername, constraints);

		lbPassword = new JLabel("Password: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		panel.add(lbPassword, constraints);

		pfPassword = new JPasswordField(20);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		panel.add(pfPassword, constraints);
		
		panel.setBorder(new LineBorder(Color.GRAY));
	}

	/**
	 * Anulación de método que implementa la creación de los botones
	 * correspondientes a esta ventana.
	 * 
	 * @throws RuntimeException, si hay algún campo vacío o
	 * si el login no es exitoso
	 */
	@Override
	public void buildButtons() {

		btnLogin = new JButton("Iniciar sesión");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String userName = tfUsername.getText().trim();
					String userPassword = new String(pfPassword.getPassword());

					if (userName.trim().isEmpty() || userPassword.trim().isEmpty()) {
						throw new RuntimeException("Campos a rellenar obligatorios");
					}

					User userLogged = Login.authenticate(userName, userPassword, usersList);
					if (userLogged == null) {
						throw new RuntimeException("Nombre de usuario y/o contraseña incorrectos.");
					} else {
						dispose(); // Cerrar ventana
						@SuppressWarnings("unused")
						WelcomeWindow welcome = new WelcomeWindow(userLogged);
					}

				} catch (RuntimeException ex) {
					// Vaciar campos y mostrar ventana de alerta
					tfUsername.setText("");
					pfPassword.setText("");
					JOptionPane.showMessageDialog(LoginWindowBuilder.this, ex.getMessage(), "Login",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * Anulación de método para construir el panel ya completo.
	 * 
	 * @return el panel con todos sus componentes.
	 */
	@Override
	public JPanel buildPanel() {

		JPanel bp = new JPanel();
		bp.add(btnLogin);
		bp.add(btnCancel);

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		return panel;
	}

}
