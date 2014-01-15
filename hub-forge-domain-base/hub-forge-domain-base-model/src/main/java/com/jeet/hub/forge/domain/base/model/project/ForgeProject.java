/**
* @(#) ForgeProject.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 30 avr. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.jeet.hub.domain.base.model.component.technical.SoftwareProject;
import com.jeet.hub.forge.domain.base.model.ForgeInstance;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;


/**
 * Defines a forge project.<br/>
 * A forge project is deployed on an instance.
 * 
 * @author JF LARTAUD
 */
@Entity
@DiscriminatorValue("ForgeProject")
public class ForgeProject extends SoftwareProject {
	
	private static final long serialVersionUID = -4193958542860326944L;
	
	/**
	 * Instance where is deployed the project
	 */
	private ForgeInstance instance;
	
	/**
	 * Versions of the project.
	 */
	private Set<ForgeProjectVersion> versions;
	
	/**
	 * Main version (master, trunk branches)
	 */
	private ForgeProjectVersion masterVersion;
	
	/**
	 * @return the instance
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "INSTANCE_ID")
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
	 * @return the versions
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<ForgeProjectVersion> getVersions() {
		return versions;
	}
	
	/**
	 * @param versions the versions to set
	 */
	public void setVersions(Set<ForgeProjectVersion> versions) {
		this.versions = versions;
	}
	
	/**
	 * @return the masterVersion
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MASTER_VERSION_ID")
	public ForgeProjectVersion getMasterVersion() {
		return masterVersion;
	}

	/**
	 * @param masterVersion the masterVersion to set
	 */
	public void setMasterVersion(ForgeProjectVersion masterVersion) {
		this.masterVersion = masterVersion;
	}
}