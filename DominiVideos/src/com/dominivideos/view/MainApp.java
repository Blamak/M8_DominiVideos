package com.dominivideos.view;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import com.dominivideos.application.UsersController;
import com.dominivideos.application.VideosController;
import com.dominivideos.domain.User;
import com.dominivideos.persistence.Repository;
import com.dominivideos.view.windows.InputWindows.LoginWindowBuilder;
import com.dominivideos.view.windows.InputWindows.WindowBuilder;
import com.dominivideos.view.windows.InputWindows.WindowDirector;

public class MainApp {

	private static UsersController userController = new UsersController();
	private static VideosController videoController = new VideosController();
	private static Repository repository = new Repository();
	private static List<User> usersList;

	public static void main(String[] args) throws Exception {
		
		// Crear usuarios:
		userController.createUser("Jimmy", "Page", "1234", "11/02/2019");
		userController.createUser("Robert", "Plant", "1234", "12/02/2019");
		userController.createUser("John", "Bonham", "1234", "13/02/2019");
		userController.createUser("JohnPaul", "Jones", "1234", "14/02/2019");

		// Crear videos para los dos primeros usuarios:
		usersList = repository.getUsers();
		videoController.createVideos(usersList.get(0), "https://www.youtube.com/watch?v=xbhCPt6PZIU", "Starway",
				Arrays.asList("rock", "blues", "Zeppelin"));
		videoController.createVideos(usersList.get(0), "https://www.youtube.com/watch?v=Is4LDQQZQ4s", "Gilmour",
				Arrays.asList("rock", "Pink Floyd"));
		videoController.createVideos(usersList.get(1), "https://www.youtube.com/watch?v=xd8AVbwB_6E", "Taurus", 
				Arrays.asList("plagiarism", "Zeppelin"));
		videoController.createVideos(usersList.get(1), "https://www.youtube.com/watch?v=2cZ_EFAmj08", "Heart",
				Arrays.asList("Bonham", "Starway", "Zeppelin")); 
		
		
		// Usando el patrón Builder construir la pantalla de inicio de sesión:
		WindowDirector director = new WindowDirector();
		WindowBuilder builder = new LoginWindowBuilder(usersList); 
		@SuppressWarnings("unused")
		JPanel panel = director.createJpanel(builder);

	}

}