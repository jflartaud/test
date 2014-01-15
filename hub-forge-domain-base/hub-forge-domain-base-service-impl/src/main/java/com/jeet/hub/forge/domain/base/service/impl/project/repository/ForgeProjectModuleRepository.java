/**
* @(#) ForgeProjectModuleRepository.java - Jeet Hub Forge
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

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jeet.domain.base.service.repository.jpa.JeetRepository;
import com.jeet.hub.forge.domain.base.model.project.ForgeProjectModule;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectModuleRepository extends JeetRepository<ForgeProjectModule, Long> {
	
	/**
	 * Search a forge project module by its key and its project
	 * 
	 * @param key
	 * @param projectId
	 * @return
	 */
	@Query("select m from ForgeProjectModule m join m.rootComponent r where m.key=(?1) and r.id=(?2)")
	ForgeProjectModule findByKey(String key, Long projectId);

	/**
	 * Find the {@link ForgeProjectModule}s by their parent id.
	 * 
	 * @param parentId
	 * @return
	 */
	@Query("select m from ForgeProjectModule m join m.parentComponent p where p.id=(?1)")
	List<ForgeProjectModule> findModulesByParent(Long parentId);
	
	/**
	 * Find the orphan {@link ForgeProjectModule}s.
	 * 
	 * @param parentId
	 * @return
	 */
	@Query("select m from ForgeProjectModule m where m.parentComponent is null")
	List<ForgeProjectModule> findOrphanModules();
	
	/**
	 * Find all the project modules that are on the specified version
	 * 
	 * @param forgeProjectVersionId
	 * @return
	 */
	@Query("select m from ForgeProjectModule m join m.versions version where version.id=(?1) and m.deleted=false")
	List<ForgeProjectModule> findModulesOnProjectVersion(Long forgeProjectVersionId);
}
