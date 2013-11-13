package com.sonos.smapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An object representation of a rating
 * @author keith.corbin
 *
 */
@Entity
@Table(name="ratings")
public class Rating implements Serializable {

	private static final long serialVersionUID = -2595028416240443146L;
	
	/**
	 * The primary key of the ratings table 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/**
	 * the numerical value of the rating.
	 */
	@Column(name="rating")
	private int rating;
	
	/**
	 * The user id (maps to session id)
	 */
	@Column(name="usergid")
	private String userGid;
	
	/**
	 * The id of the track
	 */
	@Column(name="trackId")
	private int trackId;
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return
	 */
	public String getUserGid() {
		return userGid;
	}

	/**
	 * @param userGid
	 */
	public void setUserGid(String userGid) {
		this.userGid = userGid;
	}

	/**
	 * @return
	 */
	public int getTrackId() {
		return trackId;
	}

	/**
	 * @param trackId
	 */
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

}
