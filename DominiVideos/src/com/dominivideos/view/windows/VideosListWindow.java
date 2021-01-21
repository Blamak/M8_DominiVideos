package com.dominivideos.view.windows;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dominivideos.application.UsersController;
import com.dominivideos.domain.User;
import com.dominivideos.domain.Video;

/**
 * Clase para mostrar una lista de los videos del usuario logueado 
 * Crea una tabla con la información de cada video
 * 
 * Se instancia en la clase NewVideoWindowBuilder
 * de la capa view.windows.InputWindows
 * 
 *
 */
public class VideosListWindow {

	User user;
	private UsersController userController = new UsersController();
	private List<Video> videos = new ArrayList<>();

	/**
	 * Constructor que identifica al usuario y recupera una lista con sus videos
	 * 
	 * Ejecuta el método init() que crea la tabla
	 * 
	 * @param user, usuario logueado
	 */
	public VideosListWindow(User user) {
		this.user = user;
		this.videos = userController.listUserVideos(user);
		init();
	}

	/**
	 * Método que crea la tabla
	 */
	private void init() {
		Object[] columns = { "Título", "URL", "Tags" };
		Object[][] rows = new Object[this.videos.size()][3];

		Video video;
		// Recorre uno a uno los videos del usuario para crear las filas de la tabla
		for (int i = 0; i < this.videos.size(); i++) {
			video = this.videos.get(i);
			rows[i][0] = video.getTitle();
			rows[i][1] = video.getUrl();
			rows[i][2] = video.getTags();
		}

		JTable table = new JTable(rows, columns);

		Object[] options = { "Volver", "Finalizar" };
		int videoListPane = JOptionPane.showOptionDialog(null, new JScrollPane(table), "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (videoListPane == 0) {
			// Abrir la ventana de bienvenida si se pulsa "Volver"
			@SuppressWarnings("unused")
			WelcomeWindow welcome = new WelcomeWindow(user);
		} else if (videoListPane == 1) {
			// Cerrar el programa si se pulsa " Finalizar"
			System.exit(0);
		}
	}
}
