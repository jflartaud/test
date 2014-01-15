/**
* @(#) ForgeService.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 mai 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api;


import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.forge.domain.base.model.Forge;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeService extends EntityService<Forge, Long> {
	
	/**
	 * Find the forge associated to a forge instance
	 * 
	 * @param forgeInstanceId
	 * @return
	 */
	Forge findByForgeInstance(Long forgeInstanceId);

}
