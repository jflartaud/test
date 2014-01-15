/**
* @(#) CodeActivityItemHistory.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 25 sept. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;

/**
 * Represent a unique identifier for the {@link ForgeProjectCodeActivityItem} objects to identify same objets
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_activity_item_id")
@javax.persistence.SequenceGenerator(name = "s_hub_activity_item_id", sequenceName = "s_hub_activity_item_id", allocationSize = 1)
public class ItemUniqueIdentifier extends AbstractBaseSequenceIdJeetObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 454062240418367062L;

	private Long id;
	
	
	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_activity_item_id")
	public Long getId() {
		return this.id;
	}
	
	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
