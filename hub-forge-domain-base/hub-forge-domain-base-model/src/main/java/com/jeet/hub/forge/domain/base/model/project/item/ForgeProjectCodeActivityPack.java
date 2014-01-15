/**
* @(#) ForgeProjectCodeActivityPack.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 26 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.item;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;

/**
 * Define a pack of activities within a project
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_activity_pack")
@SequenceGenerator(name = "s_hub_activity_pack", sequenceName = "s_hub_activity_pack", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "subclass_disc")
@DiscriminatorValue("ForgeProjectCodeActivityPack")
public class ForgeProjectCodeActivityPack extends AbstractBaseSequenceIdJeetObject {
	
	private static final long serialVersionUID = 5938036715137640842L;

	private Long id;

	/**
	 * Project on which the code activity pack is applied
	 */
	private ForgeProjectVersion projectVersion;

	/**
	 * Pack status
	 */
	private CodeActivityPackStatus status;
	
	/**
	 * Items of the pack
	 */
	private List<ForgeProjectCodeActivityItem> items;

	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_activity_pack")
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
	 * @return the projectVersion
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_VERSION_ID")
	public ForgeProjectVersion getProjectVersion() {
		return projectVersion;
	}
	
	/**
	 * @param projectVersion the projectVersion to set
	 */
	public void setProjectVersion(ForgeProjectVersion projectVersion) {
		this.projectVersion = projectVersion;
	}
	
	/**
	 * @return the status
	 */
	@Enumerated
	public CodeActivityPackStatus getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(CodeActivityPackStatus status) {
		this.status = status;
	}
	
	/**
	 * @return the items
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pack")
	@OrderBy(value = "name ASC")
	public List<ForgeProjectCodeActivityItem> getItems() {
		return items;
	}
	
	/**
	 * @param items the items to set
	 */
	public void setItems(List<ForgeProjectCodeActivityItem> items) {
		this.items = items;
	}
}
