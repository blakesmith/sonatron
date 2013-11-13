package com.sonos.smapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The object reppresentation of a user
 * @author keith.corbin
 *
 */
@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = -3593051666010339330L;
	
	/**
	 * the primary key of the user table
	 */
	@Id
	@Column(name="id")
	private int id;
	
	/**
	 * The gid, this is returned as the user's session id.
	 */
	@Column(name="gid")
	private String gid;
	
	/**
	 *  The user's name
	 */
	@Column(name="username")
	private String username;
	
	/**
	 * The user's password
	 */
	@Column(name="password")
	private String password;

	/**
	 * The when the user content was updated
	 */
	@Column(name="updated")
	private int updated;

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
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public int getUpdated() {
		return updated;
	}

	public void setUpdated(int updated) {
		this.updated = updated;
	}
}
