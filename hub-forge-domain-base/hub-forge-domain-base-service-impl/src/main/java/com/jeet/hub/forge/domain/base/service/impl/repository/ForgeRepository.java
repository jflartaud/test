/**
* @(#) ForgeRepository.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 mai 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.repository;


import org.springframework.data.jpa.repository.Query;

import com.jeet.domain.base.service.repository.jpa.JeetRepository;
import com.jeet.hub.forge.domain.base.model.Forge;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeRepository extends JeetRepository<Forge, Long> {
	
	/**
	 * Find the forge associated to a forge instance
	 * 
	 * @param forgeInstanceId
	 * @return
	 */
	@Query("select i.forge from ForgeInstance i where i.id=(?1)")
	Forge findByForgeInstance(Long forgeInstanceId);
}
