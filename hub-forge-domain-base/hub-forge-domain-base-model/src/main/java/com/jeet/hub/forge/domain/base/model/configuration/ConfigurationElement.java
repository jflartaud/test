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
@DiscriminatorValue("configurationElement")
public abstract class ConfigurationElement<T> extends ConfigurationItem {

	@Transient
	public abstract Object getValue();

	public enum Resolution {
		STATIC, INSTANCE, RUNTIME
	}

	
}
