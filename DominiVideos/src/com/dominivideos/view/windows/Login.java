package com.dominivideos.view.windows;

import java.util.List;

import com.dominivideos.domain.User;

/**
 * Clase de la capa view
 * 
 * Clase para comprobar que el usuario ha intoducido los datos correctos
 * -nombre y contraseña- para loguearse.
 * 
 * Su método estático se ejecuta en la clase LoginWindowBuilder de la capa
 * view.windows.InputWindows
 *
 */
public class Login {

	public static User authenticate(String username, String password, List<User> usersList) {
		for (User user : usersList) {
			if (username.equalsIgnoreCase(user.getName()) && password.equals(user.getPassword())) {
				return user;
			}
		}

		return null;
	}
}
