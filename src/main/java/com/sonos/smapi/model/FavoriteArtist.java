package com.sonos.smapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The object representation of the favorite artist
 * @author keith.corbin
 *
 */
@Entity
@Table(name="favartists")
public class FavoriteArtist implements Serializable {


	private static final long serialVersionUID = -3884319690493801667L;
	
	/**
	 *  the primary key of the favorite artist table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/**
	 * the user id (maps to session id)
	 */
	@Column(name="usergid")
	private String userGid;
	
	/**
	 * The artist
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="artistid")
	private Artist artist;
	
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
	public Artist getArtist() {
		return artist;
	}

	/**
	 * @param artist
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
