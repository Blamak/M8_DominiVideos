package com.dominivideos.view.windows.InputWindows;

import javax.swing.JPanel;

/**
 * Clase con un m�todo para construir los elementos del panel mediante la clase
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
