package com.sonos.smapi.model.presntationMap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * For each match there is a list of ratings
 * A rating maps to a button/icon that is available for the current matched state.
 * @author keith.corbin
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Rating {
	//StringId="UNSTAR_TRACK" AutoSkip="NEVER" OnSuccessStringId="SUCCESS_UNSTAR"
	/**
	 * The id of the rating the match propName and rating id must be a unique combination.
	 */
	private String id;
	
	/**
	 * THe id of the string in the strings.xml file to use for mouse over
	 */
	private String stringId;
	
	
	/**
	 * Defines the autoskip behvaior of the icon
	 */
	private String autoSkip;
	
	
	/**
	 * The string to display when the icon is clicked and rating the item succeeds
	 */
	private String onSuccessStringId;
	
	/**
	 * A collection of icons to display 1 for each controller.
	 */
	private List<Icon> icons;

	/**
	 * A placeholder for the name of the icon image...not included in the xml
	 * 
	 */
	@XmlTransient
	private String iconName;
	
	public Rating(){
		
	}
	public Rating(String id, String stringId, String autoSkip, String onSuccessString, String icon){
		this.setAutoSkip(autoSkip);
		this.setId(stringId);
		this.setId(id);
		this.setOnSuccessStringId(onSuccessString);
		this.setIconName(icon);
	}
	@XmlAttribute(name="Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name="StringId")
	public String getStringId() {
		return stringId;
	}

	public void setStringId(String stringId) {
		this.stringId = stringId;
	}

	@XmlAttribute(name="AutoSkip")
	public String getAutoSkip() {
		return autoSkip;
	}

	public void setAutoSkip(String autoSkip) {
		this.autoSkip = autoSkip;
	}

	@XmlAttribute(name="OnSuccessStringId")
	public String getOnSuccessStringId() {
		return onSuccessStringId;
	}

	public void setOnSuccessStringId(String onSuccessStringId) {
		this.onSuccessStringId = onSuccessStringId;
	}

	@XmlElement(name="Icon")
	public List<Icon> getIcons() {
		return icons;
	}

	public void setIcons(List<Icon> icons) {
		this.icons = icons;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

}
