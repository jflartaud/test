/**
* @(#) ForgeServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 mai 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl;


import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.forge.domain.base.model.Forge;
import com.jeet.hub.forge.domain.base.service.api.ForgeService;
import com.jeet.hub.forge.domain.base.service.impl.repository.ForgeRepository;

/**
 * Entity service implementation for {@link Forge}
 * 
 * @author JF LARTAUD
 */
public class ForgeServiceImpl extends AbstractBaseEntityService<Forge, Long> implements ForgeService {
	
	private ForgeRepository forgeRepository;
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<Forge, Long> getCrudRepository() {
		return forgeRepository;
	}
	
	/**
	 * @return the forgeRepository
	 */
	public ForgeRepository getForgeRepository() {
		return forgeRepository;
	}
	
	/**
	 * @param forgeRepository the forgeRepository to set
	 */
	public void setForgeRepository(ForgeRepository forgeRepository) {
		this.forgeRepository = forgeRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.ForgeService#findByForgeInstance(java.lang.Long)
	 */
	@Override
	public Forge findByForgeInstance(Long forgeInstanceId) {
		return forgeRepository.findByForgeInstance(forgeInstanceId);
	}
}
