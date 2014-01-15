/**
* @(#) ForgeProjectModuleService.java - Jeet Hub Forge
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

import java.util.List;
import java.util.Map;

import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.forge.domain.base.model.project.ForgeProjectModule;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectModuleService extends EntityService<ForgeProjectModule, Long> {
	
	/**
	 * Search a forge project module by its key and its project
	 * 
	 * @param key
	 * @param projectId
	 * @return
	 */
	ForgeProjectModule findByKey(String key, Long projectId);
	
	/**
	 * Find the {@link ForgeProjectModule}s by their parent id and organize them by their name.
	 * 
	 * @param parentId
	 * @return
	 */
	Map<String, ForgeProjectModule> findModulesByParent(Long parentId);

	/**
	 * Find the orphan {@link ForgeProjectModule}s organize them by their name.
	 * 
	 * @return
	 */
	Map<String, ForgeProjectModule> findOrphanModules();
	
	/**
	 * Find all the project modules that are on the specified version
	 * 
	 * @param forgeProjectVersionId
	 * @return
	 */
	List<ForgeProjectModule> findModulesOnProjectVersion(Long forgeProjectVersionId);

}
