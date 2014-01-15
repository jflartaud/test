/**
* @(#) ForgeProjectModuleServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 22 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.forge.domain.base.model.project.ForgeProjectModule;
import com.jeet.hub.forge.domain.base.service.api.project.ForgeProjectModuleService;
import com.jeet.hub.forge.domain.base.service.impl.project.repository.ForgeProjectModuleRepository;

/**
 * @author JF LARTAUD
 *
 */
public class ForgeProjectModuleServiceImpl extends AbstractBaseEntityService<ForgeProjectModule, Long> implements
		ForgeProjectModuleService {
	
	private ForgeProjectModuleRepository forgeProjectModuleRepository;

	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<ForgeProjectModule, Long> getCrudRepository() {
		return forgeProjectModuleRepository;
	}
	
	/**
	 * @return the forgeProjectModuleRepository
	 */
	public ForgeProjectModuleRepository getForgeProjectModuleRepository() {
		return forgeProjectModuleRepository;
	}
	
	/**
	 * @param forgeProjectModuleRepository the forgeProjectModuleRepository to set
	 */
	public void setForgeProjectModuleRepository(ForgeProjectModuleRepository forgeProjectModuleRepository) {
		this.forgeProjectModuleRepository = forgeProjectModuleRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectModuleService#findByKey(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public ForgeProjectModule findByKey(String key, Long projectId) {
		return forgeProjectModuleRepository.findByKey(key, projectId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectModuleService#findModulesByParent(java.lang.Long)
	 */
	@Override
	public Map<String, ForgeProjectModule> findModulesByParent(Long parentId) {
		List<ForgeProjectModule> modules = forgeProjectModuleRepository.findModulesByParent(parentId);
		return rangeByName(modules);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectModuleService#findOrphanModules()
	 */
	@Override
	public Map<String, ForgeProjectModule> findOrphanModules() {
		List<ForgeProjectModule> modules = forgeProjectModuleRepository.findOrphanModules();
		return rangeByName(modules);
	}

	/**
	 * Range the modules by their name
	 * 
	 * @param modules
	 * @return
	 */
	private Map<String, ForgeProjectModule> rangeByName(List<ForgeProjectModule> modules) {
		Map<String, ForgeProjectModule> modulesByKey = new HashMap<String, ForgeProjectModule>();
		if (modules != null && modules.isEmpty() == false) {
			for (ForgeProjectModule module : modules) {
				modulesByKey.put(module.getName(), module);
			}
		}
		return modulesByKey;
		
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.ForgeProjectModuleService#findModulesOnProjectVersion(java.lang.
	 * Long)
	 */
	@Override
	public List<ForgeProjectModule> findModulesOnProjectVersion(Long forgeProjectVersionId) {
		return forgeProjectModuleRepository.findModulesOnProjectVersion(forgeProjectVersionId);
	}

}
