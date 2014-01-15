/**
* @(#) Forge.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 30 avr. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;



/**
 * Defines a forge.<br/>
 * A forge has a management interface and a few tools instances
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_forge")
@javax.persistence.SequenceGenerator(name = "s_hub_forge", sequenceName = "s_hub_forge", allocationSize = 1)
public class Forge extends AbstractBaseSequenceIdJeetObject {
	
	private static final long serialVersionUID = 2444376706561038231L;
	
	/**
	 * Identifier
	 */
	private Long id;
	
	/**
	 * Forge Name
	 */
	private String name;
	
	/**
	 * Tools instance that compound the forge
	 */
	private Set<ForgeInstance> instances;

	/*
	 * (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_forge")
	public Long getId() {
		return id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the instances
	 */
	@OneToMany(mappedBy = "forge", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<ForgeInstance> getInstances() {
		return instances;
	}
	
	/**
	 * @param instances the instances to set
	 */
	public void setInstances(Set<ForgeInstance> instances) {
		this.instances = instances;
	}


}
