/**
 * 
 */
package com.jeet.hub.forge.domain.base.model.configuration;

import java.beans.Transient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Sebastien
 * 
 */
@Entity
@DiscriminatorValue("StringConfigurationElement")
public class StringConfigurationElement extends ConfigurationElement {

	private String stringValue;

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @param stringValue
	 *            the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeet.hub.forge.domain.base.model.configuration.ConfigurationElement
	 * #getValue()
	 */
	@Override
	@Transient
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
