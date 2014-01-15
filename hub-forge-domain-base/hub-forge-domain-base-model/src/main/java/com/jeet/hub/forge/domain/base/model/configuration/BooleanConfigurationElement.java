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
@DiscriminatorValue("booleanConfigurationElement")
public class BooleanConfigurationElement extends ConfigurationElement {
	/**
	 * Boolean Value
	 */
	private Boolean booleanValue;

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
		return getBooleanValue();
	}

	/**
	 * @return the booleanValue
	 */
	public Boolean getBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
}
