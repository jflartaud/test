/**
* @(#) ForgeInstance.java - Jeet Hub Forge
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.hub.forge.domain.base.model.element.ForgeElement;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;


/**
 * Defines an instance that compound the forge. It represents a VM.<br/>
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_forge_instance")
@javax.persistence.SequenceGenerator(name = "s_hub_forge_instance", sequenceName = "s_hub_forge_instance", allocationSize = 1)
public class ForgeInstance extends AbstractBaseSequenceIdJeetObject {
	
	private static final long serialVersionUID = -6740302347162537285L;

	/**
	 * Identifier
	 */
	private Long id;
	
	/**
	 * Name
	 */
	private String name;
	
	/**
	 * Elements that are used into the instance
	 */
	private Set<ForgeElement> elements;
	
	/**
	 * Projects that are deployed on the instance
	 */
	private Set<ForgeProject> projects;
	
	/**
	 * Owner forge
	 */
	private Forge forge;

	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_forge_instance")
	public Long getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the forge
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Forge getForge() {
		return forge;
	}
	
	/**
	 * @param forge the forge to set
	 */
	public void setForge(Forge forge) {
		this.forge = forge;
	}
	
	/**
	 * @return the elements
	 */
	@OneToMany(mappedBy = "instance", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<ForgeElement> getElements() {
		return elements;
	}
	
	/**
	 * @param elements the elements to set
	 */
	public void setElements(Set<ForgeElement> elements) {
		this.elements = elements;
	}
	
	/**
	 * @return the projects
	 */
	@OneToMany(mappedBy = "instance", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<ForgeProject> getProjects() {
		return projects;
	}
	
	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Set<ForgeProject> projects) {
		this.projects = projects;
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
	
	
}
