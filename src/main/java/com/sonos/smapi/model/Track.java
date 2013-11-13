package com.sonos.smapi.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The object representation of a track
 * @author keith.corbin
 *
 */
@Entity
@Table(name="track")
public class Track implements Serializable {


	private static final long serialVersionUID = 2011423450724643477L;
	
	/**
	 * The primary key of the track table
	 */
	@Id
	@Column(name="id")
	private int id;
	
	/**
	 * the gid of the track (from Music Brainz)
	 */
	@Column(name="gid")
	private String gid;
	
	/**
	 *  The track number (position on the album)
	 */
	@Column(name="idx")
	private int trackNumber;
	
	/**
	 * THe track title/
	 */
	@Column(name="title")
	private String title;
	
	/**
	 * 
	 */
	@Column(name="duration")
	private int length;
	
	/**
	 * The length of the track in seconds
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="albumid")
	private Album album;
	
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
	public String getGid() {
		return gid;
	}
	/**
	 * @param gid
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}

	/**
	 * @return
	 */
	public int getTrackNumber() {
		return trackNumber;
	}
	/**
	 * @param trackNumber
	 */
	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}
	/**
	 * This method does a conversion to UTF-8 encoding to make sure foreign characters in the title are handles appropriately.
	 * @return
	 */
	public String getTitle() {
		try {
			return 	new String( title.getBytes(), "UTF-8" );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ENCODING ERROR";
		}
	}
	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}
}
