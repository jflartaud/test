/**
* @(#) ForgeProjectModule.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 22 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.jeet.hub.domain.base.model.component.technical.TechnicalComponent;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;

/**
 * Module within a forge project module
 * 
 * @author JF LARTAUD
 */
@Entity
@DiscriminatorValue("ForgeProjectModule")
public class ForgeProjectModule extends TechnicalComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4767422792155415157L;
	
	/**
	 * Root Component
	 */
	private TechnicalComponent rootComponent;
	
	/**
	 * Parent component
	 */
	private TechnicalComponent parentComponent;
	
	/**
	 * Versions on which the module is deployed
	 */
	private Set<ForgeProjectVersion> versions;
	
	/**
	 * @return the rootComponent
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROOT_COMPONENT_ID")
	public TechnicalComponent getRootComponent() {
		return rootComponent;
	}
	
	/**
	 * @param rootComponent the rootComponent to set
	 */
	public void setRootComponent(TechnicalComponent rootComponent) {
		this.rootComponent = rootComponent;
	}
	
	/**
	 * @return the parentComponent
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_COMPONENT_ID")
	public TechnicalComponent getParentComponent() {
		return parentComponent;
	}
	
	/**
	 * @param parentComponent the parentComponent to set
	 */
	public void setParentComponent(TechnicalComponent parentComponent) {
		this.parentComponent = parentComponent;
	}
	
	/**
	 * @return the versions
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "t_hub_prj_version_module", joinColumns = { @JoinColumn(name = "MODULE_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "VERSION_ID", referencedColumnName = "ID") })
	public Set<ForgeProjectVersion> getVersions() {
		return versions;
	}
	
	/**
	 * @param versions the versions to set
	 */
	public void setVersions(Set<ForgeProjectVersion> versions) {
		this.versions = versions;
	}
	
	
}
