package com.sonos.smapi.model.presntationMap;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * An Icon as listed in the presentation map
 * @author keith.corbin
 *
 */
public class Icon {

	/**
	 * Which controller this is an icon for (icr, acr, wdcr, mdcr, pcdcr, macdcr, cr200)
	 */
	private String controller;
	
	/**
	 * When the icon was last updated.  THis needs to be updated if the icon is changed or a new icon wil not be downloaded
	 */
	private String LastModified;
	
	
	/**
	 * The uri to the icon.
	 */
	private String Uri;
	
	public Icon(){
		
	}
	
	public Icon(String uri){
		this.setUri(uri);
	}
	
	@XmlAttribute(name="Controller")
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	
	@XmlAttribute(name="LastModified")
	public String getLastModified() {
		return LastModified;
	}
	public void setLastModified(String lastModified) {
		LastModified = lastModified;
	}
	
	@XmlAttribute(name="Uri")
	public String getUri() {
		return Uri;
	}
	public void setUri(String uri) {
		Uri = uri;
	}
}
