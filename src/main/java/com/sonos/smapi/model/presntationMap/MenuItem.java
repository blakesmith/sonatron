package com.sonos.smapi.model.presntationMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class MenuItem {
/**
 * MenuItem="AddTrackToFavorites"
        StringId="SAVE_TRACK"
	InProgressStringId="SAVE_TRACK_DURING"
	SuccessStringId="SAVE_TRACK_SUCCESS"
        FailureStringId="SAVE_TRACK_FAILURE" />
 */
	private String menuItem;
	private String inProgressStringId;
	private String successStringId;
	private String failureStringId;
	private String stringId;
	private String promptStringId;
	
	@XmlAttribute(name="MenuItem")
	public String getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}
	
	@XmlAttribute(name="InProgressStringId")
	public String getInProgressStringId() {
		return inProgressStringId;
	}
	public void setInProgressStringId(String inProgressStringId) {
		this.inProgressStringId = inProgressStringId;
	}
	
	@XmlAttribute(name="SuccessStringId")
	public String getSuccessStringId() {
		return successStringId;
	}
	public void setSuccessStringId(String successStringId) {
		this.successStringId = successStringId;
	}
	
	@XmlAttribute(name="FailureStringId")
	public String getFailureStringId() {
		return failureStringId;
	}
	public void setFailureStringId(String failureStringId) {
		this.failureStringId = failureStringId;
	}
	
	@XmlAttribute(name="StringId")
	public String getStringId() {
		return stringId;
	}
	public void setStringId(String stringId) {
		this.stringId = stringId;
	}
	
	@XmlAttribute(name="PromptStringId")
	public String getPromptStringId() {
		return promptStringId;
	}
	public void setPromptStringId(String promptStringId) {
		this.promptStringId = promptStringId;
	}
	
	
}
