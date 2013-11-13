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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The object represenatin of an artist
 * @author keith.corbin
 *
 */
@Entity
@Table(name="artist")
public class Artist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3652657630426010368L;
	
	/**
	 * The artist table primary key
	 */
	@Id
	@Column(name="id")
	private int id;
	
	/**
	 * THe unique id for the artist (from music brainz)
	 */
	@Column(name="gid")
	private String gid;
	
	/**
	 * The artist's name
	 */
	@Column(name="name")
	private String name;
	
	/** 
	 *  The artist's albums
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="artistid")
	private Set<Album> albums;
	
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
	 * The get name method contains logic to make sure the name is returned in UTF-8 encoding.
	 * @return the name
	 */
	public String getName() {
		try {
			return 	new String( name.getBytes(), "UTF-8" );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ENCODING ERROR";
		}
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the artist's albums
	 */
	public Set<Album> getAlbums() {
		return albums;
	}
	/**
	 * @param albums
	 */
	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}
