/**
 * 
 */
package com.jeet.hub.forge.domain.base.model.configuration;

import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.beans.Transient;
import java.util.HashMap;

/**
 * @author Sebastien
 *
 */
@Table(name = "t_hub_forge_configItem")
@javax.persistence.SequenceGenerator(name = "s_hub_forge_configItem", sequenceName = "s_hub_forge_configItem", allocationSize = 1)
@javax.persistence.Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@javax.persistence.DiscriminatorColumn(name = "subclass_disc")
public abstract  class ConfigurationItem {

	private String name;

}
