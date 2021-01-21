package com.dominivideos.persistence;

import java.util.ArrayList;
import java.util.List;

import com.dominivideos.domain.User;
import com.dominivideos.domain.Video;

/**
 * 
 * Gestiona la creaci�n de nuevos usuarios y sus videos
 * 
 * Contiene los m�todos necesarios para consultar tanto la lista de usuarios
 * como la de videos de un usuario, as� como para a�adir elementos a esas listas
 * 
 */

public class Repository {

	private static List<User> users = new ArrayList<>();

	public Repository() {

	}

	/**
	 * Recuperar una lista de todos los usuarios
	 * 
	 * @return lista de usuarios
	 */
	public List<User> getUsers() {
		return new ArrayList<>(users);
	}

	/**
	 * A�adir un nuevo usuario al listado de usuarios
	 * 
	 * @param user, objeto de tipo User a a�adir a la lista
	 * @throws Exception, en caso de usuario vac�o
	 * 
	 */
	public void addUser(User user) throws Exception {
		if (user == null) {
			throw new Exception();
		}
		users.add(user);
	}

	/**
	 * M�todo que recorre la lista de usuarios y cuando encuentra el que ha iniciado
	 * sesi�n recupera su listado de videos
	 * 
	 * @param userLoggedIn, objeto de tipo User del que obtener los videos
	 * @return la lista de videos del usuario
	 */
	public List<Video> getUserVideos(User userLoggedIn) {
		List<Video> userVideos = new ArrayList<>();
		for (User user : getUsers()) {
			if (user.getName().equals(userLoggedIn.getName())
					&& user.getPassword().equals(userLoggedIn.getPassword())) {
				userVideos.addAll(user.getVideos());
				break;
			}
		}

		return userVideos;
	}

	/**
	 * A�adir un nuevo video al listado de videos de un determinado usuario
	 * 
	 * @param user, objeto de tipo User al que a�adir el video
	 * @param video, objeto de tipo Video a a�adir a la lista
	 */
	public void addVideo(User user, Video video) {
		user.addVideo(video);
	}

}
