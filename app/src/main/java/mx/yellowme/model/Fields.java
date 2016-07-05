package mx.yellowme.model;

/**
 * Created by javikin on 7/4/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Fields {

	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Description")
	@Expose
	private String description;
	@SerializedName("Photos")
	@Expose
	private List<Photo> photos = new ArrayList<Photo>();
	@SerializedName("Actors")
	@Expose
	private List<String> actors = new ArrayList<String>();
	@SerializedName("Director")
	@Expose
	private List<String> director = new ArrayList<String>();
	@SerializedName("Genre")
	@Expose
	private List<String> genre = new ArrayList<String>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Fields() {
	}

	/**
	 *
	 * @param genre
	 * @param photos
	 * @param description
	 * @param name
	 * @param actors
	 * @param director
	 */
	public Fields(String name, String description, List<Photo> photos, List<String> actors, List<String> director, List<String> genre) {
		this.name = name;
		this.description = description;
		this.photos = photos;
		this.actors = actors;
		this.director = director;
		this.genre = genre;
	}

	/**
	 *
	 * @return
	 * The name
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name
	 * The Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return
	 * The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *
	 * @param description
	 * The Description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *
	 * @return
	 * The photos
	 */
	public List<Photo> getPhotos() {
		return photos;
	}

	/**
	 *
	 * @param photos
	 * The Photos
	 */
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	/**
	 *
	 * @return
	 * The actors
	 */
	public List<String> getActors() {
		return actors;
	}

	/**
	 *
	 * @param actors
	 * The Actors
	 */
	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	/**
	 *
	 * @return
	 * The director
	 */
	public List<String> getDirector() {
		return director;
	}

	/**
	 *
	 * @param director
	 * The Director
	 */
	public void setDirector(List<String> director) {
		this.director = director;
	}

	/**
	 *
	 * @return
	 * The genre
	 */
	public List<String> getGenre() {
		return genre;
	}

	/**
	 *
	 * @param genre
	 * The Genre
	 */
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}


}
