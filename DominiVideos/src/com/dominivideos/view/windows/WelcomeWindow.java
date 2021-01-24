package com.dominivideos.view.windows;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.dominivideos.domain.User;
import com.dominivideos.view.windows.InputWindows.NewVideoWindowBuilder;
import com.dominivideos.view.windows.InputWindows.WindowBuilder;
import com.dominivideos.view.windows.InputWindows.WindowDirector;

/**
 * Clase de la capa view.windows
 * 
 * Clase que crea la ventana de bienvenida tras logueo exitoso del usuario
 * 
 * Se instancia en la clase LoginWindowBuilder de la capa
 * view.windows.Inputwindows
 *
 */
public class WelcomeWindow {

	User user;

	/**
	 * Constructor que identifica al usuario y ejecuta el método init()
	 * 
	 * @param user, usuario logueado
	 */
	public WelcomeWindow(User user) {
		this.user = user;
		init();
	}

	/**
	 * Método que crea la ventana de bienvenida
	 */
	private void init() {
							// answer = 0     // answer = 1
		Object[] options = { "Ver mis videos", "Nuevo video" };
		int answer = JOptionPane.showOptionDialog(null,
				"Hola " + user.getName() + " " + user.getSurname() + "!" + "\n\nQué quieres hacer?\n\n\n", "",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (answer == 0) {
			// Mostrar la lista de videos del usuario al pulsar el botón "Ver mis videos".
			@SuppressWarnings("unused")
			VideosListWindow videosList = new VideosListWindow(user);
		}

		if (answer == 1) {
			// Abrir la ventana de creación de nuevo video si se pulsa "Nuevo video".
			WindowDirector director = new WindowDirector();
			WindowBuilder builder = new NewVideoWindowBuilder(user);
			@SuppressWarnings("unused")
			JPanel panel = director.createJpanel(builder);
		}

	}
}
