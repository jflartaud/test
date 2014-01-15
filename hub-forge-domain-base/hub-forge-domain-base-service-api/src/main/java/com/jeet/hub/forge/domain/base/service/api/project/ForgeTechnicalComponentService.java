/**
* @(#) ForgeTechnicalComponentService.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 22 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api.project;

import org.springframework.transaction.annotation.Transactional;

import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.domain.base.model.component.technical.TechnicalComponent;

/**
 * Service to read information on technical components
 * 
 * @author JF LARTAUD
 */
public interface ForgeTechnicalComponentService extends EntityService<TechnicalComponent, Long> {
	
	/**
	 * Get the parent component from a forge project module
	 * 
	 * @param key
	 * @param projectId
	 * @return
	 */
	TechnicalComponent findParentComponent(Long id);
	
	/**
	 * Get the component by its key
	 * 
	 * @param key
	 * @param projectId
	 * @return
	 */
	TechnicalComponent findByKey(String key);
	
	/**
	 * Build a path from a key.
	 * 
	 * @param key
	 * @param projectId
	 * @return
	 */
	@Transactional
	String buildPathFromKey(String key);
}
