package com.dominivideos.view.windows.InputWindows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase de la capa view.windows.InputWindows, para la creación de las distintas
 * ventanas en las que se pide al usuario que introduzca datos
 * 
 * Para la creación de las ventanas con campos de entrada de datos se ha
 * empleado el patrón de diseño "Builder". Se ha usado este patrón para
 * experimentar con un patrón distinto al Factory. 
 * 
 * En la implementación del patrón Builder, esta clase abstracta actúa a modo de
 * interfaz. Las pantallas para iniciar la sesión y para crear un nuevo video
 * heredan de esta clase para construir sus respectivos paneles.
 * 
 */

public abstract class WindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JPanel panel = new JPanel(new GridBagLayout());
	protected GridBagConstraints constraints = new GridBagConstraints();

	/**
	 * Métodos para que las subclases creen sus etiquetas y botones
	 * 
	 */
	public abstract void buildLabels();

	public abstract void buildButtons();

	/**
	 * Método para que las subclases construyan el panel completo
	 * 
	 * @return el panel contenedor una vez añadidos todos sus componentes
	 * 
	 */
	public abstract JPanel buildPanel();

}
