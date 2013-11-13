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
 *  The object representation of the favorite Track
 * @author keith.corbin
 *
 */
@Entity
@Table(name="favtracks")
public class FavoriteTrack implements Serializable {


	private static final long serialVersionUID = -4237780471562628794L;

	/**
	 *  The primary key of the favorite tracks table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/**
	 * THe user id (maps to sessin id)
	 */
	@Column(name="usergid")
	private String userGid;
	
	/**
	 * The track
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="trackid")
	private Track track;
	
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
	public Track getTrack() {
		return track;
	}

	/**
	 * @param track
	 */
	public void setTrack(Track track) {
		this.track = track;
	}

}
