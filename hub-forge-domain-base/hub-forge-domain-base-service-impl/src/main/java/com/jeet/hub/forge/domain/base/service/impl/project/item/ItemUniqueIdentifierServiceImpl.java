/**
* @(#) ItemUniqueIdentifierServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 26 sept. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.item;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.forge.domain.base.model.project.item.ItemUniqueIdentifier;
import com.jeet.hub.forge.domain.base.service.api.project.item.ItemUniqueIdentifierService;
import com.jeet.hub.forge.domain.base.service.impl.project.item.repository.ItemUniqueIdentifierRepository;

/**
 * @author JF LARTAUD
 *
 */
public class ItemUniqueIdentifierServiceImpl extends AbstractBaseEntityService<ItemUniqueIdentifier, Long> implements
		ItemUniqueIdentifierService {
	
	private ItemUniqueIdentifierRepository itemUniqueIdentifierRepository;

	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<ItemUniqueIdentifier, Long> getCrudRepository() {
		return itemUniqueIdentifierRepository;
	}
	
	/**
	 * @return the itemUniqueIdentifierRepository
	 */
	public ItemUniqueIdentifierRepository getItemUniqueIdentifierRepository() {
		return itemUniqueIdentifierRepository;
	}
	
	/**
	 * @param itemUniqueIdentifierRepository the itemUniqueIdentifierRepository to set
	 */
	public void setItemUniqueIdentifierRepository(ItemUniqueIdentifierRepository itemUniqueIdentifierRepository) {
		this.itemUniqueIdentifierRepository = itemUniqueIdentifierRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.domain.scm.service.api.activity.item.ItemUniqueIdentifierService#findByPathAndProjectVersion
	 * (java.lang.String, java.lang.Long, java.util.Date)
	 */
	@Override
	public ItemUniqueIdentifier findByPathAndProjectVersion(String path, Long projectVersionId, Date maxDate) {
		return itemUniqueIdentifierRepository.findByPathAndProjectVersionId("%" + path, projectVersionId, maxDate);
	}
	

}
