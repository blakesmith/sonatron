package com.sonos.smapi.model;

/**
 * 
 * This is a helper object for the service configuration.
 * @author keith.corbin
 *
 */
public class Capabilities {
	/**
	 * An array of the service's current configuration capabilities.
	 */
	private String[] capabilities;

	/**
	 * @param capabilities
	 */
	public void setCapabilities(String[] capabilities) {
		this.capabilities = capabilities;
	}

	/**
	 * @return an array of capabilities
	 */
	public String[] getCapabilities() {
		return capabilities;
	}
}
