package mx.yellowme.model;

/**
 * Created by javikin on 7/4/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("fields")
	@Expose
	private Fields fields;
	@SerializedName("createdTime")
	@Expose
	private String createdTime;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Movie() {
	}

	/**
	 *
	 * @param id
	 * @param createdTime
	 * @param fields
	 */
	public Movie(String id, Fields fields, String createdTime) {
		this.id = id;
		this.fields = fields;
		this.createdTime = createdTime;
	}

	/**
	 *
	 * @return
	 * The id
	 */
	public String getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 * The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 * The fields
	 */
	public Fields getFields() {
		return fields;
	}

	/**
	 *
	 * @param fields
	 * The fields
	 */
	public void setFields(Fields fields) {
		this.fields = fields;
	}

	/**
	 *
	 * @return
	 * The createdTime
	 */
	public String getCreatedTime() {
		return createdTime;
	}

	/**
	 *
	 * @param createdTime
	 * The createdTime
	 */
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}


}