package com.dominivideos.application;

import java.util.List;

import com.dominivideos.domain.User;
import com.dominivideos.domain.Video;
import com.dominivideos.persistence.Repository;

/**
 * 
 * Permite desacoplar la creación de nuevos objetos
 * de tipo Video
 * 
 * Mediante un método de la clase Repository de la capa persistence cada nuevo
 * video para un determinado usuario queda almacenado en una lista
 *
 */

public class VideosController {

	private Repository repository = new Repository();

	public VideosController() {

	}

	public void createVideos(User user, String url, String title, List<String> tags) {
		Video newVideo = new Video(url, title, tags);
		repository.addVideo(user, newVideo);
	}
}
