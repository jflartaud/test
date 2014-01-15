/**
* @(#) ForgeProjectRepository.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 mai 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.jeet.domain.base.service.repository.jpa.JeetRepository;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectRepository extends JeetRepository<ForgeProject, Long> {
	
	/**
	 * Retrieve a forge project by its technical name
	 * 
	 * @param technicalName
	 * @return
	 */
	@Query("select p from ForgeProject p where p.technicalName=(?1) and p.deleted = false")
	ForgeProject findByTechnicalName(String technicalName);
	
	/**
	 * Count by technical name
	 */
	@Query("select count(p) from ForgeProject p where lower(p.technicalName)=lower(?1) and p.instance.id=(?2) and p.deleted = false")
	long countByTechnicalName(String technicalName, Long forgeInstanceId);
	
	/**
	 * Count by name
	 */
	@Query("select count(p) from ForgeProject p where lower(p.name)=lower(?1) and p.instance.id=(?2) and p.deleted = false")
	long countByName(String name, Long forgeInstanceId);
	
	/**
	 * Find all the projects for a forge instance
	 * 
	 * @param forgeInstanceId
	 * @param pageable
	 * @return
	 */
	@Query("select p from ForgeProject p where p.instance.id=(?1) and p.deleted = false")
	Page<ForgeProject> findAllByForgeInstance(Long forgeInstanceId, Pageable pageable);

}
