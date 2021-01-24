package com.dominivideos.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase de la capa domain
 * 
 * El constructor crea un objeto usuario con los atributos
 * nombre, apellido, contraseña y fecha de registro.
 *  
 * Además de los getters para los atributos,
 * provee dos métodos adicionales: 
 *  - uno para obtener un listado de los videos del usuario -getVideos()-
 *  - y otro que añade un video a dicha lista -addVideo()-   
 *
 */
public class User {
	
	private String name;
	private String surname;
	private String password;
	private String registrationDate;
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private List<Video> videos = new ArrayList<Video>();
	
	public User(String name, String surname, String password, String registrationDate) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.registrationDate = dateFormat.format(new Date());
	}

		
	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getSurname() {
		return this.surname;
	}

	public String getregistrationDate() {
		return this.registrationDate;
	}

	
	public List<Video> getVideos() {
		return this.videos;
	}
 
	public void addVideo(Video video) {
		this.videos.add(video);
	}
	
}
