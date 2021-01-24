package com.dominivideos.view.windows.InputWindows;

import javax.swing.JPanel;

/**
 * Clase de la capa view.windows.InputWindows
 * 
 * Clase con un único método para construir los elementos del panel mediante la clase
 * abstracta WindowBuilder.
 *
 */
public class WindowDirector {

	public JPanel createJpanel(WindowBuilder builder) {
		builder.buildLabels();
		builder.buildButtons();
		return builder.buildPanel();
	}

}
