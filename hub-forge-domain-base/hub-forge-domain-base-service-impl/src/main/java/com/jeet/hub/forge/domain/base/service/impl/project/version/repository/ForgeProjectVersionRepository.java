/**
* @(#) ForgeProjectVersionRepository.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 10 oct. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.version.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jeet.domain.base.service.repository.jpa.JeetRepository;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectVersionRepository extends JeetRepository<ForgeProjectVersion, Long> {
	
	/**
	 * Retrieve a forge project version by its forge project and its complete version name
	 * 
	 * @param projectId
	 * @param completeName
	 * @return
	 */
	@Query("select v from ForgeProjectVersion v join v.project project where project.id=(?1) and v.deleted = false and v.completeName=(?2)")
	ForgeProjectVersion findForgeProjectVersion(Long projectId, String completeName);

	/**
	 * Find the master project version
	 * 
	 * @param projectId
	 * @return
	 */
	@Query("select v from ForgeProjectVersion v join v.project project where project.id=(?1) and v.deleted = false and v.master = true")
	ForgeProjectVersion findMasterForgeProjectVersion(Long projectId);
	
	/**
	 * Retrieve all the forge project versions for a forge project
	 * 
	 * @param projectId
	 * @param completeName
	 * @return
	 */
	@Query("select v from ForgeProjectVersion v join v.project project where project.id=(?1) and v.deleted = false")
	List<ForgeProjectVersion> findAllByForgeProject(Long projectId);

}
