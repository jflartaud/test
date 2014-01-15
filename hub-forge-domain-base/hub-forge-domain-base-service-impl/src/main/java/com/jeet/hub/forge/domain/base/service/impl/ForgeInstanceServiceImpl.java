/**
* @(#) ForgeInstanceServiceImpl.java - Jeet Hub Forge
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
import com.jeet.hub.forge.domain.base.model.ForgeInstance;
import com.jeet.hub.forge.domain.base.model.template.Template;
import com.jeet.hub.forge.domain.base.service.api.ForgeInstanceService;
import com.jeet.hub.forge.domain.base.service.impl.repository.ForgeInstanceRepository;



/**
 * Entity service implementation for {@link ForgeInstance}
 * 
 * @author JF LARTAUD
 */
public class ForgeInstanceServiceImpl extends AbstractBaseEntityService<ForgeInstance, Long> implements
        ForgeInstanceService {
	
	private ForgeInstanceRepository forgeInstanceRepository;

	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<ForgeInstance, Long> getCrudRepository() {
		return forgeInstanceRepository;
	}
	
	/**
	 * @return the forgeInstanceRepository
	 */
	public ForgeInstanceRepository getForgeInstanceRepository() {
		return forgeInstanceRepository;
	}
	
	/**
	 * @param forgeInstanceRepository the forgeInstanceRepository to set
	 */
	public void setForgeInstanceRepository(ForgeInstanceRepository forgeInstanceRepository) {
		this.forgeInstanceRepository = forgeInstanceRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.domain.base.service.api.ForgeInstanceService#getTemplate(java.lang.Long)
	 */
	@Override
	public Template getTemplate(Long forgeInstanceIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
