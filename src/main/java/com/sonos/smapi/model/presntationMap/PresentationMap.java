package com.sonos.smapi.model.presntationMap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * A presentation map object.
 * @author keith.corbin
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class PresentationMap {
	
	/**
	 * A presentation map type, can be: NowPlayingRatings or ListOverlays
	 */
	private String type;
	
	/**
	 * A list of matches
	 */
	private List<Match> matches;
	
	@XmlElement(name="Match")
	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	@XmlAttribute(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
