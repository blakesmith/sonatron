package com.sonos.smapi.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * THis is the object representation of an Album
 * @author keith.corbin
 *
 */
@Entity
@Table(name="album")
public class Album implements Serializable {

	private static final long serialVersionUID = -3928784896049637049L;
	
	/**
	 * The album table's primary key
	 */
	@Id
	@Column(name="id")
	private int id;
	
	/**
	 * an album id (From MusicBrainz)
	 */
	@Column(name="gid")
	private String gid;
	
	/**
	 * The title of the Album
	 */
	@Column(name="title")
	private String title;
	
	/**
	 * The Album's artist
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="artistid")
	private Artist artist;
	
	/**
	 *  The tracks on the album
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="albumid")
	private Set<Track> tracks;
	
	/**
	 * @return the id
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
	 * @return the gid
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
	 * @return the title
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
	 * @return the artist
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
	/**
	 * @return the tracks
	 */
	public Set<Track> getTracks() {
		return tracks;
	}
	/**
	 * @param tracks
	 */
	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}
	
}
