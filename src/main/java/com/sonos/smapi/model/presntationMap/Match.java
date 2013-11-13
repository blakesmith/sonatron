package com.sonos.smapi.model.presntationMap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * A match tag is how the controller determines the presentation settings to display.  
 * A track needs to match having the dynamic property name and property value.
 * @author keith.corbin
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Match {
	
	
	/**
	 * The name of the property
	 */
	private String propName;
	
	/**
	 * The value of the prpperty
	 */
	private String value;
	
	private List<Rating> ratings;
	
	private List<MenuItem> menuItems;
	
	@XmlAttribute(name="propname")
	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	@XmlAttribute(name="value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlElementWrapper(name="Ratings")
	@XmlElement(name="Rating")
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	@XmlElementWrapper(name="MenuItemOverrides")
	@XmlElement(name="MenuItem")
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
