/**
* @(#) ForgeElementService.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 mai 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.element;

import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.forge.domain.base.model.element.ForgeElement;
import com.jeet.hub.forge.domain.base.service.api.element.ForgeElementService;
import com.jeet.hub.forge.domain.base.service.impl.element.repository.ForgeElementRepository;



/**
 * Entity service implementation for {@link ForgeElement}
 * 
 * @author JF LARTAUD
 */
public class ForgeElementServiceImpl extends AbstractBaseEntityService<ForgeElement, Long> implements
        ForgeElementService {
	
	private ForgeElementRepository forgeElementRepository;

	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<ForgeElement, Long> getCrudRepository() {
		return forgeElementRepository;
	}
	
	/**
	 * @return the forgeElementRepository
	 */
	public ForgeElementRepository getForgeElementRepository() {
		return forgeElementRepository;
	}
	
	/**
	 * @param forgeElementRepository the forgeElementRepository to set
	 */
	public void setForgeElementRepository(ForgeElementRepository forgeElementRepository) {
		this.forgeElementRepository = forgeElementRepository;
	}
	

}
