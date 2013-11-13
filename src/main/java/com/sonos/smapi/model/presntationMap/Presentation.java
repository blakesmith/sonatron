package com.sonos.smapi.model.presntationMap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;


/**
 * THis is the outer XML element of the presentation map
 * @author keith.corbin
 *
 */
@XmlRootElement(
        name="Presentation")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class Presentation {
	
	/**
	 * A list of presentation maps
	 */
	@XmlElement(name="PresentationMap")
	private List<PresentationMap> presentationMap;

	public List<PresentationMap> getPresentationMap() {
		return presentationMap;
	}

	public void setPresentationMap(List<PresentationMap> presentationMap) {
		this.presentationMap = presentationMap;
	}
}
