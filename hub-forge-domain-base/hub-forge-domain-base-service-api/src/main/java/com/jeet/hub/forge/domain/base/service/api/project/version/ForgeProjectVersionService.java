/**
* @(#) ForgeProjectVersionService.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 10 oct. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api.project.version;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectVersionService extends EntityService<ForgeProjectVersion, Long> {
	
	/**
	 * Retrieve a forge project version by its forge project and its complete version name
	 * 
	 * @param projectId
	 * @param completeName
	 * @return
	 */
	ForgeProjectVersion findForgeProjectVersion(Long projectId, String completeName);

	/**
	 * Retrieve all the previous version of a project version
	 * 
	 * @param forgeProjectVersionId
	 * @return
	 */
	@Transactional
	List<ForgeProjectVersion> findAllPreviousVersions(Long forgeProjectVersionId);
	
	/**
	 * Find the master project version
	 * 
	 * @param projectId
	 * @return
	 */
	ForgeProjectVersion findMasterForgeProjectVersion(Long projectId);
	
	/**
	 * Retrieve all the forge project versions for a forge project
	 * 
	 * @param projectId
	 * @param completeName
	 * @return
	 */
	List<ForgeProjectVersion> findAllByForgeProject(Long projectId);

}
