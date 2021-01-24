package com.dominivideos.application;

import java.util.List;

import com.dominivideos.domain.User;
import com.dominivideos.domain.Video;
import com.dominivideos.persistence.Repository;

/**
 * Clase de la capa application
 * 
 * Permite desacoplar la creación de nuevos objetos
 * de tipo User
 * 
 * Mediante los métodos de la clase Repository de la capa persistence, cada nuevo
 * usuario se almacena en una lista -createUser()-, y se recupera el listado de videos de un
 * usuario en particular -listUserVideos-
 *
 */

public class UsersController {

	private Repository repository = new Repository();

	public UsersController() {

	}

	public void createUser(String name, String surname, String password, String registerDate) throws Exception {
		User newUser = new User(name, surname, password, registerDate);
		repository.addUser(newUser);
	}

	public List<Video> listUserVideos(User user) {
		return repository.getUserVideos(user);
	}

}
