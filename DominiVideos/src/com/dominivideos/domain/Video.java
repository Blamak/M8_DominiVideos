package com.dominivideos.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * El constructor crea un video con su
 * url, título y una lista de tags como atributos.
 *  
 * El método getTags() retorna una cuerda con
 * cada uno de los tags de un determinado video,
 * separados por una coma
 *
 */
public class Video {
	
	private String url;
	private String title;
	private List<String> tags = new ArrayList<>();
	
	
	public Video(String url, String title, List<String> tags) {
		this.url = url;
		this.title = title;
		this.tags = tags;
	}

	public String getUrl() {
		return this.url;
	}

	public String getTitle() {
		return this.title;
	}

	public String getTags() {
		String tagsText = "";
		for (String tag : this.tags) {
			// Agregar un punto si es el último tag
			if (tags.indexOf(tag) == this.tags.size()-1) {
				tagsText += tag + "."; 
			} else {
				// Agregar una coma
				tagsText += tag + ", "; 				
			}
		}
		return tagsText;
	}
		

}
