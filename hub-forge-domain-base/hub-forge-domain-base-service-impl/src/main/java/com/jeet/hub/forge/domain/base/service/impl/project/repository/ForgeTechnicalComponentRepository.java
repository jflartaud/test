/**
* @(#) ForgeTechnicalComponentRepository.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 22 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.repository;

import org.springframework.data.jpa.repository.Query;

import com.jeet.domain.base.service.repository.jpa.JeetRepository;
import com.jeet.hub.domain.base.model.component.technical.TechnicalComponent;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeTechnicalComponentRepository extends JeetRepository<TechnicalComponent, Long> {
	
	/**
	 * Get the parent component from a forge project module
	 * 
	 * @param key
	 * @param projectId
	 * @return
	 */
	@Query("select m.parentComponent from ForgeProjectModule m where m.id=(?1)")
	TechnicalComponent findParentComponent(Long id);

	/**
	 * Get the component by its key
	 * 
	 * @param key
	 * @param projectId
	 * @return
	 */
	@Query("select t from TechnicalComponent t where t.key=(?1)")
	TechnicalComponent findByKey(String key);
}
