/**
* @(#) ForgeProjectCodeActivityItem.java - Jeet Hub Forge
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

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Index;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;

/**
 * Defines an item that is a part of a project.<br/>
 * An item can be a file or a directory.<br/>
 * The items on the tree are placed flat but they kept a reference on their parent.
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_activity_item")
@javax.persistence.SequenceGenerator(name = "s_hub_activity_item", sequenceName = "s_hub_activity_item", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "subclass_disc")
@DiscriminatorValue("ForgeProjectCodeActivityItem")
public class ForgeProjectCodeActivityItem extends AbstractBaseSequenceIdJeetObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -210268342330652365L;
	
	/**
	 * Identifier
	 */
	private Long id;
	
	/**
	 * Name (simple name of the item)
	 */
	private String name;
	
	/**
	 * Complete path of the item
	 */
	private String path;
	
	/**
	 * Defines if the file is a directory
	 */
	private Boolean directory;
	
	/**
	 * Action on the item
	 */
	private CodeItemActionType action;

	/**
	 * Item unique identifier
	 */
	private ItemUniqueIdentifier itemIdentifier;

	/**
	 * Date of the revision
	 */
	private Date versionDate;
	
	/**
	 * Defines the parent pack.
	 */
	private ForgeProjectCodeActivityPack pack;

	/*
	 * (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_activity_item")
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * @return the directory
	 */
	public Boolean getDirectory() {
		return directory;
	}
	
	/**
	 * @param directory the directory to set
	 */
	public void setDirectory(Boolean directory) {
		this.directory = directory;
	}

	/**
	 * @return the itemIdentifier
	 */
	@Index(name = "I_ITEM_UNIQUE_ID")
	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ITEM_UNIQUE_ID")
	public ItemUniqueIdentifier getItemIdentifier() {
		return itemIdentifier;
	}
	
	/**
	 * @param itemIdentifier the itemIdentifier to set
	 */
	public void setItemIdentifier(ItemUniqueIdentifier itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}

	/**
	 * @return the action
	 */
	@Enumerated(EnumType.ORDINAL)
	public CodeItemActionType getAction() {
		return action;
	}
	
	/**
	 * @param action the action to set
	 */
	public void setAction(CodeItemActionType action) {
		this.action = action;
	}
	
	/**
	 * @return the versionDate
	 */
	@Index(name = "I_ITEM_VERSION_DATE")
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
	 * @return the pack
	 */
	@Index(name = "I_ITEM_PACK_ID")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PACK_ID")
	public ForgeProjectCodeActivityPack getPack() {
		return pack;
	}
	
	/**
	 * @param pack the pack to set
	 */
	public void setPack(ForgeProjectCodeActivityPack pack) {
		this.pack = pack;
	}

}
