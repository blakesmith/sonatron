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
 * An object representation of the favorite albums
 * @author keith.corbin
 *
 */
@Entity
@Table(name="favalbums")
public class FavoriteAlbum implements Serializable {

	private static final long serialVersionUID = 77407615991980098L;

	/**
	 * teh primary key of the favorite albums table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/**
	 * the unique user id maps to sessin id.
	 */
	@Column(name="usergid")
	private String userGid;
	
	/**
	 * The album
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="albumid")
	private Album album;

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
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
}
