package com.dominivideos.view.windows.InputWindows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase de la capa view.windows.InputWindows, para la creaci�n de las distintas
 * ventanas en las que se pide al usuario que introduzca datos
 * 
 * Para la creaci�n de las ventanas con campos de entrada de datos se ha
 * empleado el patr�n de dise�o "Builder". Se ha usado este patr�n para
 * experimentar con un patr�n distinto al Factory. 
 * 
 * En la implementaci�n del patr�n Builder, esta clase abstracta act�a a modo de
 * interfaz. Las pantallas para iniciar la sesi�n y para crear un nuevo video
 * heredan de esta clase para construir sus respectivos paneles.
 * 
 */

public abstract class WindowBuilder extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JPanel panel = new JPanel(new GridBagLayout());
	protected GridBagConstraints constraints = new GridBagConstraints();

	/**
	 * M�todos para que las subclases creen sus etiquetas y botones
	 * 
	 */
	public abstract void buildLabels();

	public abstract void buildButtons();

	/**
	 * M�todo para que las subclases construyan el panel completo
	 * 
	 * @return el panel contenedor una vez a�adidos todos sus componentes
	 * 
	 */
	public abstract JPanel buildPanel();

}
