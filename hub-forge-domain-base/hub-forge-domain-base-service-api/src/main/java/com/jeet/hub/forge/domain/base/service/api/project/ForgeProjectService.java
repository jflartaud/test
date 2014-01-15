/**
* @(#) ForgeProjectService.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 mai 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api.project;

import org.springframework.transaction.annotation.Transactional;

import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;
import com.jeet.hub.forge.domain.base.service.api.project.exception.NotUniqueForgeProjectNameException;
import com.jeet.hub.forge.domain.base.service.api.project.exception.NotUniqueProjectTechNameException;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectService extends EntityService<ForgeProject, Long> {
	
	/**
	 * Retrieve a forge project by its technical name
	 * 
	 * @param technicalName
	 * @return
	 */
	ForgeProject findByTechnicalName(String technicalName);

	/**
	 * Test if a forge project exists by its name. The test ignores the case.
	 * 
	 * @param name
	 * @param technicalName
	 * @return
	 */
	boolean existByName(String name, Long forgeInstanceId);
	
	/**
	 * Test if a forge project exists by its technical name. The test ignores the case.
	 * 
	 * @param name
	 * @param technicalName
	 * @return
	 */
	boolean existByTechnicalName(String technicalName, Long forgeInstanceId);
	
	/**
	 * Create a forge project
	 * 
	 * @param project
	 * @param forgeInstanceId
	 * @return
	 * @throws NotUniqueForgeProjectNameException
	 * @throws NotUniqueForgeProjectTechnicalNameException
	 */
	ForgeProject createForgeProject(ForgeProject project, Long forgeInstanceId)
			throws NotUniqueForgeProjectNameException, NotUniqueProjectTechNameException;
	
	/**
	 * Update a forge project name (the technical name cannot be updated)
	 * 
	 * @param project
	 * @return
	 * @throws NotUniqueForgeProjectNameException
	 * @throws NotUniqueForgeProjectTechnicalNameException
	 */
	@Transactional
	ForgeProject updateForgeProjectName(Long forgeProjectId, String name) throws NotUniqueForgeProjectNameException;

	/**
	 * Delete forge project
	 * 
	 * @param forgeProjectId
	 */
	void deleteForgeProject(Long forgeProjectId);
	
	/**
	 * Retrieve all the forge projects associated to a forge instance
	 * 
	 * @param forgeInstanceId
	 * @param pagingLoadConfig
	 * @return
	 */
	PagingLoadResult<ForgeProject> findAllByForgeInstance(Long forgeInstanceId, PagingLoadConfig pagingLoadConfig);
	
	/**
	 * Update master version of forge project
	 */
	@Transactional
	ForgeProject updateMasterVersion(Long projectId);

}
