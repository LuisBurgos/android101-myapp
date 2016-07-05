package mx.yellowme.model;

/**
 * Created by javikin on 7/4/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("filename")
	@Expose
	private String filename;
	@SerializedName("size")
	@Expose
	private long size;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("thumbnails")
	@Expose
	private Thumbnails thumbnails;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Photo() {
	}

	/**
	 *
	 * @param id
	 * @param filename
	 * @param thumbnails
	 * @param type
	 * @param url
	 * @param size
	 */
	public Photo(String id, String url, String filename, long size, String type, Thumbnails thumbnails) {
		this.id = id;
		this.url = url;
		this.filename = filename;
		this.size = size;
		this.type = type;
		this.thumbnails = thumbnails;
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
	 * The url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 *
	 * @param url
	 * The url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 *
	 * @return
	 * The filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 *
	 * @param filename
	 * The filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 *
	 * @return
	 * The size
	 */
	public long getSize() {
		return size;
	}

	/**
	 *
	 * @param size
	 * The size
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 *
	 * @return
	 * The type
	 */
	public String getType() {
		return type;
	}

	/**
	 *
	 * @param type
	 * The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *
	 * @return
	 * The thumbnails
	 */
	public Thumbnails getThumbnails() {
		return thumbnails;
	}

	/**
	 *
	 * @param thumbnails
	 * The thumbnails
	 */
	public void setThumbnails(Thumbnails thumbnails) {
		this.thumbnails = thumbnails;
	}


}