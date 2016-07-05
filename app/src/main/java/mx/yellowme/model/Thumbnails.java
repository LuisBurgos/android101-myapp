package mx.yellowme.model;

/**
 * Created by javikin on 7/4/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {

	@SerializedName("small")
	@Expose
	private Small small;
	@SerializedName("large")
	@Expose
	private Large large;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Thumbnails() {
	}

	/**
	 *
	 * @param small
	 * @param large
	 */
	public Thumbnails(Small small, Large large) {
		this.small = small;
		this.large = large;
	}

	/**
	 *
	 * @return
	 * The small
	 */
	public Small getSmall() {
		return small;
	}

	/**
	 *
	 * @param small
	 * The small
	 */
	public void setSmall(Small small) {
		this.small = small;
	}

	/**
	 *
	 * @return
	 * The large
	 */
	public Large getLarge() {
		return large;
	}

	/**
	 *
	 * @param large
	 * The large
	 */
	public void setLarge(Large large) {
		this.large = large;
	}

}