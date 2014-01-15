/**
* @(#) ForgeProjectVersion.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 10 oct. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.version;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;


/**
 * Defines a version for a forge project
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_prj_version")
@SequenceGenerator(name = "s_hub_prj_version", sequenceName = "s_hub_prj_version", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "subclass_disc")
@DiscriminatorValue("ForgeProjectVersion")
public class ForgeProjectVersion extends AbstractBaseSequenceIdJeetObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 580052162512570436L;
	
	/**
	 * Identifier
	 */
	private Long id;
	
	/**
	 * Defines the version name
	 */
	private String version;

	/**
	 * Owner forge project
	 */
	private ForgeProject project;
	
	/**
	 * Version date
	 */
	private Date versionDate;
	
	/**
	 * Master version
	 */
	private Boolean master;
	
	/**
	 * Defines the complete version name
	 */
	private String completeName;
	
	/**
	 * Deleted
	 */
	private Boolean deleted = Boolean.FALSE;

	/**
	 * Previous version
	 */
	private ForgeProjectVersion previousVersion;

	/*
	 * (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_prj_version")
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * @return the project
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	public ForgeProject getProject() {
		return project;
	}
	
	/**
	 * @param project the project to set
	 */
	public void setProject(ForgeProject project) {
		this.project = project;
	}
	
	/**
	 * @return the previousVersion
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "previous_version_id")
	public ForgeProjectVersion getPreviousVersion() {
		return previousVersion;
	}
	
	/**
	 * @param previousVersion the previousVersion to set
	 */
	public void setPreviousVersion(ForgeProjectVersion previousVersion) {
		this.previousVersion = previousVersion;
	}

	/**
	 * @return the versionDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getVersionDate() {
		return versionDate;
	}
	
	/**
	 * @param versionDate the versionDate to set
	 */
	public void setVersionDate(Date versionDate) {
		this.versionDate = versionDate;
	}

	/**
	 * @return the master
	 */
	public Boolean getMaster() {
		return master;
	}
	
	/**
	 * @param master the master to set
	 */
	public void setMaster(Boolean master) {
		this.master = master;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}
	
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the completeName
	 */
	public String getCompleteName() {
		return completeName;
	}
	
	/**
	 * @param completeName the completeName to set
	 */
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	
	@Transient
	public String getType() {
		return getClass().getName();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ForgeProjectVersion [version=" + version + ", completeName=" + completeName + ", previousVersion="
				+ previousVersion + "]";
	}

}
