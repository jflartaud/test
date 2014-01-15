/**
* @(#) ForgeProjectVersionModuleServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 4 déc. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.version;

import java.util.HashSet;
import java.util.List;

import com.jeet.domain.base.service.impl.AbstractBaseMetaService;
import com.jeet.hub.forge.domain.base.model.project.ForgeProjectModule;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;
import com.jeet.hub.forge.domain.base.service.api.project.ForgeProjectModuleService;
import com.jeet.hub.forge.domain.base.service.api.project.version.ForgeProjectVersionModuleService;

/**
 * @author JF LARTAUD
 *
 */
public class ForgeProjectVersionModuleServiceImpl extends AbstractBaseMetaService implements
		ForgeProjectVersionModuleService {
	
	private ForgeProjectModuleService forgeProjectModuleService;
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.version.ForgeProjectVersionModuleService#synchronizeModules(com.
	 * jeet.hub.forge.domainmodel.forge.project.version.ForgeProjectVersion,
	 * com.jeet.hub.forge.domainmodel.forge.project.version.ForgeProjectVersion)
	 */
	@Override
	public void synchronizeModules(ForgeProjectVersion version, ForgeProjectVersion previousVersion) {
		if (previousVersion != null) {
			List<ForgeProjectModule> modules = forgeProjectModuleService.findModulesOnProjectVersion(previousVersion
					.getId());
			if (modules != null) {
				for (ForgeProjectModule module : modules) {
					if (module.getVersions() == null) {
						module.setVersions(new HashSet<ForgeProjectVersion>());
					}
					module.getVersions().add(version);
				}
				forgeProjectModuleService.save(modules);
			}
		}
	}
	
	/**
	 * @return the forgeProjectModuleService
	 */
	public ForgeProjectModuleService getForgeProjectModuleService() {
		return forgeProjectModuleService;
	}
	
	/**
	 * @param forgeProjectModuleService the forgeProjectModuleService to set
	 */
	public void setForgeProjectModuleService(ForgeProjectModuleService forgeProjectModuleService) {
		this.forgeProjectModuleService = forgeProjectModuleService;
	}
	
	
		
}
