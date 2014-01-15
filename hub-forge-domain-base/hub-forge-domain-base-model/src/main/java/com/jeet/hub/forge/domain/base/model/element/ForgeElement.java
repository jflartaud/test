/**
* @(#) ForgeElement.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 30 avr. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.element;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.hub.forge.domain.base.model.ForgeInstance;

/**
 * Defines a forge element. A forge element is a tool that is used into the forge.<br/>
 * For example, the SCM, Quality, BugTracker.<br/>
 * A forge element used all the projects of the instance.<br/>
 * We can only have on kind of element by instance. The different kinds of elements are the first level of abstraction
 * under ForgeElement.<br/>
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_forge_element")
@javax.persistence.Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@javax.persistence.DiscriminatorColumn(name = "subclass_disc")
@javax.persistence.SequenceGenerator(name = "s_hub_forge_element", sequenceName = "s_hub_forge_element", allocationSize = 1)
public class ForgeElement extends AbstractBaseSequenceIdJeetObject {
	
	private static final long serialVersionUID = 1345343254525135324L;
	
	/**
	 * Identifier
	 */
	private Long id;

	/**
	 * Configurations of the forge element
	 */
	private Map<String, String> configurations;

	/**
	 * Owner instance
	 */
	private ForgeInstance instance;
	
	/**
	 * Key of the forge element
	 */
	private String key;
	
	/**
	 * @return the id
	 */
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_forge_element")
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the configurations
	 */
	@ElementCollection
	@MapKeyColumn(name = "key")
	@Column(name = "value")
	@CollectionTable(name = "t_hub_forge_config", joinColumns = @JoinColumn(name = "element_id"))
	public Map<String, String> getConfigurations() {
		return configurations;
	}
	
	/**
	 * @param configurations the configurations to set
	 */
	public void setConfigurations(Map<String, String> configurations) {
		this.configurations = configurations;
	}

	/**
	 * @return the instance
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public ForgeInstance getInstance() {
		return instance;
	}
	
	/**
	 * @param instance the instance to set
	 */
	public void setInstance(ForgeInstance instance) {
		this.instance = instance;
	}
	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
