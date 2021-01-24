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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.dominivideos.application.VideosController;
import com.dominivideos.domain.User;
import com.dominivideos.view.windows.NewTagsWindow;
import com.dominivideos.view.windows.VideosListWindow;

/**
 * Clase de la capa view.windows.InputWindows
 * 
 * Clase para construir una ventana específica de creación de nuevo video.
 * 
 * Hereda de WindowBuilder, de la que sobreescribe los métodos de construcción
 * de las distintas partes de la ventana.
 */

public class NewVideoWindowBuilder extends WindowBuilder {

	private static final long serialVersionUID = 1L;

	private VideosController videoController = new VideosController();
	private User user;
	private NewTagsWindow newTags = null;

	private JLabel lbURL;
	private JTextField tfURL;
	private JLabel lbTitle;
	private JTextField tfTitle;
	private JButton btnAdd;
	private JButton btnExit;

	/**
	 * Constructor.
	 * 
	 * @param user, usuario logueado.
	 */
	public NewVideoWindowBuilder(User user) {
		this.user = user;
	}

	/**
	 * Anulación de método que implementa la creación de las etiquetas y campos de
	 * texto correspondientes a esta ventana.
	 * 
	 * "panel" y "constraints" son atributos
	 * declarados en la superclase WindowBuilder.
	 * 
	 */
	@Override
	public void buildLabels() {

		constraints.fill = GridBagConstraints.HORIZONTAL;
		lbURL = new JLabel("URL: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		panel.add(lbURL, constraints);

		tfURL = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		panel.add(tfURL, constraints);

		lbTitle = new JLabel("Título: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		panel.add(lbTitle, constraints);

		tfTitle = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		panel.add(tfTitle, constraints);

		panel.setBorder(new LineBorder(Color.GRAY));
	}

	/**
	 * Anulación de método que implementa la creación de los botones
	 * correspondientes a esta ventana.
	 * 
	 * @throws RuntimeException, si hay algún campo sin completar o si no se ha
	 *                           añadido ningún tag al video
	 */
	@Override
	public void buildButtons() {
		btnAdd = new JButton("Añadir tags");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newTags = new NewTagsWindow(); // Instancia para añadir tags
			}
		});

		btnExit = new JButton("Listo");
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfURL.getText().equals("") || tfTitle.getText().equals("")) {
						throw new RuntimeException("URL y Título son campos obligatorios.");
					}

					List<String> videoTags = newTags.getNewTags();
					if (newTags == null || videoTags.isEmpty()) {
						throw new RuntimeException("El video debe tener un tag como mínimo.");
					}

					dispose();
					videoController.createVideos(user, tfURL.getText(), tfTitle.getText(), videoTags);
					@SuppressWarnings("unused")
					VideosListWindow videosList = new VideosListWindow(user);

				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(NewVideoWindowBuilder.this, ex.getMessage(), "Añadir tags",
							JOptionPane.ERROR_MESSAGE);
				}
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
		bp.add(btnAdd);
		bp.add(btnExit);

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
