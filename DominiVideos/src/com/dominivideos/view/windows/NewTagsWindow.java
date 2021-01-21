package com.dominivideos.view.windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Clase para añadir tags durante la creación de un nuevo video
 * 
 * Se instancia en la clase NewVideoWindowBuilder de la capa
 * view.windows.InputWindows
 * 
 * En un campo de texto se escribe el tag a añadir, que se traslada a una JList
 * en la que se visualizan los tags que se van añadiendo
 * 
 */

public class NewTagsWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private DefaultListModel<String> model; // Para modelar el contenido de la lista de tags para la JList
	String tagText; // Almacena el tag escrito cada vez en el campo de texto

	/**
	 * Constructor que ejecuta el método init() y los métodos para terminar de
	 * construir la ventana
	 * 
	 */
	public NewTagsWindow() {
		init();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Método para construir la ventana de creación de nuevos tags
	 * 
	 * En un campo de texto se escribe el tag y se añade al pulsar el botón "Añadir"
	 * 
	 * Pulsando "Listo" se cierra la ventana
	 * 
	 * @throws RuntimeException, al pulsar cualquiera de los dos botones si no se ha
	 *                           añadido ningún tag
	 * 
	 */
	private void init() {
		final JTextField field = new JTextField(10);
		JButton add = new JButton("Añadir");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tagText = field.getText(); // Almacena el tag introducido
					if (tagText.isEmpty()) {
						throw new RuntimeException("El video debe tener un tag como mínimo.");
					}
					model.addElement(tagText); // Añade al modelo el tag
					field.setText("");
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(NewTagsWindow.this, ex.getMessage(), "Añadir tags",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton done = new JButton("Listo");
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tagText.isEmpty()) {
						throw new RuntimeException("El video debe tener un tag como mínimo.");
					}
					dispose(); // Cerrar ventana
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(NewTagsWindow.this, ex.getMessage(), "Añadir tags",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel p = new JPanel();
		p.add(field);
		p.add(add);
		p.add(done);

		JList<String> list = new JList<>(model = new DefaultListModel<>());
		add(new JScrollPane(list));
		add(p, BorderLayout.SOUTH);
	}

	/**
	 * Método para mostrar en una lista los tags a medida que se van añadiendo
	 * 
	 * Se ejecuta al pulsar el botón "Listo" de la clase NewVideoWindowBuilder de la
	 * capa view.windows.InputWindows
	 * 
	 * Recorre cada uno de los elementos del modelo y los va añadiendo a una lista
	 * 
	 * @return una lista de los tags añadidos
	 * 
	 */
	public List<String> getNewTags() {
		List<String> modelList = new ArrayList<>(); // Lista para guardar cada uno de los tags
		for (Object string : this.model.toArray()) {
			modelList.add((String) string);
		}
		return modelList;
	}

}
